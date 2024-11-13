package com.team.green.plan.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlanController {
	
	
	
	@RequestMapping("/planView")
	public String planView(Model model) {
		
		return "plan/planView";
		
	}

}
