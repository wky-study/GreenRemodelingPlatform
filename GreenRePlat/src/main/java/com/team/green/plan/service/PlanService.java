package com.team.green.plan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.member.dto.MemberDTO;
import com.team.green.plan.dao.IPlanDAO;
import com.team.green.plan.dto.ContDTO;
import com.team.green.plan.dto.PlanDTO;


@Service
public class PlanService {
	
	@Autowired
    IPlanDAO dao;
	
	
    public List<PlanDTO> getPlanList(MemberDTO member) {
    	List<PlanDTO> result = dao.getPlanList(member);
    	
        return result;  // XML에서 정의된 쿼리 호출
    }
    
    
    public int editPlan(PlanDTO plan) { // 일정 수정
    	int result = dao.editPlan(plan);
    	return result;
    }
    
    public int writeCont(ContDTO contents) { // 일정콘텐츠 추가 
    	int result = dao.writeCont(contents);
    	return result;
    }
    
    public ContDTO getCont(String contNo) {
    	ContDTO result = dao.getCont(contNo);
    	return result;
    }
    
    
    
    public int delCont(String contNo) {
    	int result = dao.delCont(contNo);
    	return result;
    }
    
    public List<ContDTO> getData(int quoId) {
    	List<ContDTO> result = dao.getDataByQuoId(quoId);
        return result; // DB 쿼리 실행
    }

 
    	
    

}
