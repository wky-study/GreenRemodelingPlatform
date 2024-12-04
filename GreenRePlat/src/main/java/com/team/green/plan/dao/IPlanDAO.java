package com.team.green.plan.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team.green.member.dto.MemberDTO;
import com.team.green.plan.dto.ContDTO;
import com.team.green.plan.dto.PlanDTO;

@Mapper
public interface IPlanDAO {
	
	List<PlanDTO> getPlanList(MemberDTO member);
	
	int editPlan(PlanDTO plan);
	
	
	int writeCont(ContDTO contents);
	ContDTO getCont(String contNo);
	List<ContDTO> getDataByQuoId(int quoId);

	int delCont(String contNo);
	
	


}
