package com.team.green.member.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memSvc;
	
	
	/*	회원가입화면으로 이동
	 * 
	 */
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	/*	로그인화면으로 이동
	 * 
	 */
	@RequestMapping("/loginView")
	public String loginView() {
		return "member/loginView";
	}

	/*	회원수정화면으로 이동
	 * 
	 */
	@RequestMapping("/settingView")
	public String settingView() {
		return "member/settingView";
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
	/*	로그인 실행
	 * 
	 */
	@PostMapping("/loginDo")
	public String loginDo(MemberDTO member, HttpSession session, boolean rememberId, HttpServletResponse resp) {
		MemberDTO memInfo = memSvc.loginMember(member);
		System.out.println("rememberId: "+rememberId);
		session.setAttribute("memInfo", memInfo);
		if(rememberId) {
			Cookie cookie = new Cookie("rememberId", member.getMemId());
			resp.addCookie(cookie);

		}else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		return "redirect:/";
	}
	/*	로그아웃 실행
	 * 
	 */
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
