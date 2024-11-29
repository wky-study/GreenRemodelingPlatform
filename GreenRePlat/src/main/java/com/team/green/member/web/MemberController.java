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
import com.team.green.review.web.ReviewController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	MemberService memSvc;

	/*
	 * 약관페이지로 이동
	 * 
	 */
	@RequestMapping("/tacView")
	public String tacView() {
		return "member/tacView";
	}

	/*
	 * 회원가입화면으로 이동
	 * 
	 */
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	/*
	 * 로그인화면으로 이동
	 * 
	 */
	@RequestMapping("/loginView")
	public String loginView() {
		return "member/loginView";
	}

	/*
	 * 회원수정화면으로 이동
	 * 
	 */
	@RequestMapping("/settingView")
	public String settingView() {
		return "member/settingView";
	}

	@PostMapping("/registDo")
	public String registMember(HttpServletRequest req, Model model) {
		String memName, memId, memPw, memRn, memAddress, memPhone, memNick, memType, memImg, comCeo, comBrc, comMaNm,
				comMaPn, memHp, memEmail;
		Timestamp memDate;

		memName = req.getParameter("inputName");
		memId = req.getParameter("inputId");
		memPw = req.getParameter("inputPw");
		memRn = req.getParameter("inputRn");
		memAddress = req.getParameter("inputAddress");
		memPhone = req.getParameter("inputPhone");
		memNick = req.getParameter("inputNick");
		memType = req.getParameter("inputType");
		memImg = req.getParameter("inputImg");
		comCeo = req.getParameter("inputCeo");
		comBrc = req.getParameter("inputBrc");
		comMaNm = req.getParameter("inputMaNm");
		comMaPn = req.getParameter("inputMaPn");
		memHp = req.getParameter("inputHp");
		memEmail = req.getParameter("inputEmail");

		/*
		 * 각종 validation 작업할것
		 */

		// 비밀번호 확인
		if (!memSvc.checkPasswordMatch(memPw, memRn)) {
			model.addAttribute("passwordMismatch", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "member/registView";
		}

		// ID 중복 확인
		if (!memSvc.checkIdDuplication(memId)) {
			model.addAttribute("idDuplication", "이미 사용 중인 ID입니다.");
			return "member/registView";
		}

		// 닉네임 중복 확인
		if (!memSvc.checkNickDuplication(memNick)) {
			model.addAttribute("nickDuplication", "이미 사용 중인 닉네임입니다.");
			return "member/registView";
		}

		try {
			memDate = new Timestamp(new Date().getTime());
			MemberDTO member = new MemberDTO(memName, memId, memPw, memRn, memAddress, memPhone, memNick, memType,
					memImg, comCeo, comBrc, comMaNm, comMaPn, memHp, memDate, memEmail);
			System.out.println("registMemberInfo: " + member);
			memSvc.registMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "member/loginView";
	}

	/*
	 * 로그인 실행
	 * 
	 */
	@PostMapping("/loginDo")
	public String loginDo(MemberDTO member, HttpSession session, boolean rememberId, HttpServletResponse resp) {
		MemberDTO memInfo = memSvc.loginMember(member);
		if (memInfo != null) {
			System.out.println("로그인성공: " + memInfo);
			log.info("로그인 성공: {}", memInfo);
		} else {
			System.out.println("로그인실패");
			log.warn("로그인 실패: {}", member.getMemId());

		}
		session.setAttribute("memInfo", memInfo);
		if (rememberId) {
			Cookie cookie = new Cookie("rememberId", member.getMemId());
			resp.addCookie(cookie);
			log.info("아이디 기억 설정: {}", member.getMemId());

		} else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			log.info("아이디 기억 해제: {}", member.getMemId());
		}
		return "redirect:/";
	}

	/*
	 * 로그아웃 실행
	 * 
	 */
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/*
	 * 회원수정(일반회원)
	 */
	@PostMapping("/updateAccount")
	public String updateAccount(MemberDTO member, HttpSession session) {
		System.out.println("수정정보?: " + member);
		memSvc.updateMember(member);
		System.out.println("회원수정:" + member);
		MemberDTO memInfo = memSvc.loginMember(member);
		System.out.println("회원수정후 회원정보:" + memInfo);
		session.setAttribute("memInfo", memInfo);
		return "redirect:/";
	}
}
