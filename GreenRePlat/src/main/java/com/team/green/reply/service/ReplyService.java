package com.team.green.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.reply.dao.IReplyDAO;
import com.team.green.reply.dto.ReplyDTO;


@Service
public class ReplyService {

	@Autowired
	IReplyDAO dao;
	
	// ��� �ۼ� 
	public int insertReply(ReplyDTO reply) {
		int result = dao.insertReply(reply);
		return result;
	}
	
	// ��� ��ȸ 
	public ReplyDTO getReply(String reply) {
		ReplyDTO result = dao.getReply(reply);
		return result;
	}

	// Ư�� �Խñ��� ��� ��� ��ȸ
	public List<ReplyDTO> getReplyList(ReplyDTO reply){
		List<ReplyDTO> result = dao.getReplyList(reply);
		return result;
	}
	
	// ��� ����
	public int deleteReply(String replyNo) {
		int result = dao.deleteReply(replyNo);
		return result;
	}
	
	// �ش� �Խñ� ��� ���� ��������
	public int replyCount(int replyNo) {
		int result = dao.replyCount(replyNo);
		return result;
	};
	
}
