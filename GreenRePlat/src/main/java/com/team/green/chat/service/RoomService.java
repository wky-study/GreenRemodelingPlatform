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
	
	public List<RoomDTO> getRoomList(){
		List<RoomDTO> result = dao.getRoomList();
		return result;
	};
	
	public RoomDTO getRoom(int roomNo) {
		RoomDTO result = dao.getRoom(roomNo);
		return result;
	};
	
	public int createRoom(RoomDTO room) {
		int result = dao.createRoom(room);
		return result;
	};
	
	
	public int deleteRoom(int roomNo) {
		int result = dao.deleteRoom(roomNo);
		return result;
	};
}
