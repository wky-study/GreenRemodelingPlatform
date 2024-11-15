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

	
	
}
