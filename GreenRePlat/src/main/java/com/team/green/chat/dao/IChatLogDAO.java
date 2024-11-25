package com.team.green.chat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.chat.dto.ChatLogDTO;

@Mapper
public interface IChatLogDAO {
	
	// �ش� ä�ù��� ä�ó��� ��������
	public List<ChatLogDTO> getChatList(int roomNo);
	
	// ä�ó��� DB�� ����
	public int insertChat(ChatLogDTO chatLog);
	
	// ���� ���� �޽��� ��
	int getUnreadChat(@Param("roomNo")int roomNo, @Param("memId")String memId);

	// �޽��� ���� ó��
    int readUpdate(@Param("roomNo")int roomNo, @Param("memId")String memId);

}




