package com.team.green.compage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dto.CompageDTO;

@Mapper
public interface ICompageDAO {
	// ���� �Խ��� �� ��� ��������
		List<CompageDTO> getReviewList(SearchVO search);
		
		// ���� �Խ��� �� �� ���� ��������
		int getReviewCount(SearchVO search);
		
		// ���� �Խñ� �Ѱ� ��ȸ �ϱ�
		CompageDTO getReview(int no);
		
		// ���� �Խñ� �ۼ��ϱ�
		int writeReview(CompageDTO review);
		
		// ���� �Խñ� ��ȸ�� ������Ʈ
		int reviewCountUp(int no);
		
		// ���� �Խñ� ����
		int updateReview(CompageDTO review);
		
		// ���� �Խñ� ����
		int deleteReview(int reviewNo);
		
}
