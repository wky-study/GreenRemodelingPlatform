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
@Component // 이 어노테이션만 있으면 Spring이 자동으로 빈으로 등록
public class LoggingAspect {

    // AOP가 적용될 범위 설정
    @Around("execution(* com.team.green..*(..))") // 지정된 패키지 내 메소드 실행을 가로챕니다.
    public Object logRequestDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        
        // HttpServletRequest 객체 가져오기
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()) != null 
                                    ? ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                                    : null;
        if (request == null) {
            log.debug("HttpServletRequest가 null입니다.");
        }
        
        // 세션 객체 가져오기
        HttpSession session = request != null ? request.getSession(false) : null;

        // 메서드 이름
        String methodName = joinPoint.getSignature().getName();

        // 세션에서 로그인한 사용자 정보 가져오기
        MemberDTO member = null;
        if (session != null) {
            member = (MemberDTO) session.getAttribute("memInfo");
        }
        String memId = (member != null) ? member.getMemId() : "비회원";

        // 클라이언트 IP 주소
        String ipAddress = (request != null) ? getClientIpAddr(request) : "알 수 없음";

        // 요청 URI
        String requestURI = (request != null) ? request.getRequestURI() : "알 수 없음";

        // 요청 헤더에서 User-Agent 가져오기
        String userAgent = (request != null) ? request.getHeader("User-Agent") : "알 수 없음";

        // MDC에 값 넣기
        MDC.put("memId", memId);
        MDC.put("ip", ipAddress);
        MDC.put("requestURI", requestURI);
        MDC.put("userAgent", userAgent);

        // 로그 출력
        log.info("메서드 호출: {}", methodName);

        // 실제 메서드 실행
        Object result = joinPoint.proceed();

        // 메서드 실행 완료 후 로그 출력
        log.info("메서드 실행 완료: {}", methodName);

        // MDC에서 값 제거
        MDC.clear();

        return result;
    }

    // 클라이언트 IP 주소를 얻는 메소드
    public String getClientIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "알 수 없음";
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
