package com.team.green.order.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import com.team.green.order.dto.ApproveResponseDTO;
import com.team.green.order.dto.ReadyResponseDTO;

@Service
public class KakaoPayService {

	
    // Logger ��ü ����
    private static final Logger log = LoggerFactory.getLogger(KakaoPayService.class);
    
    // īī������ ����â ����
    public ReadyResponseDTO payReady(String name, int totalPrice, String contextPath) {
    	
    	System.out.println("pryReady ����");
    	System.out.println(contextPath);
    	
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // ������ �ڵ�(�׽�Ʈ��)
        parameters.put("partner_order_id", "1234567890");                       // �ֹ���ȣ
        parameters.put("partner_user_id", "roommake");                          // ȸ�� ���̵�
        parameters.put("item_name", name);                                      // ��ǰ��
        parameters.put("quantity", "1");                                        // ��ǰ ����
        parameters.put("total_amount", String.valueOf(totalPrice));             // ��ǰ �Ѿ�
        parameters.put("tax_free_amount", "0");                                 // ��ǰ ����� �ݾ�
        parameters.put("approval_url", "http://localhost:9090/green/pay/completed"); // ���� ���� �� URL
        parameters.put("cancel_url", "http://localhost:9090/green/pay/cancel");      // ���� ��� �� URL
        parameters.put("fail_url", "http://localhost:9090/green/pay/fail");          // ���� ���� �� URL
        
        System.out.println("pryReady �߰�");

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
    public ApproveResponseDTO payApprove(String tid, String pgToken) {
    	
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");              // ������ �ڵ�(�׽�Ʈ��)
        parameters.put("tid", tid);                       // ���� ������ȣ
        parameters.put("partner_order_id", "1234567890"); // �ֹ���ȣ
        parameters.put("partner_user_id", "roommake");    // ȸ�� ���̵�
        parameters.put("pg_token", pgToken);              // �������� ��û�� �����ϴ� ��ū
        
        System.out.println("���� ���� ����");
        
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponseDTO approveResponse = template.postForObject(url, requestEntity, ApproveResponseDTO.class);
        log.info("�������� ���䰴ü: " + approveResponse);

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