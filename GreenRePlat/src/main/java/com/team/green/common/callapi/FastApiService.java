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

    // 상품목록 POST 요청을 보내는 메서드
    public String postProductsList(String memId) {
    	System.out.println(memId);
        // FastAPI 서버 URL
        String url = "http://127.0.0.1:8000/api/products/list";

        // 요청 본문에 포함될 객체 (mem_id 전달)
        ProductRequest request = new ProductRequest(memId);

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=UTF-8");

        // 요청 본문을 HttpEntity에 담기
        HttpEntity<ProductRequest> entity = new HttpEntity<>(request, headers);

        // POST 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        // 응답 본문 반환
        String responseBody = response.getBody();
        String utf8Response = new String(responseBody.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("resp: " + utf8Response);

        // 응답 본문 반환
        return utf8Response;
    }
    
    public String postOrderList(List<Map<String, String>> order) {
    	System.out.println(order);
        // FastAPI 서버 URL
        String url = "http://127.0.0.1:8000/api/products/order";

        // 요청 본문에 포함될 객체 (mem_id 전달)
        List<OrderRequest> orderList = new ArrayList<>();
        for (Map<String, String> orderItem : order) {
            String prodNo = orderItem.get("prod_no");
            int prodCount = Integer.parseInt(orderItem.get("prod_count"));
            orderList.add(new OrderRequest(prodNo, prodCount));
        }

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 요청 본문을 HttpEntity에 담기
        HttpEntity<List<OrderRequest>> entity = new HttpEntity<>(orderList, headers);

        // POST 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println();
        System.out.println("resp: "+response.getBody());

        // 응답 본문 반환
        String responseBody = response.getBody();
        String utf8Response = new String(responseBody.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("resp: " + utf8Response);

        // 응답 본문 반환
        return utf8Response;
    }
}
