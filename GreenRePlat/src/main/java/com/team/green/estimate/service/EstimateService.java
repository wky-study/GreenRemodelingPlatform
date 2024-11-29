package com.team.green.estimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.estimate.dao.IEstimateDAO;
import com.team.green.estimate.dto.EstimateDTO;

@Service
public class EstimateService {
	
	@Autowired
	IEstimateDAO dao;

	// 데이터 존재 여부 확인
	public int countEstimateByCriteria(EstimateDTO estimate) {
		int result = dao.countEstimateByCriteria(estimate);
		return result;
	};
	
	// 임시견적서 생성
	public int insertEstimate(EstimateDTO estimate) {
		int result = dao.insertEstimate(estimate);
		return result;
	};
	
	// 임시견적서 수정
	public int updateEstimate(EstimateDTO estimate) {
		int result = dao.updateEstimate(estimate);
		return result;
	};
	
	// 임시견적서 한개 클릭시
	public EstimateDTO getEst(int estId) {
		EstimateDTO result = dao.getEst(estId);
		return result;
	};
	
	// 최종 수정
	public int updateEst(EstimateDTO estimate) {
		int result = dao.updateEst(estimate);
		return result;
	};
	
	// 임시견적서 리스트
	public List<EstimateDTO> getMemEstList(String memId){
		List<EstimateDTO> result = dao.getMemEstList(memId);
		return result;
	};
	
	// 생성할 견적서 estId 가져오기
	public int getEstId() {
		int result = dao.getEstId();
		return result;
	};
	
	// 제출하기 클릭시 업데이트
	public int estSubmit(EstimateDTO estimate) {
		int result = dao.estSubmit(estimate);
		return result;
	};
	
	// 제출 완료한 임시견적서 리스트
	public List<EstimateDTO> getMemSubList(String memId){
		List<EstimateDTO> result = dao.getMemSubList(memId);
		return result;
	};
	
	// 제출 완료한 임시견적서 리스트 (기업 전용)
	public List<EstimateDTO> getComSubList(){
		List<EstimateDTO> result = dao.getComSubList();
		return result;
	};
	
}
