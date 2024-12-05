package com.team.green.member.web;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

	@Autowired
	private JavaMailSender mailSender;

	/* 비밀번호찾기 페이지 */
	@RequestMapping("/findCheck")
	public String findCheck() {
		return "member/findCheck";
	}

	/* 그린리모델링 소개페이지 */
	@RequestMapping("/introductionView")
	public String introductionView() {

		return "introduction/introductionView";
	}

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
	public String settingView(HttpSession session) {

		if (session.getAttribute("memInfo") == null) {
			return "redirect:/loginView";
		}

		return "mypage/myPageCompany";
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
			session.setAttribute("loginError", "아이디 또는 비밀번호가 잘못되었습니다."); // 에러 메시지 전달
			System.out.println("로그인실패");
			log.warn("로그인 실패: {}", member.getMemId());
			return "redirect:/loginView";

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
	@ResponseBody // JSON 형식으로 응답을 반환
	public Map<String, Boolean> checkIdDuplication(@RequestBody Map<String, String> requestData) {
		String memId = requestData.get("memId"); // 클라이언트로부터 ID 받기
		boolean isDuplicate = !memSvc.checkIdDuplication(memId); // 중복이면 true, 아니면 false

		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicate", isDuplicate); // 응답 JSON으로 반환

		return response;
	}

	// 닉네임 중복 확인
	@PostMapping("/checkNickDuplication")
	@ResponseBody // JSON 형식으로 응답을 반환
	public Map<String, Boolean> checkNickDuplication(@RequestBody Map<String, String> requestData) {
		String memNick = requestData.get("memNick"); // 클라이언트로부터 닉네임 받기
		boolean isDuplicate = !memSvc.checkNickDuplication(memNick); // 중복이면 true, 아니면 false

		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicate", isDuplicate); // 응답 JSON으로 반환

		return response;
	}

	// 비밀번호찾기
	@RequestMapping("/findPw")
	public String findPassword(@RequestParam String memId, @RequestParam String memName, Model model) {
		// 1. 아이디와 이름으로 회원 정보 찾기
		MemberDTO member = memSvc.getMI(memId, memName);

		if (member == null) {
			// 아이디와 이름이 일치하는 회원이 없으면 에러 메시지 반환
			model.addAttribute("error", "아이디 또는 이름이 일치하지 않습니다.");
			return "member/findCheck"; // 다시 비밀번호 찾기 페이지로 이동
		}

		// 2. 임시 비밀번호 생성
		String newPassword = generateRandomPassword();

		// 3. 임시 비밀번호로 업데이트
		member.setMemPw(newPassword);
		memSvc.updateMember(member);

		// 4. 새 비밀번호 이메일로 전송
		sendNewPasswordEmail(member.getMemEmail(), newPassword, model);

		// 4-1. 새 비밀번호 반환
		model.addAttribute("success", "임시 비밀번호가 생성되었습니다. 새 비밀번호는: " + newPassword);
		return "member/findCheck";
	}

	private String generateRandomPassword() {
		// 간단한 임시 비밀번호 생성 로직 (영문 대소문자와 숫자 포함)
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			password.append(chars.charAt(random.nextInt(chars.length())));
		}
		return password.toString();
	}

	private void sendNewPasswordEmail(String memEmail, String newPassword, Model model) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

			// 이메일 제목과 내용
			String subject = "에코빌더스 임시 비밀번호 안내";
			String content = "<html><body>" + "<p>안녕하세요, 고객님.</p>" + "<p>요청하신 임시 비밀번호가 생성되었습니다.</p>"
					+ "<p><strong>임시 비밀번호: " + newPassword + "</strong></p>" + "<p>로그인 후 비밀번호를 변경해 주세요.</p>"
					+ "<p>감사합니다.</p>" + "</body></html>";

			messageHelper.setFrom("ecobuiltest@gmail.com"); // 보내는 이메일
			messageHelper.setTo(memEmail); // 받는 이메일
			messageHelper.setSubject(subject); // 이메일 제목
			messageHelper.setText(content, true); // HTML 형식으로 이메일 내용 설정

	        // 이메일 전송
	        mailSender.send(mimeMessage);

	        // 이메일 전송 성공 메시지 추가
	        model.addAttribute("emailSuccess", "임시 비밀번호가 이메일로 전송되었습니다. 이메일을 확인해주세요.");
	        

	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("emailError", "이메일 전송에 실패했습니다. 다시 시도해주세요.");
	    }
	}
}
