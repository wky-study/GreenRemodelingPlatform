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
	
	// �ֹ�����  
	@RequestMapping("/orderSummary")
	public String orderSummary(HttpSession session, PaymentDTO payment, Model model) {
		
		// ���ǿ��� memId ��������
		MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
		String memId = member.getMemId();
		// DB���� �ֹ����� ��������
		List<PaymentDTO> paymentList = orderService.getOrderList(memId);
		System.out.println(paymentList);
		// model�� �Ѹ���
		model.addAttribute("keyPaymentList", paymentList);
		
		return "order/orderSummary";
	};
	
	// ������ â ���� 
	@RequestMapping("/receiptView")
	public String receiptView(String partnerOrderId , Model model) {
		System.out.println(partnerOrderId);
		
		PaymentDTO payment = orderService.getReceipt(partnerOrderId);
		
		System.out.println(payment);
		
		model.addAttribute("keyPayment", payment);
		
		return "order/receiptView";
	};
}
