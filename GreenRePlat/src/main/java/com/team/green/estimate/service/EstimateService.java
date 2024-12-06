package com.team.green.estimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.estimate.dao.IEstimateDAO;
import com.team.green.estimate.dto.EstimateDTO;
import com.team.green.member.dto.MemberDTO;

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
	public List<EstimateDTO> getComSubList(MemberDTO member){
		List<EstimateDTO> result = dao.getComSubList(member);
		return result;
	};
	
	// 시공사 정보 업데이트
	public int updateComId(EstimateDTO estimate) {
		int result = dao.updateComId(estimate);
		return result;
	};
	
	// 모델링한 타입 업데이트
	public int updateType(EstimateDTO estimate) {
		int result = dao.updateType(estimate);
		return result;
	};
	
	// 면적값 없을때 업데이트
	public int estErr(int estId) {
		int result = dao.estErr(estId);
		return result;
	};
	
	// 종료날짜 계산
    public int calculateConstructionPeriod(double squareMeter) {
        if (squareMeter <= 66) {
            return 7; // 7일 = 1주
        } else if (squareMeter <= 132) {
            return 14; // 14일 = 2주
        } else if (squareMeter <= 198) {
            return 21; // 21일 = 3주
        } else {
            // 198㎡ 초과: 기본 4주 + 추가 계산
            int extraDays = (int)((squareMeter - 198) / 33) * 2; // 33㎡당 2일 추가
            return 28 + extraDays;
        }
    }
	
}
