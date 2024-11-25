package com.team.green.plan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.green.member.dto.MemberDTO;
import com.team.green.plan.dao.IPlanDAO;
import com.team.green.plan.dto.PlanDTO;


@Service
public class PlanService {
	
	@Autowired
    IPlanDAO dao;
	
	
    public List<PlanDTO> getPlanList(MemberDTO member) {
    	List<PlanDTO> result = dao.getPlanList(member);
    	
        return result;  // XML에서 정의된 쿼리 호출
    }
    
    public PlanDTO getPlan(int quoId) {
    	PlanDTO result = dao.getPlan(quoId);
    	return result;
    	
    }
    
    public int editPlan(PlanDTO plan) {
    	int result = dao.editPlan(plan);
    	return result;
    }


}
