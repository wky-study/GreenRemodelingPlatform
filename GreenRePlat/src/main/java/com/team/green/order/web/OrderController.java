package com.team.green.order.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	private JavaMailSender mailSender;
	
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
        
        // 상품 이름 담을 리스트
        List<String> prodName = new ArrayList<>();
        
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
            
            // 상품이름 담기
            prodName.add(orderCreateForm.getName());
            
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
        session.setAttribute("prodName", prodName);
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

        System.out.println("완료하고 최종 리턴 전");
        
        // 결제가 완료되었으므로 주문 완료 페이지로 리다이렉트
        return "order/completed";
    }
    

    @RequestMapping("/paymentDone")
    public String paymentDone(HttpSession session) {
    	
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        String memName = member.getMemName();
        String memEmail = member.getMemEmail();
    	
    	if(session.getAttribute("memInfo") == null) {
    		return "redirect:/loginView";
    	};
    	
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
		    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		    
	        Date now = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일");
	        String formattedDate = sdf.format(now);
	        
	    	int totalPrice = (int)session.getAttribute("totalPrice"); // 전체 금액
	    	List<String> nameList = (List)session.getAttribute("prodName");	// 각각 상품명
	    	List<String> partnerOrderIds = (List)session.getAttribute("partnerOrderIds");	// 각각 주문번호
	    	List<Integer> prodPrices = (List)session.getAttribute("prodPrices"); // 각각 가격
	    	
	    	System.out.println(nameList.size()); 
	    	
	    	String price = "";
	    	
	        // 내용 
	        String emailContent = "<html><body style='font-family: Arial, sans-serif; color: #333;'>"
	        	    + "<div style='max-width: 800px; margin: 0 auto; padding: 20px; border: 1px solid #e1e1e1; border-radius: 8px; background-color: #f9f9f9;'>"
	        	    + "<h2 style='text-align: center; color: #4CAF50;'>주문하신 상품의 결제가 완료되었습니다!</h2>"
	        	    + "<p style='font-size: 16px; color: #555;'>" + memName + " 고객님, <strong>주문일자: " + formattedDate + "</strong></p>"
	        	    + "<p style='font-size: 16px; color: #555;'>주문하신 상품에 대한 결제가 성공적으로 완료되었습니다. 자세한 내용은 아래를 확인해 주세요.</p>"
	        	    + "<table style='width: 100%; border-collapse: collapse; margin-top: 20px;'>"
	        	    + "<thead>"
	        	    + "<tr style='background-color: #f2f2f2;'>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>주문번호</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>상품명</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>가격</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>수량</th>"
	        	    + "</tr>"
	        	    + "</thead>"
	        	    + "<tbody>";
	   for(int i = 0; i < nameList.size(); i++) {
	        price = prodPrices.get(i) + "";
		   emailContent += "<tr>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + partnerOrderIds.get(i) +"</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + nameList.get(i) +"</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + price + "원</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>1개</td>"
		        	    + "</tr>"
		        	    + "<tr>";		   
	   }
	   emailContent += "</tbody>"
	        	    + "</table>"
	        	    + "<p style='font-size: 16px; color: #555; margin-top: 20px;'>주문 내용 확인을 원하시면 언제든지 웹사이트를 방문해 주세요.</p>"
	        	    + "<div style='text-align: center; margin-top: 30px;'>"
	        	    + "<a href='http://localhost:9090/green/' style='background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;'>웹사이트 방문</a>"
	        	    + "</div>"
	        	    + "</div>"
	        	    + "</body></html>";
	        
		    messageHelper.setFrom("ecobuiltest@gmail.com"); // 보내는사람 이메일 여기선 google 메일서버 사용하는 아이디를 작성하면됨
		    messageHelper.setTo(memEmail); // 받는사람 이메일
		    messageHelper.setSubject(formattedDate + " 주문하신 상품의 결제가 완료되었습니다."); // 메일제목
		    messageHelper.setText(emailContent, true); // 메일 내용 
		    
		    mailSender.send(mimeMessage);
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        // 메일 발송 후 세션에서 제거
        session.removeAttribute("partnerOrderId");
        session.removeAttribute("representativeOrderId");
        session.removeAttribute("totalPrice");
        session.removeAttribute("quantity");
        session.removeAttribute("name");
        session.removeAttribute("prodPrices");
        session.removeAttribute("cartIds");
    	
    	return "order/paymentDone";
    };
    
    
    
}
