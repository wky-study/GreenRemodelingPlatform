package com.team.green.order.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.team.green.member.dto.MemberDTO;
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
    public @ResponseBody ReadyResponseDTO payReady(@RequestBody List<OrderCreateFormDTO> orderCreateFormList, HttpSession session) {
        
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        String memId = member.getMemId();
        
        // 여러 상품의 총합과 수량을 계산
        int totalPrice = 0;
        int totalQuantity = 0;
        String name = null;  // 대표 상품 이름 (첫 번째 상품 이름)
        
        // 주문 번호를 담을 리스트
        List<String> partnerOrderIds = new ArrayList<>();
        
        // 이미지 src 를 담을 리스트
        List<String> prodImageSrcs = new ArrayList<>();
        
        // 가격을 담을 리스트
        List<Integer> prodPrices = new ArrayList<>();
        
        // 장바구니 고유번호 리스트
        List<String> cartIds = new ArrayList<>();

        // 대표 주문 번호 생성 (하나의 주문을 식별할 수 있는 고유 번호)
        String representativeOrderId = "REP" + new Date().getTime();  // 타임스탬프 기반으로 대표 주문번호 생성
        log.info("대표 주문 번호: " + representativeOrderId);
        
        System.out.println(orderCreateFormList);
        
        for (int i = 0; i < orderCreateFormList.size(); i++) {
            OrderCreateFormDTO orderCreateForm = orderCreateFormList.get(i);

            // 첫 번째 상품의 이름을 대표로 사용
            if (i == 0) {
                name = orderCreateForm.getName();
            }

            // 각 상품 가격의 총합 계산
            totalPrice += orderCreateForm.getTotalPrice();
            totalQuantity += orderCreateForm.getQuantity();

            // 각 상품에 대한 주문번호 생성 (고유한 주문 번호)
            String v_orderNo = "ORD" + new Date().getTime() + (i + 1);  // 타임스탬프 + 인덱스를 기반으로 주문번호 생성
            partnerOrderIds.add(v_orderNo);  // 주문 번호 리스트에 추가
            
            // 이미지 src 담기
            prodImageSrcs.add(orderCreateForm.getProdImageSrc());
            
            // 가격 담기
            prodPrices.add(orderCreateForm.getTotalPrice());
            
            // 장바구니 고유번호 담기
            cartIds.add(orderCreateForm.getCartId());
            
            // 로그 출력
            log.info("주문 상품 이름: " + orderCreateForm.getName());
            log.info("주문 금액: " + orderCreateForm.getTotalPrice());
            log.info("주문 수량: " + orderCreateForm.getQuantity());
            log.info("주문 번호: " + v_orderNo);
            
            System.out.println("가격: " + prodPrices.get(i));
            System.out.println("장바구니 고유번호: " + cartIds.get(i));

        }
        
        // 세션에 저장 (최후의 상품 정보만 저장되므로 각 상품별로 저장하려면 세션 키를 다르게 처리할 수 있음)
        session.setAttribute("representativeOrderId", representativeOrderId);  // 대표 주문번호
        session.setAttribute("totalPrice", totalPrice);		// 총 가격
        session.setAttribute("quantity", totalQuantity);	// 상품수량
        session.setAttribute("partnerOrderIds", partnerOrderIds);  // 주문번호 리스트
        session.setAttribute("name", name);  // 상품명 (대표)
        session.setAttribute("prodPrices", prodPrices);  // 각각 가격 리스트
        session.setAttribute("cartIds", cartIds);  // 장바구니 고유번호 리스트
        session.setAttribute("prodImageSrcs", prodImageSrcs);  // 이미지 src 리스트
        int quantity = totalQuantity;
        
        // 카카오 결제 준비하기
        ReadyResponseDTO readyResponse = kakaoPayService.payReady(name, totalPrice, memId, quantity, session);
        
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("결제 고유번호: " + readyResponse.getTid());
        
        System.out.println("컨트롤러 " + readyResponse);
        
        return readyResponse;
    }

    @RequestMapping(value = "/order/completed", method = RequestMethod.GET)
    public String payCompleted(@RequestParam("pg_token") String pgToken, HttpSession session) {
        
        // 세션에서 결제 고유번호(tid) 가져오기
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결제 고유번호: " + tid);
        log.info("주문번호: " + session.getAttribute("partnerOrderId"));
        
        System.out.println("payApprove 쏘기전");
        
        // 카카오 결제 승인 요청
        ApproveResponseDTO approveResponse = kakaoPayService.payApprove(tid, pgToken, session);

        // 결제 완료 후 세션에서 partnerOrderId 제거
        session.removeAttribute("partnerOrderId");
        session.removeAttribute("representativeOrderId");
        session.removeAttribute("totalPrice");
        session.removeAttribute("quantity");
        session.removeAttribute("name");
        session.removeAttribute("prodPrices");
        session.removeAttribute("cartIds");
        
        System.out.println("완료하고 최종 리턴 전");
        
        // 결제가 완료되었으므로 주문 완료 페이지로 리다이렉트
        return "order/completed";
    }
    
    @RequestMapping("/paymentDone")
    public String paymentDone() {
    	System.out.println("완료");
    	return "order/paymentDone";
    };
    
    
    
}
