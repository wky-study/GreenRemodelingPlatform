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
	 * ����������� �̵�
	 * 
	 */
	@GetMapping("/tacView")
	public String tacView(HttpServletRequest request, HttpSession session) {
		
		// ���� ��û�� ���۷� URL�� ���ǿ� ����
		String referrer = request.getHeader("Referer");
		session.setAttribute("prevPageUrl", referrer);
		
		return "member/tacView";
	}
	
	/*
	 * ȸ������ȭ������ �̵�
	 * 
	 */
	@RequestMapping("/registView")
	public String registView() {
		
		return "member/registView";
	}

	/*
	 * �α���ȭ������ �̵�
	 * 
	 */
	@RequestMapping("/loginView")
	public String loginView() {
		return "member/loginView";
	}

	/*
	 * ȸ������ȭ������ �̵�
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
		 * ���� validation �۾��Ұ�
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
	 * �α��� ����
	 * 
	 */
	@PostMapping("/loginDo")
	public String loginDo(MemberDTO member, HttpSession session, boolean rememberId, HttpServletResponse resp) {
		MemberDTO memInfo = memSvc.loginMember(member);
		if (memInfo != null) {
			System.out.println("�α��μ���: " + memInfo);
			log.info("�α��� ����: {}", memInfo);
		} else {
			System.out.println("�α��ν���");
			log.warn("�α��� ����: {}", member.getMemId());

		}
		session.setAttribute("memInfo", memInfo);
		if (rememberId) {
			Cookie cookie = new Cookie("rememberId", member.getMemId());
			resp.addCookie(cookie);
			log.info("���̵� ��� ����: {}", member.getMemId());

		} else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			log.info("���̵� ��� ����: {}", member.getMemId());
		}
		return "redirect:/";
	}

	/*
	 * �α׾ƿ� ����
	 * 
	 */
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	/*
	 * ȸ������(�Ϲ�ȸ��)
	 */
	@PostMapping("/updateAccount")
	public String updateAccount(MemberDTO member, HttpSession session) {
		System.out.println("��������?: " + member);
		memSvc.updateMember(member);
		System.out.println("ȸ������:" + member);
		MemberDTO memInfo = memSvc.loginMember(member);
		System.out.println("ȸ�������� ȸ������:" + memInfo);
		session.setAttribute("memInfo", memInfo);
		return "redirect:/";
	}
	
    // ID �ߺ� Ȯ��
    @PostMapping("/checkIdDuplication")
    @ResponseBody  // JSON �������� ������ ��ȯ
    public Map<String, Boolean> checkIdDuplication(@RequestBody Map<String, String> requestData) {
        String memId = requestData.get("memId");  // Ŭ���̾�Ʈ�κ��� ID �ޱ�
        boolean isDuplicate = !memSvc.checkIdDuplication(memId);  // �ߺ��̸� true, �ƴϸ� false

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);  // ���� JSON���� ��ȯ

        return response;
    }

    // �г��� �ߺ� Ȯ��
    @PostMapping("/checkNickDuplication")
    @ResponseBody  // JSON �������� ������ ��ȯ
    public Map<String, Boolean> checkNickDuplication(@RequestBody Map<String, String> requestData) {
        String memNick = requestData.get("memNick");  // Ŭ���̾�Ʈ�κ��� �г��� �ޱ�
        boolean isDuplicate = !memSvc.checkNickDuplication(memNick);  // �ߺ��̸� true, �ƴϸ� false

        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate);  // ���� JSON���� ��ȯ

        return response;
    }
    
	
}
