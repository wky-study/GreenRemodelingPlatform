package com.team.green.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.review.dto.ReviewDTO;


@Mapper
public interface IReviewDAO {

	// ���� �Խ��� �� ��� ��������
	List<ReviewDTO> getReviewList(SearchVO search);
	
	// ���� �Խ��� �� �� ���� ��������
	int getReviewCount(SearchVO search);
	
	// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
	ReviewDTO getReview(int no);
	
	// ���� �Խñ� �ۼ��ϱ�
	int writeReview(ReviewDTO review);
	
	// ���� �Խñ� ��ȸ�� ������Ʈ
	int reviewCountUp(int no);
	
	// ���� �Խñ� ����
	int updateReview(ReviewDTO review);
	
	// ���� �Խñ� ����
	int deleteReview(int reviewNo);
	
	// Ż�� ȸ�� ���̵� null �� ����
	int noMemIdReview(String memId);
	
	// Ȩ ȭ���
	List<ReviewDTO> getHomeReview();
	
}
