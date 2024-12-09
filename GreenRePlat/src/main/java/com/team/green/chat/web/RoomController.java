package com.team.green.chat.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.chat.dto.RoomDTO;
import com.team.green.chat.service.ChatLogService;
import com.team.green.chat.service.RoomService;
import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;

@Controller
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ChatLogService chatLogService;

	// ä�ù� ��� ȭ��
	@RequestMapping("/chatListView")
	public String chatListView(Model model, HttpSession session) {
		
		// �α��ε� ���̵� ��������
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		String memId = login.getMemId();
		
		List<MemberDTO> memList = memberService.getMemList();
		List<RoomDTO> roomList = roomService.getRoomList(memId);
		
		// �� ä�ù� �������� �޼��� �� Ȯ��
		Map<Integer, Integer> unreadCounts = new HashMap<>();
		for (RoomDTO room : roomList) {
            int unreadCount = chatLogService.getUnreadChat(room.getRoomNo(), memId);
            unreadCounts.put(room.getRoomNo(), unreadCount); // ä�ù� ��ȣ�� Ű�� ����
        }
		System.out.println("���ο� �޽��� �� ��ȣ �� �޽��� ����:" + unreadCounts);
		
		model.addAttribute("keyMember", login);
		model.addAttribute("roomList", roomList);
		model.addAttribute("memList", memList);
		model.addAttribute("unreadCounts", unreadCounts);
		
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
	
	// ä�ù� ���� (AJAX)
	@PostMapping("/roomCreateDo2")
	@ResponseBody
	public Map<String, Object> roomCreateDo2(@RequestBody RoomDTO room, HttpSession session) {
	    Map<String, Object> response = new HashMap<>();

	    try {
	        MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	        // �α��� ���� Ȯ�� �� ������ �� ����
	        if (login == null) {
	            room.setMemId("testId");   // ���Ƿ� ������ memId ��
	            room.setMemNick("�ӽôг���"); // ���Ƿ� ������ memNick ��
	        } else {
	            room.setMemId(login.getMemId());
	            room.setMemNick(login.getMemNick());
	        }
	        
	        RoomDTO existingRoom = roomService.findRoom(room.getMemId(), room.getPartMem());

		    if (existingRoom != null) {
		        // ���� ä�ù��� �����ϴ� ��� �ش� ä�ù����� �̵�
		    	System.out.println("���� �� ��ȣ Ȯ��: " + existingRoom.getRoomNo());
		    } else {		    	
		    	roomService.createRoom(room);
		    }

	        response.put("success", true);
	        response.put("message", "�� ���� �Ϸ�");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("success", false);
	        response.put("message", "�� ���� �� ������ �߻��߽��ϴ�.");
	    }

	    return response; // JSON ���·� ����
	}
	
	@RequestMapping("/requestChat")
	public String requestChat(String partMem, HttpSession session, Model model) {
	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	    if (login == null) {
	        return "redirect:/loginView";
	    }

	    // �α��ε� ����� ����
	    String memId = login.getMemId();
	    String memNick = login.getMemNick();

	    // ���� �� ���� ���� Ȯ��
	    RoomDTO existingRoom = roomService.findRoom(memId, partMem);

	    if (existingRoom != null) {
	        // ���� ä�ù��� �����ϴ� ��� �ش� ä�ù����� �̵�
	    	System.out.println("���� �� ��ȣ Ȯ��: " + existingRoom.getRoomNo());
	        return "redirect:/chatView?no=" + existingRoom.getRoomNo();
	    }

	    // ���� ä�ù��� ���� ��� ���� ����
	    String partMemNick = memberService.searchMember(partMem).getMemNick();
	    RoomDTO room = new RoomDTO();
	    room.setMemId(memId);
	    room.setMemNick(memNick);
	    room.setPartMem(partMem);
	    room.setRoomName(memNick + "�԰� " + partMemNick + "���� ä�ù�");

	    roomService.createRoom(room);

	    return "redirect:/chatListView"; // ä�ù� ��� �������� �̵�
	}
	
	@RequestMapping("/getDelYn")
	@ResponseBody
	public String getDelYn(@RequestParam("RoomNo") int no) {
	    // roomNo�� �̿��� RoomDTO�� �����ɴϴ�.
	    RoomDTO room = roomService.getRoom(no);
	    System.out.println(room);
	    
	    // delYn ���� ��ȯ�մϴ�.
	    return room.getDelYn();  // ��: "1", "2" ���� ��
	}

	
	
}
