package com.team.green.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.reply.dto.ReplyDTO;


@Mapper
public interface IReplyDAO {


	// 댓글 등록 (INSERT)
	int insertReply(ReplyDTO reply);
	
	// 댓글 조회 (SELECT, WHERE replyNo)
	ReplyDTO getReply(String reply);
	
	// 특정 게시글에 대한 댓글 목록 조회 (SELECT, WHERE boardNo)
	List<ReplyDTO> getReplyList(ReplyDTO reply);
	
	// 댓글 삭제 처리 (UPDATE)
	int deleteReply(String replyNo);
	
	// 해당 게시글 댓글 개수 가져오기
	int replyCount(int replyNo);
	
}
