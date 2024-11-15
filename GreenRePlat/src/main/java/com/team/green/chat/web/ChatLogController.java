package com.team.green.chat.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// ä��ȭ������ �̵�
	@RequestMapping("/chatView")
	public String chat(Model model, int no) {
		
		// �α��� �������� �α��� ȭ������ ������
		// servlet-context.xml �� LoginCheckInterceptor ������ /chatView �ּ� ���
		
		List<ChatLogDTO> chatList = chatService.getChatList(no);
		RoomDTO room = roomService.getRoom(no);
		
		model.addAttribute("room", room);
		model.addAttribute("chatList", chatList);
		
		return "chat/chatView";
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
	    
	    // ChatLogDTO �ʵ� �� Ȯ�ο�
	    System.out.println("�� ��ȣ: " + chat.getRoomNo());

	    // �Ѿ�� ä�� ����(chat)�� DB�� ����
	    chatService.insertChat(chat);
	    
	    // ���濡�� ���޵� chat ��ü ���ο� ���� ��¥�� ä���ֱ�
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    chat.setSendDate(sdf.format(new Date()));
	    
	    // ���濡�� ����
	    return chat;
	}

	
	
}
