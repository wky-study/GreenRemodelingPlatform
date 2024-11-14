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
	public String chat(Model model, int roomNo) {
		
		// �α��� �������� �α��� ȭ������ ������
		// servlet-context.xml �� LoginCheckInterceptor ������ /chatView �ּ� ���
		
		List<ChatLogDTO> chatList = chatService.getChatList(roomNo);
		RoomDTO room = roomService.getRoom(roomNo);
		
		model.addAttribute("room", room);
		model.addAttribute("chatList", chatList);
		
		return "chat/chatView";
	}
	
	// �ش� ä�ù��� ä�� ������ �������� (ajax ��û ����)
	@ResponseBody
	@RequestMapping("/getChatList")
	public List<ChatLogDTO> selectChatList(int roomNo) {
		List<ChatLogDTO> result = chatService.getChatList(roomNo);
		System.out.println(result);
		return result;
	}
	
	// ä�� �޽��� ����
	// chatView���� ä�� ���� �Է� �� send ��ư ������ �� �޼ҵ尡 �����
	// return ���� "/subscribe/chat/{roomNo}" ��ũ�� subscribe ���� Ŭ���̾�Ʈ�� ���� [chatView.jsp �� client.subscribe(~~~~~) �κ�]
    @MessageMapping("/hello/{roomNo}")
    @SendTo("/subscribe/chat/{roomNo}")
    public ChatLogDTO broadcasting(ChatLogDTO chat) {

    	// �Ѿ�� ä�� ����(chat)�� DB�� ����
        chatService.insertChat(chat);
        
        // ���濡�� ���޵� chat ��ü ���ο� ���� ��¥�� ä���ֱ�
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        chat.setSendDate(sdf.format(new Date()));
        
        // ���濡�� ����
        return chat;
    }
	
	
}
