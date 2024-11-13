package com.team.green.compage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.common.exception.BizNotFoundException;
import com.team.green.common.vo.SearchVO;
import com.team.green.compage.dao.ICompageDAO;
import com.team.green.compage.dto.CompageDTO;

@Service
public class CompageService {

	
	@Autowired
	ICompageDAO dao;

	// �� ��� ��������
	public List<CompageDTO> getReviewList(SearchVO search){
		List<CompageDTO> result = dao.getReviewList(search);
		return result;
	}
	
	// �� �� ���� ��������
	public int getReviewCount(SearchVO search) {
		int result = dao.getReviewCount(search);
		return result;
	};
	
	// �� �Ѱ� ��ȸ �ϱ�
	public CompageDTO getReview(int no) throws BizNotFoundException {
		CompageDTO result = dao.getReview(no);
		
		if(result == null) {
			throw new BizNotFoundException("�ش� �Խñ��� ��ȣ�� �������� �ʽ��ϴ�.", "API_001");
		}
		
		return result;
	};
	
	// �� �ۼ��ϱ�
	public int writeReview(CompageDTO review) {
		int result = dao.writeReview(review);
		return result;
	};
	
	// ����Խñ� ��ȸ�� ������Ʈ
	public int reviewCountUp(int no) {
		int result = dao.reviewCountUp(no);
		return result;
	};
	
	// ����Խñ� ����
	public int updateReview(CompageDTO review) {
		int result = dao.updateReview(review);
		return result;
		
	}
	
	// ���� �Խñ� ����
	public int deleteReview(int reviewNo) {
		int result = dao.deleteReview(reviewNo);
		return result;
	};	
}
