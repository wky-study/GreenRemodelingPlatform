package com.team.green.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.chat.dto.RoomDTO;
import com.team.green.member.dto.MemberDTO;



@Mapper
public interface IRoomDAO {
	
//	// 채팅방 목록 가져오기
//	public List<RoomDTO> getRoomList();
	
	// 특정 사용자의 채팅방 목록 가져오기
    List<RoomDTO> getRoomList(@Param("memId") String memId);

	// 해당 채팅방 정보 가져오기
	public RoomDTO getRoom(int roomNo);
	
	// 채팅방 생성하기
	public int createRoom(RoomDTO room);
	
	// 채팅방 삭제하기
	public int deleteRoom(int roomNo);
	
}
