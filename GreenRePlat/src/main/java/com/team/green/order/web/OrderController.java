package com.team.green.order.web;

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
    
    // Logger ��ü ����
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
	
	 
    @RequestMapping(value = "/pay/ready", method = RequestMethod.POST)
    public @ResponseBody ReadyResponseDTO payReady(@RequestBody OrderCreateFormDTO orderCreateForm, HttpSession session) {
        
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        String memId = member.getMemId();
        String partnerOrderId = orderCreateForm.getPartnerOrderId();
        // ���ǿ� ���
        session.setAttribute("partnerOrderId",partnerOrderId);
        session.setAttribute("itemName",name);
        session.setAttribute("totalPrice",totalPrice);
        
        
        log.info("�ֹ� ��ǰ �̸�: " + name);
        log.info("�ֹ� �ݾ�: " + totalPrice);
        log.info("�ֹ��� �̸�: " + memId);
        log.info("�ֹ���ȣ: " + partnerOrderId);

        // īī�� ���� �غ��ϱ�
        ReadyResponseDTO readyResponse = kakaoPayService.payReady(name, totalPrice, memId, session);
        
        // ���ǿ� ���� ������ȣ(tid) ����
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("���� ������ȣ: " + readyResponse.getTid());
        
        System.out.println("��Ʈ�ѷ� " + readyResponse);
        
        return readyResponse;
    }

    @RequestMapping(value = "/pay/completed", method = RequestMethod.GET)
    public String payCompleted(@RequestParam("pg_token") String pgToken, HttpSession session) {
        
        // ���ǿ��� ���� ������ȣ(tid) ��������
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("�������� ��û�� �����ϴ� ��ū: " + pgToken);
        log.info("���� ������ȣ: " + tid);
        log.info("�ֹ���ȣ: " + session.getAttribute("partnerOrderId"));
        
        System.out.println("payApprove �����");
        
        // īī�� ���� ���� ��û
        ApproveResponseDTO approveResponse = kakaoPayService.payApprove(tid, pgToken, session);

        // ���� �Ϸ� �� ���ǿ��� partnerOrderId ����
        session.removeAttribute("partnerOrderId");
        
        // ������ �Ϸ�Ǿ����Ƿ� �ֹ� �Ϸ� �������� �����̷�Ʈ
        return "order/completed";
    }
    
    @GetMapping("/paymentDone")
    public String paymentDoneView() {
    	
    	
    	
    	return "order/paymentDone";
    }
    
    
}
