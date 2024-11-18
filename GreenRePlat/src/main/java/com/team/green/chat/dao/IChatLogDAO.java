package com.team.green.chat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.team.green.chat.dto.ChatLogDTO;

@Mapper
public interface IChatLogDAO {
	
	// 해당 채팅방의 채팅내역 가져오기
	public List<ChatLogDTO> getChatList(int roomNo);
	
	// 채팅내역 DB에 저장
	public int insertChat(ChatLogDTO chatLog);
	

}




