package com.team.green.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team.green.member.dto.MemberDTO;

public class LoginChkInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		HttpSession session = req.getSession();

		MemberDTO login = (MemberDTO) session.getAttribute("memInfo");

		if (login == null) {
			resp.sendRedirect(req.getContextPath() + "member/loginView");
			return false;
		}

		return true;
	}

}
