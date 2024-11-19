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
        
        // ��ǰ �̸� ���� ����Ʈ
        List<String> prodName = new ArrayList<>();
        
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
            
            // ��ǰ�̸� ���
            prodName.add(orderCreateForm.getName());
            
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
        session.setAttribute("prodName", prodName);
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

        System.out.println("�Ϸ��ϰ� ���� ���� ��");
        
        // ������ �Ϸ�Ǿ����Ƿ� �ֹ� �Ϸ� �������� �����̷�Ʈ
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
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
	        String formattedDate = sdf.format(now);
	        
	    	int totalPrice = (int)session.getAttribute("totalPrice"); // ��ü �ݾ�
	    	List<String> nameList = (List)session.getAttribute("prodName");	// ���� ��ǰ��
	    	List<String> partnerOrderIds = (List)session.getAttribute("partnerOrderIds");	// ���� �ֹ���ȣ
	    	List<Integer> prodPrices = (List)session.getAttribute("prodPrices"); // ���� ����
	    	
	    	System.out.println(nameList.size()); 
	    	
	    	String price = "";
	    	
	        // ���� 
	        String emailContent = "<html><body style='font-family: Arial, sans-serif; color: #333;'>"
	        	    + "<div style='max-width: 800px; margin: 0 auto; padding: 20px; border: 1px solid #e1e1e1; border-radius: 8px; background-color: #f9f9f9;'>"
	        	    + "<h2 style='text-align: center; color: #4CAF50;'>�ֹ��Ͻ� ��ǰ�� ������ �Ϸ�Ǿ����ϴ�!</h2>"
	        	    + "<p style='font-size: 16px; color: #555;'>" + memName + " ����, <strong>�ֹ�����: " + formattedDate + "</strong></p>"
	        	    + "<p style='font-size: 16px; color: #555;'>�ֹ��Ͻ� ��ǰ�� ���� ������ ���������� �Ϸ�Ǿ����ϴ�. �ڼ��� ������ �Ʒ��� Ȯ���� �ּ���.</p>"
	        	    + "<table style='width: 100%; border-collapse: collapse; margin-top: 20px;'>"
	        	    + "<thead>"
	        	    + "<tr style='background-color: #f2f2f2;'>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>�ֹ���ȣ</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>��ǰ��</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>����</th>"
	        	    + "<th style='padding: 8px; text-align: left; border-bottom: 1px solid #ddd;'>����</th>"
	        	    + "</tr>"
	        	    + "</thead>"
	        	    + "<tbody>";
	   for(int i = 0; i < nameList.size(); i++) {
	        price = prodPrices.get(i) + "";
		   emailContent += "<tr>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + partnerOrderIds.get(i) +"</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + nameList.get(i) +"</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>" + price + "��</td>"
		        	    + "<td style='padding: 8px; border-bottom: 1px solid #ddd;'>1��</td>"
		        	    + "</tr>"
		        	    + "<tr>";		   
	   }
	   emailContent += "</tbody>"
	        	    + "</table>"
	        	    + "<p style='font-size: 16px; color: #555; margin-top: 20px;'>�ֹ� ���� Ȯ���� ���Ͻø� �������� ������Ʈ�� �湮�� �ּ���.</p>"
	        	    + "<div style='text-align: center; margin-top: 30px;'>"
	        	    + "<a href='http://localhost:9090/green/' style='background-color: #4CAF50; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;'>������Ʈ �湮</a>"
	        	    + "</div>"
	        	    + "</div>"
	        	    + "</body></html>";
	        
		    messageHelper.setFrom("ecobuiltest@gmail.com"); // �����»�� �̸��� ���⼱ google ���ϼ��� ����ϴ� ���̵� �ۼ��ϸ��
		    messageHelper.setTo(memEmail); // �޴»�� �̸���
		    messageHelper.setSubject(formattedDate + " �ֹ��Ͻ� ��ǰ�� ������ �Ϸ�Ǿ����ϴ�."); // ��������
		    messageHelper.setText(emailContent, true); // ���� ���� 
		    
		    mailSender.send(mimeMessage);
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        // ���� �߼� �� ���ǿ��� ����
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
