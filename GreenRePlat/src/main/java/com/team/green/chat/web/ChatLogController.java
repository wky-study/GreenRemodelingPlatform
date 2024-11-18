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
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.chat.dto.ChatLogDTO;
import com.team.green.chat.dto.RoomDTO;
import com.team.green.chat.service.ChatLogService;
import com.team.green.chat.service.RoomService;

@Controller
public class ChatLogController {
	
	@Autowired
	ChatLogService chatService;
	
	@Autowired
	RoomService roomService;

	// 채팅화면으로 이동
	@RequestMapping("/chatView")
	public String chat(Model model, int no) {
		
		// 로그인 안했으면 로그인 화면으로 보내기
		// servlet-context.xml 의 LoginCheckInterceptor 설정에 /chatView 주소 등록
		
		List<ChatLogDTO> chatList = chatService.getChatList(no);
		RoomDTO room = roomService.getRoom(no);
		
		model.addAttribute("room", room);
		model.addAttribute("chatList", chatList);
		
		return "chat/chatView";
	}
	
	// 해당 채팅방의 채팅 내역들 가져오기 (ajax 요청 응답)
	@ResponseBody
	@RequestMapping("/getChatList")
	public List<ChatLogDTO> selectChatList(int no) {
		List<ChatLogDTO> result = chatService.getChatList(no);
		System.out.println(result);
		return result;
	}
	
	// 채팅 메시지 전달
	@MessageMapping("/hello/{roomNo}")
	@SendTo("/subscribe/chat/{roomNo}")
	public ChatLogDTO broadcasting(ChatLogDTO chat) {
	    
	    // ChatLogDTO 필드 값 확인용
	    System.out.println("방 번호: " + chat.getRoomNo());

	    // 넘어온 채팅 문구(chat)를 DB에 저장
	    chatService.insertChat(chat);
	    
	    // 상대방에게 전달될 chat 객체 내부에 현재 날짜를 채워주기
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    chat.setSendDate(sdf.format(new Date()));
	    
	    // 상대방에게 전달
	    return chat;
	}
	
	@GetMapping("/downloadChatLog")
	public ResponseEntity<InputStreamResource> downloadChatLog(int no) throws IOException {
	    // 1. DB에서 채팅 데이터 가져오기
	    List<ChatLogDTO> chatLogs = chatService.getChatList(no);

	    // 2. 텍스트 파일 생성
	    StringBuilder sb = new StringBuilder();
//	    sb.append("보낸 날짜\t보낸 사람\t닉네임\t메시지\n"); // 헤더 추가

	    // 채팅 내역 데이터를 텍스트에 추가
	    for (ChatLogDTO chatLog : chatLogs) {
	        sb.append("[")
	          .append(chatLog.getSendDate()).append("]\n")
//	          .append(chatLog.getMemId()).append("\t")
	          .append(chatLog.getMemNick()).append(" 님이 보낸 내용: ")
	          .append(chatLog.getChatMsg()).append("\n");
	    }

	    // 첫 번째 채팅 내역에서 memNick 추출 (파일 이름에 사용)
	    String memNick = chatLogs.get(0).getMemNick(); // 첫 번째 채팅 로그의 닉네임

	    // 3. 텍스트 파일을 생성하여 임시 파일에 기록
	    File tmpFile = File.createTempFile("ChatLog_", ".txt");
	    try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(tmpFile), StandardCharsets.UTF_8)) {
	        writer.write(sb.toString());
	    }

	    // 4. 클라이언트에게 파일 반환
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(tmpFile) {
	        @Override
	        public void close() throws IOException {
	            super.close();
	            tmpFile.delete(); // 파일 사용 후 삭제
	        }
	    });

	    // 파일 이름 설정 (UTF-8 인코딩을 통해 한글 처리)
	    String downloadFileName = URLEncoder.encode(memNick + "님 과의 채팅.txt", StandardCharsets.UTF_8.toString());
	    downloadFileName = downloadFileName.replace("+", "%20"); // 공백을 %20으로 변환

	    return ResponseEntity.ok()
	            .contentLength(tmpFile.length())
	            .contentType(MediaType.TEXT_PLAIN)
	            .header("Content-Disposition", "attachment;filename=" + downloadFileName)
	            .body(resource);
	}



}