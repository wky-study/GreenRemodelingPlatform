package com.team.green.order.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.green.member.dto.MemberDTO;
import com.team.green.order.dto.PaymentDTO;
import com.team.green.order.service.OrderService;

@Controller
public class ReceiptController {
	
	@Autowired
	OrderService orderService;
	
	// 주문내역  
	@RequestMapping("/orderSummary")
	public String orderSummary(HttpSession session, PaymentDTO payment, Model model) {
		
		// 세션에서 memId 가져오기
		MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
		String memId = member.getMemId();
		// DB에서 주문내역 가져오기
		List<PaymentDTO> paymentList = orderService.getOrderList(memId);
		System.out.println(paymentList);
		// model에 뿌리기
		model.addAttribute("keyPaymentList", paymentList);
		
		return "order/orderSummary";
	};
	
	// 영수증 창 띄우기 
	@RequestMapping("/receiptView")
	public String receiptView(String partnerOrderId , Model model) {
		System.out.println(partnerOrderId);
		
		PaymentDTO payment = orderService.getReceipt(partnerOrderId);
		
		System.out.println(payment);
		
		model.addAttribute("keyPayment", payment);
		
		return "order/receiptView";
	};
}
