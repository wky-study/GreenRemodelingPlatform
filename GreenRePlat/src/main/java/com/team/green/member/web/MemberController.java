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

	/* ��й�ȣã�� ������ */
	@RequestMapping("/findCheck")
	public String findCheck() {
		return "member/findCheck";
	}

	/* �׸����𵨸� �Ұ������� */
	@RequestMapping("/introductionView")
	public String introductionView() {

		return "introduction/introductionView";
	}

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
			session.setAttribute("loginError", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�."); // ���� �޽��� ����
			System.out.println("�α��ν���");
			log.warn("�α��� ����: {}", member.getMemId());
			return "redirect:/loginView";

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
	@ResponseBody // JSON �������� ������ ��ȯ
	public Map<String, Boolean> checkIdDuplication(@RequestBody Map<String, String> requestData) {
		String memId = requestData.get("memId"); // Ŭ���̾�Ʈ�κ��� ID �ޱ�
		boolean isDuplicate = !memSvc.checkIdDuplication(memId); // �ߺ��̸� true, �ƴϸ� false

		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicate", isDuplicate); // ���� JSON���� ��ȯ

		return response;
	}

	// �г��� �ߺ� Ȯ��
	@PostMapping("/checkNickDuplication")
	@ResponseBody // JSON �������� ������ ��ȯ
	public Map<String, Boolean> checkNickDuplication(@RequestBody Map<String, String> requestData) {
		String memNick = requestData.get("memNick"); // Ŭ���̾�Ʈ�κ��� �г��� �ޱ�
		boolean isDuplicate = !memSvc.checkNickDuplication(memNick); // �ߺ��̸� true, �ƴϸ� false

		Map<String, Boolean> response = new HashMap<>();
		response.put("isDuplicate", isDuplicate); // ���� JSON���� ��ȯ

		return response;
	}

	// ��й�ȣã��
	@RequestMapping("/findPw")
	public String findPassword(@RequestParam String memId, @RequestParam String memName, Model model) {
		// 1. ���̵�� �̸����� ȸ�� ���� ã��
		MemberDTO member = memSvc.getMI(memId, memName);

		if (member == null) {
			// ���̵�� �̸��� ��ġ�ϴ� ȸ���� ������ ���� �޽��� ��ȯ
			model.addAttribute("error", "���̵� �Ǵ� �̸��� ��ġ���� �ʽ��ϴ�.");
			return "member/findCheck"; // �ٽ� ��й�ȣ ã�� �������� �̵�
		}

		// 2. �ӽ� ��й�ȣ ����
		String newPassword = generateRandomPassword();

		// 3. �ӽ� ��й�ȣ�� ������Ʈ
		member.setMemPw(newPassword);
		memSvc.updateMember(member);

		// 4. �� ��й�ȣ �̸��Ϸ� ����
		sendNewPasswordEmail(member.getMemEmail(), newPassword, model);

		// 4-1. �� ��й�ȣ ��ȯ
		model.addAttribute("success", "�ӽ� ��й�ȣ�� �����Ǿ����ϴ�. �� ��й�ȣ��: " + newPassword);
		return "member/findCheck";
	}

	private String generateRandomPassword() {
		// ������ �ӽ� ��й�ȣ ���� ���� (���� ��ҹ��ڿ� ���� ����)
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

			// �̸��� ����� ����
			String subject = "���ں����� �ӽ� ��й�ȣ �ȳ�";
			String content = "<html><body>" + "<p>�ȳ��ϼ���, ����.</p>" + "<p>��û�Ͻ� �ӽ� ��й�ȣ�� �����Ǿ����ϴ�.</p>"
					+ "<p><strong>�ӽ� ��й�ȣ: " + newPassword + "</strong></p>" + "<p>�α��� �� ��й�ȣ�� ������ �ּ���.</p>"
					+ "<p>�����մϴ�.</p>" + "</body></html>";

			messageHelper.setFrom("ecobuiltest@gmail.com"); // ������ �̸���
			messageHelper.setTo(memEmail); // �޴� �̸���
			messageHelper.setSubject(subject); // �̸��� ����
			messageHelper.setText(content, true); // HTML �������� �̸��� ���� ����

	        // �̸��� ����
	        mailSender.send(mimeMessage);

	        // �̸��� ���� ���� �޽��� �߰�
	        model.addAttribute("emailSuccess", "�ӽ� ��й�ȣ�� �̸��Ϸ� ���۵Ǿ����ϴ�. �̸����� Ȯ�����ּ���.");
	        

	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("emailError", "�̸��� ���ۿ� �����߽��ϴ�. �ٽ� �õ����ּ���.");
	    }
	}
}
