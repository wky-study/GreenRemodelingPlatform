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

    // POST ��û�� ������ �޼���
    public String postProductsList(String memId) {
        // FastAPI ���� URL
        String url = "http://127.0.0.1:8000/api/products/list";

        // ��û ������ ���Ե� ��ü (mem_id ����)
        ProductRequest request = new ProductRequest(memId);

        // HTTP ��� ����
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // ��û ������ HttpEntity�� ���
        HttpEntity<ProductRequest> entity = new HttpEntity<>(request, headers);

        // POST ��û ������
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // ���� ���� ��ȯ
        return response.getBody();
    }
}
