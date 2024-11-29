package com.team.green.estimate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.estimate.dto.EstimateDTO;

@Mapper
public interface IEstimateDAO {
	
	// ������ ���� ���� Ȯ��
	int countEstimateByCriteria(EstimateDTO estimate);

	// �ӽð����� ����
	int insertEstimate(EstimateDTO estimate);
	
	// �ӽð����� ����
	int updateEstimate(EstimateDTO estimate);
	
	// �ӽð����� �Ѱ� Ŭ����
	EstimateDTO getEst(int estId);
	
	// ���� ����
	int updateEst(EstimateDTO estimate);
	
	// �ӽð����� ����Ʈ
	List<EstimateDTO> getMemEstList(String memId);
	
	// ������ ������ estId ��������
	int getEstId();
	
	// �����ϱ� Ŭ���� ������Ʈ
	int estSubmit(EstimateDTO estimate);
	
	// ���� �Ϸ��� �ӽð����� ����Ʈ
	List<EstimateDTO> getMemSubList(String memId);
	
}
