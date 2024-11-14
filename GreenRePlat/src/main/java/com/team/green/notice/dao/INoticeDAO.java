package com.team.green.notice.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.notice.dto.NoticeDTO;

@Mapper
public interface INoticeDAO {
	// 리뷰 게시판 글 목록 가져오기
	List<NoticeDTO> getNoticeList(SearchVO search);
	
	// 리뷰 게시판 글 총 갯수 가져오기
	int getNoticeCount(SearchVO search);
	
	// 리뷰 게시글 한개 조회 하기
	NoticeDTO getNotice(int no);
	
	// 리뷰 게시글 작성하기
	int writeNotice(NoticeDTO notice);
	
	// 리뷰 게시글 조회수 업데이트
	int noticeCountUp(int no);
	
	// 리뷰 게시글 수정
	int updateNotice(NoticeDTO notice);
	
	// 리뷰 게시글 삭제
	int noticeDeleteDo(int noticeNo);
	
	// 탈퇴 회원 아이디 null 값 변경
	int noMemIdNotice(String memId);
	
	// 게시글 번호 조회
	int getNoticeNo();
	

}
