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
import org.springframework.web.bind.annotation.RestController;

import com.team.green.member.dto.MemberDTO;
import com.team.green.plan.dto.PlanDTO;
import com.team.green.plan.service.PlanService;
import oracle.sql.json.OracleJsonParser.Event;

@Controller
public class PlanController {
	
	
	@Autowired
	private PlanService planService;
	
	@RequestMapping("/planView")
	public String planView(Model model, HttpSession session) {
		
		MemberDTO login= (MemberDTO)session.getAttribute("memInfo");
		String memId = login.getMemId();
		String memType = login.getMemType();
		List<PlanDTO> planList = planService.getPlanList(login);

        model.addAttribute("planList", planList);
        

		
		
		return "plan/planView";
		
	}
	
		
		
		


	

	


}
