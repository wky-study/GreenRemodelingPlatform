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
    	
        return result;  // XML���� ���ǵ� ���� ȣ��
    }
    
    
    public int editPlan(PlanDTO plan) { // ���� ����
    	int result = dao.editPlan(plan);
    	return result;
    }
    
    public int writeCont(ContDTO contents) { // ���������� �߰� 
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
        return result; // DB ���� ����
    }

 
    	
    

}
