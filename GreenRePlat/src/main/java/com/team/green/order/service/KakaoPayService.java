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
	
    // Logger ��ü ����
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
    
    // īī������ ����â ����
    public ReadyResponseDTO payReady(String name, int totalPrice, String memId, int quantity ,HttpSession session) {
    	
    	String representativeOrderId = (String) session.getAttribute("representativeOrderId");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // ������ �ڵ�(�׽�Ʈ��)
        parameters.put("partner_order_id", representativeOrderId);              // ��ǥ �ֹ���ȣ 
        parameters.put("partner_user_id", memId);                          		// ȸ�� ���̵�
        parameters.put("item_name", name);                                      // ��ǰ��
        parameters.put("quantity", String.valueOf(quantity));                   // ��ǰ ����
        parameters.put("total_amount", String.valueOf(totalPrice));             // ��ǰ �Ѿ�
        parameters.put("tax_free_amount", "0");                                 // ��ǰ ����� �ݾ�
        parameters.put("approval_url", "http://localhost:9090/green/order/completed"); // ���� ���� �� URL
        parameters.put("cancel_url", "http://localhost:9090/green/order/cancel");      // ���� ��� �� URL
        parameters.put("fail_url", "http://localhost:9090/green/order/fail");          // ���� ���� �� URL
        
        // HttpEntity : HTTP ��û �Ǵ� ���信 �ش��ϴ� Http Header�� Http Body�� �����ϴ� Ŭ����
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest ��� API�� ȣ���� �� �ִ� Spring ���� Ŭ����
        //   REST API ȣ�� ���� ������ ���� ������ ��ٸ��� ���� ��� (json, xml ����)
        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        
        System.out.println("url ��û ��" + requestEntity);
        
        // RestTemplate�� postForEntity : POST ��û�� ������ ResponseEntity�� ����� ��ȯ�޴� �޼ҵ�
        ResponseEntity<ReadyResponseDTO> responseEntity = template.postForEntity(url, requestEntity, ReadyResponseDTO.class);
        log.info("�����غ� ���䰴ü: " + responseEntity.getBody());
        
        System.out.println("pryReady ���� ��" + responseEntity.getBody());
        
        return responseEntity.getBody();
    }
    
    // īī������ ���� ����
    // ����ڰ� ���� ������ �����ϰ� ��й�ȣ�� �Է��� ���� ������ �Ϸ��� ��,
    // ���������� ���� �Ϸ� ó���� �ϴ� �ܰ�
    public ApproveResponseDTO payApprove(String tid, String pgToken, HttpSession session) {
    	
        MemberDTO member = (MemberDTO)session.getAttribute("memInfo");
        System.out.println(member);
        String memId = member.getMemId();
    	
    	String representativeOrderId = (String) session.getAttribute("representativeOrderId");
        
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // ������ �ڵ�(�׽�Ʈ��)
        parameters.put("tid", tid);                       // ���� ������ȣ
        parameters.put("partner_order_id", representativeOrderId); // ��ǥ �ֹ���ȣ
        parameters.put("partner_user_id", memId);    		// ȸ�� ���̵�
        parameters.put("pg_token", pgToken);              // �������� ��û�� �����ϴ� ��ū
        
        System.out.println("���� ���� ����");
        
        System.out.println(pgToken);
        
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponseDTO approveResponse = template.postForObject(url, requestEntity, ApproveResponseDTO.class);
        log.info("�������� ���䰴ü: " + approveResponse);
        
        // �����Ϸ� �� cart ���� �����ϱ�
        List<String> cartIds = (List<String>) session.getAttribute("cartIds");
	    for(int i = 0; i < cartIds.size(); i++) {
	    	cartService.delCartList(memId, cartIds.get(i));  
	    }
	    session.removeAttribute("cartIds");  // "cartIds"��� �̸��� ���� �Ӽ� ����
	    
        // DB�� ����
	    // DB for�� ���� ����Ʈ ����
        List<PaymentDTO> paymentList = new ArrayList<>();
        
        int quantity = (int)session.getAttribute("quantity"); // �ֹ� ����
        String name = (String)session.getAttribute("name"); // ��ǰ�̸� (��ǥ)
    	int totalPrice = (int)session.getAttribute("totalPrice");
    	System.out.println("��ü �ݾ�: "+ totalPrice);

    	// ���� �ֹ���ȣ
    	List<String> partnerOrderIds = (List<String>) session.getAttribute("partnerOrderIds");
    	
    	// ���� ���� integer => String ����
    	List<Integer> prodPrices = (List<Integer>) session.getAttribute("prodPrices");
    	List<String> prodPricesStr = prodPrices.stream().map(String::valueOf).collect(Collectors.toList());
    	// ���� ��ٱ��� ������ȣ
    	
    	// �ݺ����� DB�� ����
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
    
    // īī������ ���� ��û �� ����ο� �ʿ��� ��
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        
        String auth = "DEV84E409C34F42CB1E9F4933512B9BB08846910";
        
        headers.set("Authorization", "DEV_SECRET_KEY " + auth);
        headers.set("Content-type", "application/json");

        return headers;
    }
}
