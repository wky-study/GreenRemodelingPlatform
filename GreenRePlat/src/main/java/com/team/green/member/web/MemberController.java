package com.team.green.member.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memSvc;

	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	@PostMapping("/registDo")
	public String registMember(HttpServletRequest req) {
		String memName, memId, memPw, memRn, memAddress, memPhone, memNick, memType, memImg, comCeo, comBrc, comMaNm, comMaPn, memHp;
		Timestamp memDate;
		
		memName= req.getParameter("inputName");
		memId= req.getParameter("inputId");
		memPw= req.getParameter("inputPw");
		memRn= req.getParameter("inputRn");
		memAddress= req.getParameter("inputAddress");
		memPhone= req.getParameter("inputPhone");
		memNick= req.getParameter("inputNick");
		memType= req.getParameter("inputType");
		memImg= req.getParameter("inputImg");
		comCeo= req.getParameter("inputCeo");
		comBrc= req.getParameter("inputBrc");
		comMaNm= req.getParameter("inputMaNm");
		comMaPn= req.getParameter("inputMaPn");
		memHp= req.getParameter("inputHp");

		try {
			memDate = new Timestamp(new Date().getTime());
			MemberDTO member = new MemberDTO(memName, memId, memPw, memRn, memAddress, memPhone, memNick, memType, memImg, comCeo, comBrc, comMaNm, comMaPn, memHp, memDate);
			System.out.println("registMemberInfo: "+member);
			memSvc.registMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/registView";
	}
}
