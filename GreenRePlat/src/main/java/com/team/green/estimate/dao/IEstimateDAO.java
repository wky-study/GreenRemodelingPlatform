package com.team.green.estimate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.green.estimate.dto.EstimateDTO;
import com.team.green.member.dto.MemberDTO;

@Mapper
public interface IEstimateDAO {
	
	// 데이터 존재 여부 확인
	int countEstimateByCriteria(EstimateDTO estimate);

	// 임시견적서 생성
	int insertEstimate(EstimateDTO estimate);
	
	// 임시견적서 수정
	int updateEstimate(EstimateDTO estimate);
	
	// 임시견적서 한개 클릭시
	EstimateDTO getEst(int estId);
	
	// 최종 수정
	int updateEst(EstimateDTO estimate);
	
	// 임시견적서 리스트
	List<EstimateDTO> getMemEstList(String memId);
	
	// 생성할 견적서 estId 가져오기
	int getEstId();
	
	// 제출하기 클릭시 업데이트
	int estSubmit(EstimateDTO estimate);
	
	// 제출 완료한 임시견적서 리스트
	List<EstimateDTO> getMemSubList(String memId);
	
	// 제출 완료한 임시견적서 리스트 (기업 전용)
	List<EstimateDTO> getComSubList(MemberDTO member);
}
