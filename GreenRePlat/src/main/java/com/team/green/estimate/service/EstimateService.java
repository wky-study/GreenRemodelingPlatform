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

	// ������ ���� ���� Ȯ��
	public int countEstimateByCriteria(EstimateDTO estimate) {
		int result = dao.countEstimateByCriteria(estimate);
		return result;
	};
	
	// �ӽð����� ����
	public int insertEstimate(EstimateDTO estimate) {
		int result = dao.insertEstimate(estimate);
		return result;
	};
	
	// �ӽð����� ����
	public int updateEstimate(EstimateDTO estimate) {
		int result = dao.updateEstimate(estimate);
		return result;
	};
	
	// �ӽð����� �Ѱ� Ŭ����
	public EstimateDTO getEst(int estId) {
		EstimateDTO result = dao.getEst(estId);
		return result;
	};
	
	// ���� ����
	public int updateEst(EstimateDTO estimate) {
		int result = dao.updateEst(estimate);
		return result;
	};
	
	// �ӽð����� ����Ʈ
	public List<EstimateDTO> getMemEstList(String memId){
		List<EstimateDTO> result = dao.getMemEstList(memId);
		return result;
	};
	
	// ������ ������ estId ��������
	public int getEstId() {
		int result = dao.getEstId();
		return result;
	};
	
	// �����ϱ� Ŭ���� ������Ʈ
	public int estSubmit(EstimateDTO estimate) {
		int result = dao.estSubmit(estimate);
		return result;
	};
	
	// ���� �Ϸ��� �ӽð����� ����Ʈ
	public List<EstimateDTO> getMemSubList(String memId){
		List<EstimateDTO> result = dao.getMemSubList(memId);
		return result;
	};
	
	// ���� �Ϸ��� �ӽð����� ����Ʈ (��� ����)
	public List<EstimateDTO> getComSubList(){
		List<EstimateDTO> result = dao.getComSubList();
		return result;
	};
	
}
