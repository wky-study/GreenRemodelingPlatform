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
	

	// 채팅방 목록 화면
	@RequestMapping("/chatListView")
	public String chatListView(Model model, HttpSession session) {
		
		// 로그인된 아이디 가져오기
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		String memId = login.getMemId();
		
		List<MemberDTO> memList = memberService.getMemList();
		List<RoomDTO> roomList = roomService.getRoomList(memId);
//		List<RoomDTO> roomList = roomService.getRoomList();
		model.addAttribute("roomList", roomList);
		model.addAttribute("memList", memList);
		
		return "chat/chatListView";
	}
	
	// 채팅방 생성 화면
	@RequestMapping("/roomCreateView")
	public String roomCreateView(Model model, HttpSession session) {
		
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		System.out.println("로그인 되어있음?" + login);
		
		if(session.getAttribute("memInfo") == null) {
			return "redirect:/loginView";
		}
		
		return "chat/roomCreateView";
	}
	
	// 채팅방 생성
	@RequestMapping("/roomCreateDo")
	public String roomCreateDo(RoomDTO room, HttpSession session) {

	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	    // 로그인 여부 확인 후 임의의 값 설정
	    if (login == null) {
	        room.setMemId("testId");   // 임의로 설정할 memId 값
	        room.setMemNick("임시닉네임"); // 임의로 설정할 memNick 값
	    } else {
	        room.setMemId(login.getMemId());
	        room.setMemNick(login.getMemNick());
	    }

	    roomService.createRoom(room);
	    System.out.println("방 생성 완료");

	    return "redirect:/chatListView";
	}
	
	 @RequestMapping("/requestChat")
	    public String requestChat(String partMem, HttpSession session, Model model) {
	        MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
	        
//	        if (login == null) {
//	            return "redirect:/loginView";
//	        }

	        // 방 생성 시, 신청받은 멤버의 ID를 partMem에 설정
	        RoomDTO room = new RoomDTO();
	        room.setMemId(login.getMemId());
	        room.setMemNick(login.getMemNick());
	        room.setPartMem(partMem);  // 신청받은 멤버 ID
	        room.setRoomName(login.getMemNick() + "님" + partMem + "님의 채팅방");

	        // 방 생성 호출
	        roomService.createRoom(room);

	        return "redirect:/chatListView";  // 방 리스트 페이지로 리다이렉트
	    }
	
	
}
