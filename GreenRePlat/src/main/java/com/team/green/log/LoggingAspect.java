package com.team.green.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.team.green.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component // �� ������̼Ǹ� ������ Spring�� �ڵ����� ������ ���
public class LoggingAspect {

    // AOP�� ����� ���� ����
    @Around("execution(* com.team.green..*(..))") // ������ ��Ű�� �� �޼ҵ� ������ ����é�ϴ�.
    public Object logRequestDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        
        // HttpServletRequest ��ü ��������
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()) != null 
                                    ? ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                                    : null;
        if (request == null) {
            log.debug("HttpServletRequest�� null�Դϴ�.");
        }
        
        // ���� ��ü ��������
        HttpSession session = request != null ? request.getSession(false) : null;

        // �޼��� �̸�
        String methodName = joinPoint.getSignature().getName();

        // ���ǿ��� �α����� ����� ���� ��������
        MemberDTO member = null;
        if (session != null) {
            member = (MemberDTO) session.getAttribute("memInfo");
        }
        String memId = (member != null) ? member.getMemId() : "��ȸ��";

        // Ŭ���̾�Ʈ IP �ּ�
        String ipAddress = (request != null) ? getClientIpAddr(request) : "�� �� ����";

        // ��û URI
        String requestURI = (request != null) ? request.getRequestURI() : "�� �� ����";

        // ��û ������� User-Agent ��������
        String userAgent = (request != null) ? request.getHeader("User-Agent") : "�� �� ����";

        // MDC�� �� �ֱ�
        MDC.put("memId", memId);
        MDC.put("ip", ipAddress);
        MDC.put("requestURI", requestURI);
        MDC.put("userAgent", userAgent);

        // �α� ���
        log.info("�޼��� ȣ��: {}", methodName);

        // ���� �޼��� ����
        Object result = joinPoint.proceed();

        // �޼��� ���� �Ϸ� �� �α� ���
        log.info("�޼��� ���� �Ϸ�: {}", methodName);

        // MDC���� �� ����
        MDC.clear();

        return result;
    }

    // Ŭ���̾�Ʈ IP �ּҸ� ��� �޼ҵ�
    public String getClientIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "�� �� ����";
        }
        
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        } else {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
