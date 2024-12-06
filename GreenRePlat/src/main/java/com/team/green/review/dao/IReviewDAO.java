package com.team.green.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.review.dto.ReviewDTO;


@Mapper
public interface IReviewDAO {

	// 리뷰 게시판 글 목록 가져오기
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// 리뷰 게시판 글 총 갯수 가져오기
	int getReviewCount(SearchVO search);
	
	// 리뷰 게시글 한개 조회 하기
	ReviewDTO getReview(int no);
	
	// 리뷰 게시글 작성하기
	int writeReview(ReviewDTO review);
	
	// 리뷰 게시글 조회수 업데이트
	int reviewCountUp(int no);
	
	// 리뷰 게시글 수정
	int updateReview(ReviewDTO review);
	
	// 리뷰 게시글 삭제
	int deleteReview(int reviewNo);
	
	// 탈퇴 회원 아이디 null 값 변경
	int noMemIdReview(String memId);
	
	// 홈 화면용
	List<ReviewDTO> getHomeReview();
	
}
