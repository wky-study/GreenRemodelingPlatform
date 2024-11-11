package com.team.green.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.reply.dto.ReplyDTO;


@Mapper
public interface IReplyDAO {


	// ��� ��� (INSERT)
	int insertReply(ReplyDTO reply);
	
	// ��� ��ȸ (SELECT, WHERE replyNo)
	ReplyDTO getReply(String reply);
	
	// Ư�� �Խñۿ� ���� ��� ��� ��ȸ (SELECT, WHERE boardNo)
	List<ReplyDTO> getReplyList(ReplyDTO reply);
	
	// ��� ���� ó�� (UPDATE)
	int deleteReply(String replyNo);
	
	// �ش� �Խñ� ��� ���� ��������
	int replyCount(int replyNo);
	
}
