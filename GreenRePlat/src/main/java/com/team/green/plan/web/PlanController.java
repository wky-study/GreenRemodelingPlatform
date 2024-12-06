package com.team.green.plan.web;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.green.estimate.dto.EstimateDTO;
import com.team.green.estimate.service.EstimateService;
import com.team.green.member.dto.MemberDTO;
import com.team.green.plan.dao.IPlanDAO;
import com.team.green.plan.dto.ContDTO;
import com.team.green.plan.dto.PlanDTO;
import com.team.green.plan.service.PlanService;

import lombok.extern.slf4j.Slf4j;
import oracle.sql.json.OracleJsonParser.Event;

@Slf4j
@Controller
public class PlanController {
	
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private EstimateService estSvc ;
	
	@RequestMapping("/planView")
	public String planView(Model model, HttpSession session) {

		MemberDTO member= (MemberDTO)session.getAttribute("memInfo");
		
		if (member == null) {
			return "redirect:/loginView"; // 로그인 페이지로 리다이렉트
		}
		
		List<EstimateDTO> estList = null;
		String memId = member.getMemId();
		String memType = member.getMemType();

		if (memType.equals("5") || memType.equals("0")) {
			estList = estSvc.getComSubList(member);
			System.out.println("여기로옴");
		} else {
			estList = estSvc.getMemSubList(memId);
		}
		
		model.addAttribute("estList", estList);
		
//		List<PlanDTO> planList = planService.getPlanList(login);
//
//        model.addAttribute("planList", planList);
//        System.out.println();
//        System.out.println("플랜리스트:"+planList);

		
		
		return "plan/planView";
		
	}
	
	
	@PostMapping("/planEditDo")
	public String planEditDo(PlanDTO plan) {
		System.out.println("/planEditDo");
		System.out.println("플랜"+plan);
		planService.editPlan(plan);
		

		return "redirect:/planView";
		
	}
	@ResponseBody
	@RequestMapping("/writeContDo")
	public ContDTO writeContDo(ContDTO contents) {
		System.out.println();
		System.out.println("콘탠츠"+contents);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		String uniqueId = sdf.format(date);
		for(int i = 0; i < 3; i++) {
			uniqueId += (int)(Math.random() * 10);
		}
		
		contents.setContNo(uniqueId);
		planService.writeCont(contents);
		ContDTO result = planService.getCont(uniqueId);
		return result;
		
	}
	
	@ResponseBody
	@GetMapping("/getData") // AJAX 요청을 처리할 URL
    public List<ContDTO> getData(@RequestParam(required = false) int quoId) {
        // DB에서 데이터 가져오기
        List<ContDTO> dataList = planService.getData(quoId);
        return dataList; // JSON 형태로 반환
    }

	
	
		
		
		


	

	


}
