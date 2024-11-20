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
		
        // 1. 네이버 로그인에서 전달된 'code'와 'state' 파라미터로 사용자 인증 후 접근 토큰을 받음
	    String accessToken = naverApi.getAccessToken(code, state);
	    System.out.println("accessToken = " + accessToken);
	    
	    // 2. 사용자 정보 받기
	    NaverProfileVO userInfo = naverApi.getUserInfo(accessToken);
	    
        // 3. 사용자 정보로 DB에 사용자 존재 여부 확인 후 처리
        String naverId = userInfo.getId();  // 네이버 ID	-> 이거로 가입시 패스워드가 될 예정
        String nickName = userInfo.getNickname();  // 네이버 사용자 닉네임
        String email = userInfo.getEmail();  // 네이버 사용자 이메일
        String mobile = userInfo.getMobile();  // 네이버 사용자 모바일 번호
        String name = userInfo.getName();  // 네이버 사용자 이름
        String birthyear = userInfo.getBirthyear();  // 네이버 사용자 출생년도
        String birthday = userInfo.getBirthday();  // 네이버 사용자 출생일
        
		Timestamp memDate;
		memDate = new Timestamp(new Date().getTime());

        // 정보 담기
        MemberDTO mem = new MemberDTO();
        mem.setMemName(name);
        mem.setMemPw(naverId);
        mem.setMemNick(nickName);
        mem.setMemEmail(email);
        mem.setMemId(email);
        mem.setMemPhone(mobile);
        mem.setMemAddress(birthyear + "-" + birthday);
        mem.setMemDate(memDate);
        
        System.out.println("member 객체: "+mem);
        System.out.println(email);
	    
        // 여기서 쿼리문 가입된 아이딘지 체크 -> DB에 있으면 로그인 실행 
        //									-> DB정보없으면 가입 후 로그인 실행
         String userExists = memberService.getMember(email); // 가입되어있으면 true, 아니면 false
         System.out.println(userExists);
         // 5. 사용자 존재 여부에 따른 처리
         if (userExists != null && !userExists.isEmpty()) {
        	 MemberDTO member = memberService.socialLoginMember(email);
             session.setAttribute("memInfo", member);
             
             // 쿠키에 사용자 아이디(naverId) 저장
             Cookie cookie = new Cookie("rememberId", email);
             cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효기간 설정 (예: 30일)
             cookie.setPath("/"); // 쿠키 경로 설정
             resp.addCookie(cookie);
             
             // 리다이렉트: 로그인 후 홈 페이지로 이동
             resp.sendRedirect("/green/"); // 원하는 URL로 리다이렉트
         } else {
             // 새로운 사용자 -> DB에 저장 후 가입 처리
             memberService.registMember(mem);
             MemberDTO member = memberService.socialLoginMember(email);
             
             session.setAttribute("naverId", naverId);
             session.setAttribute("memInfo", member);
             
             Cookie cookie = new Cookie("rememberId", email);
             cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효기간 설정 (예: 30일)
             cookie.setPath("/"); // 쿠키 경로 설정
             resp.addCookie(cookie);
             
             System.out.println(userInfo);
             
             // 리다이렉트: 가입 후 홈 페이지로 이동
             resp.sendRedirect("/green/"); // 원하는 URL로 리다이렉트
         }
         return mem;  // 실제로는 이 반환값을 사용하지 않으므로 생략 가능
	}


}
