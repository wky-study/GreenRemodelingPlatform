package com.team.green.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.chat.dto.RoomDTO;
import com.team.green.member.dto.MemberDTO;



@Mapper
public interface IRoomDAO {
	
//	// ä�ù� ��� ��������
//	public List<RoomDTO> getRoomList();
	
	// Ư�� ������� ä�ù� ��� ��������
    List<RoomDTO> getRoomList(@Param("memId") String memId);

	// �ش� ä�ù� ���� ��������
	public RoomDTO getRoom(int roomNo);
	
	// ä�ù� �����ϱ�
	public int createRoom(RoomDTO room);
	
	// ä�ù� �����ϱ�
	public int deleteRoom(int roomNo);
	
}
