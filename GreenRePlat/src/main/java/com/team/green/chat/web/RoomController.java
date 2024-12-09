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

	// 채팅방 목록 화면
	@RequestMapping("/chatListView")
	public String chatListView(Model model, HttpSession session) {
		
		// 로그인된 아이디 가져오기
		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");
		String memId = login.getMemId();
		
		List<MemberDTO> memList = memberService.getMemList();
		List<RoomDTO> roomList = roomService.getRoomList(memId);
		
		// 각 채팅방 읽지않은 메세지 수 확인
		Map<Integer, Integer> unreadCounts = new HashMap<>();
		for (RoomDTO room : roomList) {
            int unreadCount = chatLogService.getUnreadChat(room.getRoomNo(), memId);
            unreadCounts.put(room.getRoomNo(), unreadCount); // 채팅방 번호를 키로 설정
        }
		System.out.println("새로운 메시지 방 번호 및 메시지 개수:" + unreadCounts);
		
		model.addAttribute("keyMember", login);
		model.addAttribute("roomList", roomList);
		model.addAttribute("memList", memList);
		model.addAttribute("unreadCounts", unreadCounts);
		
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
	
	// 채팅방 생성 (AJAX)
	@PostMapping("/roomCreateDo2")
	@ResponseBody
	public Map<String, Object> roomCreateDo2(@RequestBody RoomDTO room, HttpSession session) {
	    Map<String, Object> response = new HashMap<>();

	    try {
	        MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	        // 로그인 여부 확인 후 임의의 값 설정
	        if (login == null) {
	            room.setMemId("testId");   // 임의로 설정할 memId 값
	            room.setMemNick("임시닉네임"); // 임의로 설정할 memNick 값
	        } else {
	            room.setMemId(login.getMemId());
	            room.setMemNick(login.getMemNick());
	        }
	        
	        RoomDTO existingRoom = roomService.findRoom(room.getMemId(), room.getPartMem());

		    if (existingRoom != null) {
		        // 기존 채팅방이 존재하는 경우 해당 채팅방으로 이동
		    	System.out.println("기존 방 번호 확인: " + existingRoom.getRoomNo());
		    } else {		    	
		    	roomService.createRoom(room);
		    }

	        response.put("success", true);
	        response.put("message", "방 생성 완료");
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.put("success", false);
	        response.put("message", "방 생성 중 오류가 발생했습니다.");
	    }

	    return response; // JSON 형태로 응답
	}
	
	@RequestMapping("/requestChat")
	public String requestChat(String partMem, HttpSession session, Model model) {
	    MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

	    if (login == null) {
	        return "redirect:/loginView";
	    }

	    // 로그인된 사용자 정보
	    String memId = login.getMemId();
	    String memNick = login.getMemNick();

	    // 기존 방 존재 여부 확인
	    RoomDTO existingRoom = roomService.findRoom(memId, partMem);

	    if (existingRoom != null) {
	        // 기존 채팅방이 존재하는 경우 해당 채팅방으로 이동
	    	System.out.println("기존 방 번호 확인: " + existingRoom.getRoomNo());
	        return "redirect:/chatView?no=" + existingRoom.getRoomNo();
	    }

	    // 기존 채팅방이 없는 경우 새로 생성
	    String partMemNick = memberService.searchMember(partMem).getMemNick();
	    RoomDTO room = new RoomDTO();
	    room.setMemId(memId);
	    room.setMemNick(memNick);
	    room.setPartMem(partMem);
	    room.setRoomName(memNick + "님과 " + partMemNick + "님의 채팅방");

	    roomService.createRoom(room);

	    return "redirect:/chatListView"; // 채팅방 목록 페이지로 이동
	}
	
	@RequestMapping("/getDelYn")
	@ResponseBody
	public String getDelYn(@RequestParam("RoomNo") int no) {
	    // roomNo를 이용해 RoomDTO를 가져옵니다.
	    RoomDTO room = roomService.getRoom(no);
	    System.out.println(room);
	    
	    // delYn 값을 반환합니다.
	    return room.getDelYn();  // 예: "1", "2" 등의 값
	}

	
	
}
