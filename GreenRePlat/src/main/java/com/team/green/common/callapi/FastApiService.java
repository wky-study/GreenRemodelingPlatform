package com.team.green.common.callapi;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.team.green.product.dto.ProductDTO;

@Service
public class FastApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public FastApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ��ǰ��� POST ��û�� ������ �޼���
    public String postProductsList(String memId) {
    	System.out.println(memId);
        // FastAPI ���� URL
        String url = "http://127.0.0.1:8000/api/products/list";

        // ��û ������ ���Ե� ��ü (mem_id ����)
        ProductRequest request = new ProductRequest(memId);

        // HTTP ��� ����
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=UTF-8");

        // ��û ������ HttpEntity�� ���
        HttpEntity<ProductRequest> entity = new HttpEntity<>(request, headers);

        // POST ��û ������
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        // ���� ���� ��ȯ
        String responseBody = response.getBody();
        String utf8Response = new String(responseBody.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("resp: " + utf8Response);

        // ���� ���� ��ȯ
        return utf8Response;
    }
    
    public String postOrderList(List<Map<String, String>> order) {
    	System.out.println(order);
        // FastAPI ���� URL
        String url = "http://127.0.0.1:8000/api/products/order";

        // ��û ������ ���Ե� ��ü (mem_id ����)
        List<OrderRequest> orderList = new ArrayList<>();
        for (Map<String, String> orderItem : order) {
            String prodNo = orderItem.get("prod_no");
            int prodCount = Integer.parseInt(orderItem.get("prod_count"));
            orderList.add(new OrderRequest(prodNo, prodCount));
        }

        // HTTP ��� ����
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // ��û ������ HttpEntity�� ���
        HttpEntity<List<OrderRequest>> entity = new HttpEntity<>(orderList, headers);

        // POST ��û ������
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println();
        System.out.println("resp: "+response.getBody());

        // ���� ���� ��ȯ
        String responseBody = response.getBody();
        String utf8Response = new String(responseBody.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("resp: " + utf8Response);

        // ���� ���� ��ȯ
        return utf8Response;
    }
}
