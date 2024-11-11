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
    
    // Logger ��ü ����
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
	
	 
    @RequestMapping(value = "/pay/ready", method = RequestMethod.POST)
    public @ResponseBody ReadyResponseDTO payReady(@RequestBody OrderCreateFormDTO orderCreateForm, HttpServletRequest request) {
        
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();
        
        log.info("�ֹ� ��ǰ �̸�: " + name);
        log.info("�ֹ� �ݾ�: " + totalPrice);

        // īī�� ���� �غ��ϱ�
        ReadyResponseDTO readyResponse = kakaoPayService.payReady(name, totalPrice, request.getContextPath());
        
        // ���ǿ� ���� ������ȣ(tid) ����
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("���� ������ȣ: " + readyResponse.getTid());
        
        System.out.println("��Ʈ�ѷ� " + readyResponse);
        
        return readyResponse;
    }

    @RequestMapping(value = "/pay/completed", method = RequestMethod.GET)
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        
        // ���ǿ��� ���� ������ȣ(tid) ��������
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("�������� ��û�� �����ϴ� ��ū: " + pgToken);
        log.info("���� ������ȣ: " + tid);
        
        System.out.println("payApprove �����");
        
        // īī�� ���� ���� ��û
        ApproveResponseDTO approveResponse = kakaoPayService.payApprove(tid, pgToken);

        // ������ �Ϸ�Ǿ����Ƿ� �ֹ� �Ϸ� �������� �����̷�Ʈ
        return "order/completed";
    }
    
    @GetMapping("/paymentDone")
    public String paymentDoneView() {
    	
    	
    	
    	return "order/paymentDone";
    }
    
    
}
