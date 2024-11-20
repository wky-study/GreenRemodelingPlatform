package com.team.green.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.chat.dao.IRoomDAO;
import com.team.green.chat.dto.RoomDTO;
import com.team.green.member.dto.MemberDTO;

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
        // ��û���� ����� ID�� null�� ��츦 ó�� (�ӽ÷� �����ϰų� ���� ó�� ����)
        if (room.getPartMem() == null || room.getPartMem().isEmpty()) {
            // ���� ���, �ӽ÷� ����
            room.setPartMem("none");
        }
        
        return dao.createRoom(room);
    }
	
	public int deleteRoom(int roomNo) {
		int result = dao.deleteRoom(roomNo);
		return result;
	};
}
