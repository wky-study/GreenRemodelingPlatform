package com.team.green.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.chat.dao.IRoomDAO;
import com.team.green.chat.dto.RoomDTO;

@Service
public class RoomService {

	@Autowired
	IRoomDAO dao;
	

	
//	public List<RoomDTO> getRoomList(){
//		List<RoomDTO> result = dao.getRoomList();
//		return result;
//	};
	
	public List<RoomDTO> getRoomList(String memId) {
        return dao.getRoomList(memId);
    }
	
//	public List<MemberDTO> getMemList(){
//		List<MemberDTO> result = dao.getMemList();
//		return result;
//	}
	
	public RoomDTO getRoom(int roomNo) {
		RoomDTO result = dao.getRoom(roomNo);
		return result;
	};
	
	public int createRoom(RoomDTO room) {
        // 신청받은 멤버의 ID가 null인 경우를 처리 (임시로 설정하거나 예외 처리 가능)
        if (room.getPartMem() == null || room.getPartMem().isEmpty()) {
            // 예를 들어, 임시로 설정
            room.setPartMem("none");
        }
        
        return dao.createRoom(room);
    }
	
	public int deleteRoom(int roomNo) {
		int result = dao.deleteRoom(roomNo);
		return result;
	};
	
	public RoomDTO findRoom(String memId, String partMem) {
	    return dao.findRoom(memId, partMem);
	}
	
	public int enterRoom(RoomDTO room) {
		int result = dao.enterRoom(room);
		return result;
	}

}
