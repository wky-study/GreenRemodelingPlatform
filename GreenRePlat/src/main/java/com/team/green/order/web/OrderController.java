package com.team.green.order.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.green.order.dto.ApproveResponseDTO;
import com.team.green.order.dto.OrderCreateFormDTO;
import com.team.green.order.dto.ReadyResponseDTO;
import com.team.green.order.service.KakaoPayService;
import com.team.green.order.util.SessionUtils;

@Controller
public class OrderController {
	
	@Autowired
    KakaoPayService kakaoPayService;
    
    // Logger 객체 선언
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
	
	 
    @RequestMapping(value = "/pay/ready", method = RequestMethod.POST)
    public @ResponseBody ReadyResponseDTO payReady(@RequestBody OrderCreateFormDTO orderCreateForm, HttpServletRequest request) {
        
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();
        
        log.info("주문 상품 이름: " + name);
        log.info("주문 금액: " + totalPrice);

        // 카카오 결제 준비하기
        ReadyResponseDTO readyResponse = kakaoPayService.payReady(name, totalPrice, request.getContextPath());
        
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("결제 고유번호: " + readyResponse.getTid());
        
        System.out.println("컨트롤러 " + readyResponse);
        
        return readyResponse;
    }

    @RequestMapping(value = "/pay/completed", method = RequestMethod.GET)
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        
        // 세션에서 결제 고유번호(tid) 가져오기
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결제 고유번호: " + tid);
        
        System.out.println("payApprove 쏘기전");
        
        // 카카오 결제 승인 요청
        ApproveResponseDTO approveResponse = kakaoPayService.payApprove(tid, pgToken);

        // 결제가 완료되었으므로 주문 완료 페이지로 리다이렉트
        return "order/completed";
    }
    
    @GetMapping("/paymentDone")
    public String paymentDoneView() {
    	
    	
    	
    	return "order/paymentDone";
    }
    
    
}
