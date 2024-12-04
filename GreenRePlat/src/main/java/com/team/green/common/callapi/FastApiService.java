package com.team.green.common.callapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FastApiService {

    private final RestTemplate restTemplate;

    @Autowired
    public FastApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // POST 요청을 보내는 메서드
    public String postProductsList(String memId) {
        // FastAPI 서버 URL
        String url = "http://127.0.0.1:8000/api/products/list";

        // 요청 본문에 포함될 객체 (mem_id 전달)
        ProductRequest request = new ProductRequest(memId);

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // 요청 본문을 HttpEntity에 담기
        HttpEntity<ProductRequest> entity = new HttpEntity<>(request, headers);

        // POST 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // 응답 본문 반환
        return response.getBody();
    }
}
