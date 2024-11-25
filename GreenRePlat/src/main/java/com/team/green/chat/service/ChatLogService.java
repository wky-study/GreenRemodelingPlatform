package com.team.green.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.chat.dao.IChatLogDAO;
import com.team.green.chat.dto.ChatLogDTO;

@Service
public class ChatLogService {

	@Autowired
	IChatLogDAO dao;
	
	public List<ChatLogDTO> getChatList(int roomNo){
		List<ChatLogDTO> result = dao.getChatList(roomNo);
		return result;
	}
	
	public int insertChat(ChatLogDTO chatLog) {
		int result = dao.insertChat(chatLog);
		return result;
	}
	// 읽지 않은 메시지 수 가져오기
    public int getUnreadChat(int roomNo, String memId) {
    	int result = dao.getUnreadChat(roomNo, memId);
        return result;
    }

    // 메시지 읽음 처리
    public int readUpdate(int roomNo, String memId) {
    	int result = dao.readUpdate(roomNo, memId);
    	return result;
    }
	
}
