package com.team.green.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.chat.dto.RoomDTO;



@Mapper
public interface IRoomDAO {
	
	// ä�ù� ��� ��������
	public List<RoomDTO> getRoomList();

	// �ش� ä�ù� ���� ��������
	public RoomDTO getRoom(int roomNo);
	
	// ä�ù� �����ϱ�
	public int createRoom(RoomDTO room);
	
	// ä�ù� �����ϱ�
	public int deleteRoom(int roomNo);
	
}
