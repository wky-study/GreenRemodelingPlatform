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
	
	// 댓글 작성 
	public int insertReply(ReplyDTO reply) {
		int result = dao.insertReply(reply);
		return result;
	}
	
	// 댓글 조회 
	public ReplyDTO getReply(String reply) {
		ReplyDTO result = dao.getReply(reply);
		return result;
	}

	// 특정 게시글의 댓글 목록 조회
	public List<ReplyDTO> getReplyList(ReplyDTO reply){
		List<ReplyDTO> result = dao.getReplyList(reply);
		return result;
	}
	
	// 댓글 삭제
	public int deleteReply(String replyNo) {
		int result = dao.deleteReply(replyNo);
		return result;
	}
	
	// 해당 게시글 댓글 개수 가져오기
	public int replyCount(int replyNo) {
		int result = dao.replyCount(replyNo);
		return result;
	};
	
}
