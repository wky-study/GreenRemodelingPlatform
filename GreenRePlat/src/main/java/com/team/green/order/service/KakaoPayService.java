package com.team.green.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import com.team.green.cart.service.CartService;
import com.team.green.member.dto.MemberDTO;
import com.team.green.order.dto.ApproveResponseDTO;
import com.team.green.order.dto.PaymentDTO;
import com.team.green.order.dto.ReadyResponseDTO;

@Service
public class KakaoPayService {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CartService cartService;
	
    // Logger 객체 선언
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
    
    // 카카오페이 결제창 연결
    public ReadyResponseDTO payReady(String name, int totalPrice, String memId, int quantity ,HttpSession session) {
    	
    	String representativeOrderId = (String) session.getAttribute("representativeOrderId");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", representativeOrderId);              // 대표 주문번호 
        parameters.put("partner_user_id", memId);                          		// 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", String.valueOf(quantity));                   // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "0");                                 // 상품 비과세 금액
        parameters.put("approval_url", "http://localhost:9090/green/order/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://localhost:9090/green/order/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://localhost:9090/green/order/fail");          // 결제 실패 시 URL
        
        // HttpEntity : HTTP 요청 또는 응답에 해당하는 Http Header와 Http Body를 포함하는 클래스
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        //   REST API 호출 이후 응답을 받을 때까지 기다리는 동기 방식 (json, xml 응답)
        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        
        System.out.println("url 요청 전" + requestEntity);
        
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
    	
    	String representativeOrderId = (String) session.getAttribute("representativeOrderId");
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // 가맹점 코드(테스트용)
        parameters.put("tid", tid);                       // 결제 고유번호
        parameters.put("partner_order_id", representativeOrderId); // 대표 주문번호
        parameters.put("partner_user_id", memId);    		// 회원 아이디
        parameters.put("pg_token", pgToken);              // 결제승인 요청을 인증하는 토큰
        
        System.out.println("최종 승인 들어옴");
        
        System.out.println(pgToken);
        
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponseDTO approveResponse = template.postForObject(url, requestEntity, ApproveResponseDTO.class);
        log.info("결제승인 응답객체: " + approveResponse);
        
        // 결제완료 시 cart 정보 삭제하기
        List<String> cartIds = (List<String>) session.getAttribute("cartIds");
	    for(int i = 0; i < cartIds.size(); i++) {
	    	cartService.delCartList(memId, cartIds.get(i));  
	    }
	    session.removeAttribute("cartIds");  // "cartIds"라는 이름의 세션 속성 제거
	    
        // DB에 저장
	    // DB for문 돌릴 리스트 생성
        List<PaymentDTO> paymentList = new ArrayList<>();
        
        int quantity = (int)session.getAttribute("quantity"); // 주문 수량
        String name = (String)session.getAttribute("name"); // 상품이름 (대표)
    	int totalPrice = (int)session.getAttribute("totalPrice");
    	System.out.println("전체 금액: "+ totalPrice);

    	// 각각 주문번호
    	List<String> partnerOrderIds = (List<String>) session.getAttribute("partnerOrderIds");
    	
    	// 각각 가격 integer => String 변경
    	List<Integer> prodPrices = (List<Integer>) session.getAttribute("prodPrices");
    	List<String> prodPricesStr = prodPrices.stream().map(String::valueOf).collect(Collectors.toList());
    	// 각각 장바구니 고유번호
    	
    	// 반복으로 DB에 저장
    	for(int i = 0; i < partnerOrderIds.size(); i++) {
    		
    		PaymentDTO payment = new PaymentDTO(); 
    		
    		payment.setTid(tid);
    		payment.setPartnerOrderId(partnerOrderIds.get(i));
    		payment.setMemId(memId); 
    		payment.setProdName(name); 
    		payment.setProdPrice(prodPricesStr.get(i));
    		payment.setPgToken(pgToken);
    		payment.setTotalPrice(totalPrice);
    		payment.setCartId(cartIds.get(i));
    		payment.setRepresentativeOrderId(representativeOrderId);
    		
    		int tp = orderService.insertOrder(payment);
    		System.out.println(tp);
    	}
    	
    	
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
