package com.team.green.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
	
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}
}
