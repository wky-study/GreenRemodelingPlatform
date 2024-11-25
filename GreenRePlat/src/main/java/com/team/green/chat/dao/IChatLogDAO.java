package com.team.green.chat.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.green.chat.dto.ChatLogDTO;

@Mapper
public interface IChatLogDAO {
	
	// 해당 채팅방의 채팅내역 가져오기
	public List<ChatLogDTO> getChatList(int roomNo);
	
	// 채팅내역 DB에 저장
	public int insertChat(ChatLogDTO chatLog);
	
	// 읽지 않은 메시지 수
	int getUnreadChat(@Param("roomNo")int roomNo, @Param("memId")String memId);

	// 메시지 읽음 처리
    int readUpdate(@Param("roomNo")int roomNo, @Param("memId")String memId);

}




