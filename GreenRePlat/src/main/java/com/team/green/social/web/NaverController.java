package com.team.green.social.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.member.dto.MemberDTO;
import com.team.green.member.service.MemberService;
import com.team.green.social.service.NaverApi;
import com.team.green.social.vo.NaverProfileVO;

@Controller
public class NaverController {
	
    @Autowired
    private NaverApi naverApi;
    
    @Autowired
    private MemberService memberService;

	@ResponseBody
	@GetMapping("/naverlogin")
	public MemberDTO naverLogin(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpSession session, HttpServletResponse resp) throws IOException {
		
        // 1. ���̹� �α��ο��� ���޵� 'code'�� 'state' �Ķ���ͷ� ����� ���� �� ���� ��ū�� ����
	    String accessToken = naverApi.getAccessToken(code, state);
	    System.out.println("accessToken = " + accessToken);
	    
	    // 2. ����� ���� �ޱ�
	    NaverProfileVO userInfo = naverApi.getUserInfo(accessToken);
	    
        // 3. ����� ������ DB�� ����� ���� ���� Ȯ�� �� ó��
        String naverId = userInfo.getId();  // ���̹� ID	-> �̰ŷ� ���Խ� �н����尡 �� ����
        String nickName = userInfo.getNickname();  // ���̹� ����� �г���
        String email = userInfo.getEmail();  // ���̹� ����� �̸���
        String mobile = userInfo.getMobile();  // ���̹� ����� ����� ��ȣ
        String name = userInfo.getName();  // ���̹� ����� �̸�
        String birthyear = userInfo.getBirthyear();  // ���̹� ����� ����⵵
        String birthday = userInfo.getBirthday();  // ���̹� ����� �����
        
		Timestamp memDate;
		memDate = new Timestamp(new Date().getTime());

        // ���� ���
        MemberDTO mem = new MemberDTO();
        mem.setMemName(name);
        mem.setMemPw(naverId);
        mem.setMemNick(nickName);
        mem.setMemEmail(email);
        mem.setMemId(email);
        mem.setMemPhone(mobile);
        mem.setMemAddress(birthyear + "-" + birthday);
        mem.setMemDate(memDate);
        
        System.out.println("member ��ü: "+mem);
        System.out.println(email);
	    
        // ���⼭ ������ ���Ե� ���̵��� üũ -> DB�� ������ �α��� ���� 
        //									-> DB���������� ���� �� �α��� ����
         String userExists = memberService.getMember(email); // ���ԵǾ������� true, �ƴϸ� false
         System.out.println(userExists);
         // 5. ����� ���� ���ο� ���� ó��
         if (userExists != null && !userExists.isEmpty()) {
        	 MemberDTO member = memberService.socialLoginMember(email);
             session.setAttribute("memInfo", member);
             
             // ��Ű�� ����� ���̵�(naverId) ����
             Cookie cookie = new Cookie("rememberId", email);
             cookie.setMaxAge(60 * 60 * 24 * 30); // ��Ű ��ȿ�Ⱓ ���� (��: 30��)
             cookie.setPath("/"); // ��Ű ��� ����
             resp.addCookie(cookie);
             
             // �����̷�Ʈ: �α��� �� Ȩ �������� �̵�
             resp.sendRedirect("/green/"); // ���ϴ� URL�� �����̷�Ʈ
         } else {
             // ���ο� ����� -> DB�� ���� �� ���� ó��
             memberService.registMember(mem);
             MemberDTO member = memberService.socialLoginMember(email);
             
             session.setAttribute("naverId", naverId);
             session.setAttribute("memInfo", member);
             
             Cookie cookie = new Cookie("rememberId", email);
             cookie.setMaxAge(60 * 60 * 24 * 30); // ��Ű ��ȿ�Ⱓ ���� (��: 30��)
             cookie.setPath("/"); // ��Ű ��� ����
             resp.addCookie(cookie);
             
             System.out.println(userInfo);
             
             // �����̷�Ʈ: ���� �� Ȩ �������� �̵�
             resp.sendRedirect("/green/"); // ���ϴ� URL�� �����̷�Ʈ
         }
         return mem;  // �����δ� �� ��ȯ���� ������� �����Ƿ� ���� ����
	}


}
