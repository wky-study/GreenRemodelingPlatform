package com.team.green.chat.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.chat.dto.RoomDTO;
import com.team.green.chat.service.RoomService;
import com.team.green.member.dto.MemberDTO;

@Controller
public class RoomController {
	
	@Autowired
	RoomService roomService;

	// ä�ù� ��� ȭ��
	@RequestMapping("/chatListView")
	public String chatListView(Model model) {
		
		List<RoomDTO> roomList = roomService.getRoomList();
		model.addAttribute("roomList", roomList);
		
		return "chat/chatListView";
	}
	
	// ä�ù� ���� ȭ��
	@RequestMapping("/roomCreateView")
	public String roomCreateView(Model model, HttpSession session) {
		
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		System.out.println("�α��� �Ǿ�����?" + login);
		
		if(session.getAttribute("memInfo") == null) {
			return "redirect:/loginView";
		}
		
		return "chat/roomCreateView";
	}
	
	// ä�ù� ����
	@RequestMapping("/roomCreateDo")
	public String roomCreateDo(RoomDTO room, HttpSession session) {

	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	    // �α��� ���� Ȯ�� �� ������ �� ����
	    if (login == null) {
	        room.setMemId("testId");   // ���Ƿ� ������ memId ��
	        room.setMemNick("�ӽôг���"); // ���Ƿ� ������ memNick ��
	    } else {
	        room.setMemId(login.getMemId());
	        room.setMemNick(login.getMemNick());
	    }

	    roomService.createRoom(room);
	    System.out.println("�� ���� �Ϸ�");

	    return "redirect:/chatListView";
	}
	
	
}
