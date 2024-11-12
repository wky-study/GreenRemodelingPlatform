package com.team.green.order.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import com.team.green.member.dto.MemberDTO;
import com.team.green.order.dto.ApproveResponseDTO;
import com.team.green.order.dto.ReadyResponseDTO;

@Service
public class KakaoPayService {

	
    // Logger 객체 선언
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
    
    // 카카오페이 결제창 연결
    public ReadyResponseDTO payReady(String name, int totalPrice, String memId, HttpSession session) {
    	
    	String partnerOrderId = (String)session.getAttribute("partnerOrderId");
    	
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", partnerOrderId);                     // 주문번호 
        parameters.put("partner_user_id", memId);                          		// 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", "1");                                        // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "0");                                 // 상품 비과세 금액
        parameters.put("approval_url", "http://localhost:9090/green/pay/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://localhost:9090/green/pay/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://localhost:9090/green/pay/fail");          // 결제 실패 시 URL
        
        // HttpEntity : HTTP 요청 또는 응답에 해당하는 Http Header와 Http Body를 포함하는 클래스
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        //   REST API 호출 이후 응답을 받을 때까지 기다리는 동기 방식 (json, xml 응답)
        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        
        System.out.println("url 요청 전" + requestEntity);
        
        // 주문번호를 세션에 저장
        session.setAttribute("partnerOrderId", partnerOrderId);
        
        // RestTemplate의 postForEntity : POST 요청을 보내고 ResponseEntity로 결과를 반환받는 메소드
        ResponseEntity<ReadyResponseDTO> responseEntity = template.postForEntity(url, requestEntity, ReadyResponseDTO.class);
        log.info("결제준비 응답객체: " + responseEntity.getBody());
        
        System.out.println("pryReady 리턴 전" + responseEntity.getBody());
        
        return responseEntity.getBody();
    }
    
    // 카카오페이 결제 승인
    // 사용자가 결제 수단을 선택하고 비밀번호를 입력해 결제 인증을 완료한 뒤,
    // 최종적으로 결제 완료 처리를 하는 단계
    public ApproveResponseDTO payApprove(String tid, String pgToken, HttpSession session) {
    	
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        System.out.println(member);
        String memId = member.getMemId();
    	
        String partnerOrderId = (String)session.getAttribute("partnerOrderId");
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // 가맹점 코드(테스트용)
        parameters.put("tid", tid);                       // 결제 고유번호
        parameters.put("partner_order_id", partnerOrderId); // 주문번호
        parameters.put("partner_user_id", memId);    		// 회원 아이디
        parameters.put("pg_token", pgToken);              // 결제승인 요청을 인증하는 토큰
        
        System.out.println("최종 승인 들어옴");
        
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponseDTO approveResponse = template.postForObject(url, requestEntity, ApproveResponseDTO.class);
        log.info("결제승인 응답객체: " + approveResponse);
        
        return approveResponse;
    }
    
    // 카카오페이 측에 요청 시 헤더부에 필요한 값
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        
        String auth = "DEV84E409C34F42CB1E9F4933512B9BB08846910";
        
        headers.set("Authorization", "DEV_SECRET_KEY " + auth);
        headers.set("Content-type", "application/json");

        return headers;
    }
}
