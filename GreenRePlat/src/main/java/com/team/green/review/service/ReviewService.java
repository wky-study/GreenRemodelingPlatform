package com.team.green.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.review.dao.IReviewDAO;
import com.team.green.review.dto.ReviewDTO;

@Service
public class ReviewService {

	
	@Autowired
	IReviewDAO dao;

	// 글 목록 가져오기
	public List<ReviewDTO> getReviewList(SearchVO search){
		List<ReviewDTO> result = dao.getReviewList(search);
		return result;
	}
	
	// 글 총 갯수 가져오기
	public int getReviewCount(SearchVO search) {
		int result = dao.getReviewCount(search);
		return result;
	};
	
	// 글 한개 조회 하기
	public ReviewDTO getReview(int no) throws BizNotFoundException {
		ReviewDTO result = dao.getReview(no);
		
		if(result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다.", "API_001");
		}
		
		return result;
	};
	
	// 글 작성하기
	public int writeReview(ReviewDTO review) {
		int result = dao.writeReview(review);
		return result;
	};
	
	// 리뷰게시글 조회수 업데이트
	public int reviewCountUp(int no) {
		int result = dao.reviewCountUp(no);
		return result;
	};
	
	// 리뷰게시글 수정
	public int updateReview(ReviewDTO review) {
		int result = dao.updateReview(review);
		return result;
		
	}
	
	// 리뷰 게시글 삭제
	public int deleteReview(int reviewNo) {
		int result = dao.deleteReview(reviewNo);
		return result;
	};
	
	// 탈퇴 회원 아이디 null 값 변경
	public int noMemIdReview(String memId) {
		int result = dao.noMemIdReview(memId);
		return result;
	};
}
