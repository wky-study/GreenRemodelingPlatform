package com.team.green.estimate.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.team.green.estimate.dto.AddressVO;

@Service
public class KakaoAddressService {

    private final String KAKAO_API_KEY = "171fb9566372cf9d17d200f53126c029";  // īī�� API Ű
    
    public AddressVO getFormattedAddress(String address) {
        System.out.println(address);
        
        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + KAKAO_API_KEY);
        headers.set("Content-Type", "application/json;charset=UTF-8");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // JSON ������ ó��
        JsonObject jsonResponse = JsonParser.parseString(response.getBody()).getAsJsonObject();
        System.out.println("Raw Response: " + jsonResponse.toString()); // ���� ������ Ȯ��

        // "documents" �迭�� ��� �ִ��� Ȯ��
        if (jsonResponse.getAsJsonArray("documents").size() == 0) {
            System.out.println("No address found for the given query: " + address);
            return new AddressVO("0000", "0000"); // �ּҰ� ������ �⺻���� "0000"�� ��ȯ
        }

        JsonObject addressObj = jsonResponse.getAsJsonArray("documents").get(0).getAsJsonObject().getAsJsonObject("address");

        // ������ ���� �� ó��
        String bunji = addressObj.has("main_address_no") ? addressObj.get("main_address_no").getAsString() : "0000";
        // ����(sub_address_no) �� ó��, ������ "0000" �⺻�� ó��
        String jibun = addressObj.has("sub_address_no") && !addressObj.get("sub_address_no").getAsString().isEmpty()
                       ? addressObj.get("sub_address_no").getAsString() : "0000";
        System.out.println("Main Address No: " + bunji);
        System.out.println("Sub Address No: " + jibun);

        // ������ ������ "0000" �������� ������
        String formattedBunji = String.format("%04d", Integer.parseInt(bunji));
        String formattedJibun = String.format("%04d", Integer.parseInt(jibun));

        // AddressVO ��ü�� ���
        return new AddressVO(formattedBunji, formattedJibun);
    }

}
