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
import com.team.green.member.service.MemberService;

@Controller
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	MemberService memberService;
	

	// ä�ù� ��� ȭ��
	@RequestMapping("/chatListView")
	public String chatListView(Model model, HttpSession session) {
		
		// �α��ε� ���̵� ��������
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		String memId = login.getMemId();
		
		List<MemberDTO> memList = memberService.getMemList();
		List<RoomDTO> roomList = roomService.getRoomList(memId);
//		List<RoomDTO> roomList = roomService.getRoomList();
		model.addAttribute("roomList", roomList);
		model.addAttribute("memList", memList);
		
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
	
	 @RequestMapping("/requestChat")
	    public String requestChat(String partMem, HttpSession session, Model model) {
	        MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
	        
//	        if (login == null) {
//	            return "redirect:/loginView";
//	        }

	        // �� ���� ��, ��û���� ����� ID�� partMem�� ����
	        RoomDTO room = new RoomDTO();
	        room.setMemId(login.getMemId());
	        room.setMemNick(login.getMemNick());
	        room.setPartMem(partMem);  // ��û���� ��� ID
	        room.setRoomName(login.getMemNick() + "��" + partMem + "���� ä�ù�");

	        // �� ���� ȣ��
	        roomService.createRoom(room);

	        return "redirect:/chatListView";  // �� ����Ʈ �������� �����̷�Ʈ
	    }
	
	
}
