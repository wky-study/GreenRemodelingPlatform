package com.team.green.member.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;


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
	@GetMapping("/tacView")
	public String tacView(HttpServletRequest request, HttpSession session) {
		
		// 현재 요청의 리퍼러 URL을 세션에 저장
		String referrer = request.getHeader("Referer");
		session.setAttribute("prevPageUrl", referrer);
		
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
	
    // ID 중복 확인
    @PostMapping("/checkIdDuplication")
    @ResponseBody  // JSON 형식으로 응답을 반환
    public Map<String, Boolean> checkIdDuplication(@RequestBody Map<String, String> requestData) {
        String memId = requestData.get("memId");  // 클라이언트로부터 ID 받기
        boolean isDuplicate = !memSvc.checkIdDuplication(memId);  // 중복이면 true, 아니면 false

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);  // 응답 JSON으로 반환

        return response;
    }

    // 닉네임 중복 확인
    @PostMapping("/checkNickDuplication")
    @ResponseBody  // JSON 형식으로 응답을 반환
    public Map<String, Boolean> checkNickDuplication(@RequestBody Map<String, String> requestData) {
        String memNick = requestData.get("memNick");  // 클라이언트로부터 닉네임 받기
        boolean isDuplicate = !memSvc.checkNickDuplication(memNick);  // 중복이면 true, 아니면 false

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);  // 응답 JSON으로 반환

        return response;
    }
    
	
}
