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
    
    // Logger ��ü ����
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
	
	 
    @RequestMapping(value = "/pay/ready", method = RequestMethod.POST)
    public @ResponseBody ReadyResponseDTO payReady(@RequestBody List<OrderCreateFormDTO> orderCreateFormList, HttpSession session) {
        
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        String memId = member.getMemId();
        
        // ���� ��ǰ�� ���հ� ������ ���
        int totalPrice = 0;
        int totalQuantity = 0;
        String name = null;  // ��ǥ ��ǰ �̸� (ù ��° ��ǰ �̸�)
        
        // �ֹ� ��ȣ�� ���� ����Ʈ
        List<String> partnerOrderIds = new ArrayList<>();
        
        // �̹��� src �� ���� ����Ʈ
        List<String> prodImageSrcs = new ArrayList<>();
        
        // ������ ���� ����Ʈ
        List<Integer> prodPrices = new ArrayList<>();
        
        // ��ٱ��� ������ȣ ����Ʈ
        List<String> cartIds = new ArrayList<>();

        // ��ǥ �ֹ� ��ȣ ���� (�ϳ��� �ֹ��� �ĺ��� �� �ִ� ���� ��ȣ)
        String representativeOrderId = "REP" + new Date().getTime();  // Ÿ�ӽ����� ������� ��ǥ �ֹ���ȣ ����
        log.info("��ǥ �ֹ� ��ȣ: " + representativeOrderId);
        
        System.out.println(orderCreateFormList);
        
        for (int i = 0; i < orderCreateFormList.size(); i++) {
            OrderCreateFormDTO orderCreateForm = orderCreateFormList.get(i);

            // ù ��° ��ǰ�� �̸��� ��ǥ�� ���
            if (i == 0) {
                name = orderCreateForm.getName();
            }

            // �� ��ǰ ������ ���� ���
            totalPrice += orderCreateForm.getTotalPrice();
            totalQuantity += orderCreateForm.getQuantity();

            // �� ��ǰ�� ���� �ֹ���ȣ ���� (������ �ֹ� ��ȣ)
            String v_orderNo = "ORD" + new Date().getTime() + (i + 1);  // Ÿ�ӽ����� + �ε����� ������� �ֹ���ȣ ����
            partnerOrderIds.add(v_orderNo);  // �ֹ� ��ȣ ����Ʈ�� �߰�
            
            // �̹��� src ���
            prodImageSrcs.add(orderCreateForm.getProdImageSrc());
            
            // ���� ���
            prodPrices.add(orderCreateForm.getTotalPrice());
            
            // ��ٱ��� ������ȣ ���
            cartIds.add(orderCreateForm.getCartId());
            
            // �α� ���
            log.info("�ֹ� ��ǰ �̸�: " + orderCreateForm.getName());
            log.info("�ֹ� �ݾ�: " + orderCreateForm.getTotalPrice());
            log.info("�ֹ� ����: " + orderCreateForm.getQuantity());
            log.info("�ֹ� ��ȣ: " + v_orderNo);
            
            System.out.println("����: " + prodPrices.get(i));
            System.out.println("��ٱ��� ������ȣ: " + cartIds.get(i));

        }
        
        // ���ǿ� ���� (������ ��ǰ ������ ����ǹǷ� �� ��ǰ���� �����Ϸ��� ���� Ű�� �ٸ��� ó���� �� ����)
        session.setAttribute("representativeOrderId", representativeOrderId);  // ��ǥ �ֹ���ȣ
        session.setAttribute("totalPrice", totalPrice);		// �� ����
        session.setAttribute("quantity", totalQuantity);	// ��ǰ����
        session.setAttribute("partnerOrderIds", partnerOrderIds);  // �ֹ���ȣ ����Ʈ
        session.setAttribute("name", name);  // ��ǰ�� (��ǥ)
        session.setAttribute("prodPrices", prodPrices);  // ���� ���� ����Ʈ
        session.setAttribute("cartIds", cartIds);  // ��ٱ��� ������ȣ ����Ʈ
        session.setAttribute("prodImageSrcs", prodImageSrcs);  // �̹��� src ����Ʈ
        int quantity = totalQuantity;
        
        // īī�� ���� �غ��ϱ�
        ReadyResponseDTO readyResponse = kakaoPayService.payReady(name, totalPrice, memId, quantity, session);
        
        // ���ǿ� ���� ������ȣ(tid) ����
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        log.info("���� ������ȣ: " + readyResponse.getTid());
        
        System.out.println("��Ʈ�ѷ� " + readyResponse);
        
        return readyResponse;
    }

    @RequestMapping(value = "/order/completed", method = RequestMethod.GET)
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
        session.removeAttribute("representativeOrderId");
        session.removeAttribute("totalPrice");
        session.removeAttribute("quantity");
        session.removeAttribute("name");
        session.removeAttribute("prodPrices");
        session.removeAttribute("cartIds");
        
        System.out.println("�Ϸ��ϰ� ���� ���� ��");
        
        // ������ �Ϸ�Ǿ����Ƿ� �ֹ� �Ϸ� �������� �����̷�Ʈ
        return "order/completed";
    }
    
    @RequestMapping("/paymentDone")
    public String paymentDone() {
    	System.out.println("�Ϸ�");
    	return "order/paymentDone";
    };
    
    
    
}
