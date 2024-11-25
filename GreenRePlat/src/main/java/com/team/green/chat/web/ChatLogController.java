package com.team.green.chat.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.chat.dto.ChatLogDTO;
import com.team.green.chat.dto.RoomDTO;
import com.team.green.chat.service.ChatLogService;
import com.team.green.chat.service.RoomService;
import com.team.green.member.dto.MemberDTO;

@Controller
public class ChatLogController {
	
	@Autowired
	ChatLogService chatService;
	
	@Autowired
	RoomService roomService;

	// ä��ȭ������ �̵�
	@RequestMapping("/chatView")
	public String chat(Model model, int no, HttpSession session) {
		
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		String memId = login.getMemId();
		
		// �α��� �������� �α��� ȭ������ ������
		// servlet-context.xml �� LoginCheckInterceptor ������ /chatView �ּ� ���
		
		List<ChatLogDTO> chatList = chatService.getChatList(no);
		RoomDTO room = roomService.getRoom(no);
		System.out.println("��???:"+room);
		room.setDelYn((((int)(room.getDelYn().charAt(0)-'0')+1))+"");
		roomService.enterRoom(room);
		
		
		// �޽��� ���� ó��
	    int updatedRows = chatService.readUpdate(no, memId);
	    System.out.println("���� �޼��� ��: " + updatedRows);
		
		model.addAttribute("room", room);
		model.addAttribute("chatList", chatList);
		
		return "chat/chatView";
	}
	
	@RequestMapping("/esc")
	@ResponseBody
	public void chat(@RequestParam("roomNo") int no) {
		// �α��� �������� �α��� ȭ������ ������
		// servlet-context.xml �� LoginCheckInterceptor ������ /chatView �ּ� ���
		RoomDTO room = roomService.getRoom(no);
		
		System.out.println("����1"+room);
		room.setDelYn((((int)(room.getDelYn().charAt(0)-'0')-1))+"");
		roomService.enterRoom(room);
		
//		model.addAttribute("room", room);
		
		System.out.println("�� ����2 " + room);
		
//		return "chat/chatListView";
	}
	
	// �ش� ä�ù��� ä�� ������ �������� (ajax ��û ����)
	@ResponseBody
	@RequestMapping("/getChatList")
	public List<ChatLogDTO> selectChatList(int no) {
		List<ChatLogDTO> result = chatService.getChatList(no);
		System.out.println(result);
		return result;
	}
	
	// ä�� �޽��� ����
	@MessageMapping("/hello/{roomNo}")
	@SendTo("/subscribe/chat/{roomNo}")
	public ChatLogDTO broadcasting(ChatLogDTO chat) {
	    // ���� ���� del_yn �� ��ȸ
	    RoomDTO room = roomService.getRoom(chat.getRoomNo());
	    int delYn = Integer.parseInt(room.getDelYn());

	 // del_yn ���� 2 �̻��̸� "����"���� ����
	    String readYn = delYn >= 2 ? "Y" : "N"; 

	    // �޽����� readYn ���� ����
	    chat.setReadYn(readYn);

	    // ä�� ����
	    chatService.insertChat(chat);

	    // ���� ��¥ �߰�
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    chat.setSendDate(sdf.format(new Date()));

	    // �޽��� ����
	    return chat;
	}


	@MessageMapping("/state/{roomNo}")
	@SendTo("/subscribe/state/{roomNo}")
	public String stateCheck(String memId) {
	    
	    // ChatLogDTO �ʵ� �� Ȯ�ο�
	    System.out.println("���º������ " + memId);

	    // ���濡�� ����
	    return memId;
	}
	
	@GetMapping("/downloadChatLog")
	public ResponseEntity<InputStreamResource> downloadChatLog(int no) throws IOException {
	    // 1. DB���� ä�� ������ ��������
	    List<ChatLogDTO> chatLogs = chatService.getChatList(no);

	    // 2. �ؽ�Ʈ ���� ����
	    StringBuilder sb = new StringBuilder();

	    // ä�� ���� �����͸� �ؽ�Ʈ�� �߰�
	    for (ChatLogDTO chatLog : chatLogs) {
	        sb.append("[")
	          .append(chatLog.getSendDate()).append("]\n")
	          .append(chatLog.getMemNick()).append("(").append(chatLog.getMemId()).append(")").append(" ���� ���� ����: ")
	          .append(chatLog.getChatMsg()).append("\n");
	    }

	    // ù ��° ä�� �������� memNick ���� (���� �̸��� ���)
	    String memNick = chatLogs.get(0).getMemNick(); // ù ��° ä�� �α��� �г���

	    // 3. �ؽ�Ʈ ������ �����Ͽ� �ӽ� ���Ͽ� ���
	    File tmpFile = File.createTempFile("ChatLog_", ".txt");
	    try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(tmpFile), StandardCharsets.UTF_8)) {
	        writer.write(sb.toString());
	    }

	    // 4. Ŭ���̾�Ʈ���� ���� ��ȯ
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(tmpFile) {
	        @Override
	        public void close() throws IOException {
	            super.close();
	            tmpFile.delete(); // ���� ��� �� ����
	        }
	    });

	    // ���� �̸� ���� (UTF-8 ���ڵ��� ���� �ѱ� ó��)
	    String downloadFileName = URLEncoder.encode(memNick + "�� ���� ä��.txt", StandardCharsets.UTF_8.toString());
	    // �����̸��� +�� �پ�ͼ� �������� ����
	    downloadFileName = downloadFileName.replace("+", "%20"); 

	    return ResponseEntity.ok()
	            .contentLength(tmpFile.length())
	            .contentType(MediaType.TEXT_PLAIN)
	            .header("Content-Disposition", "attachment;filename=" + downloadFileName)
	            .body(resource);
	}



}