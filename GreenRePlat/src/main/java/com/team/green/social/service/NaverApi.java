package com.team.green.social.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.team.green.social.vo.NaverProfileVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NaverApi {
	
	@Value("#{util['naver.login.clientId']}")
    private String naverClientId;

	@Value("#{util['naver.login.clientSecret']}")
    private String naverClientSecret;
	
    public String getNaverClientId() {
		return naverClientId;
	}

	public String getNaverClientSecret() {
		return naverClientSecret;
	}
    
	public String getAccessToken(String code, String state) {
		
	    String reqUrl = "https://nid.naver.com/oauth2.0/token";
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // HttpHeader Object
	    HttpHeaders headers = new HttpHeaders();
	    
	    // HttpBody Object
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("grant_type", "authorization_code");
	    params.add("client_id", naverClientId);
	    params.add("client_secret", naverClientSecret);
	    params.add("code", code);
	    params.add("state", state);
	    
	    System.out.println(naverClientId);
	    System.out.println("params : "+  params.get("client_id"));
	    
	    // http body params 와 http headers 를 가진 엔티티
	    HttpEntity<MultiValueMap<String, String>> naverTokenRequest = new HttpEntity<>(params, headers);
	    
	    // reqUrl로 Http 요청, POST 방식
	    ResponseEntity<String> response = restTemplate.exchange(reqUrl,
	                                              HttpMethod.POST,
	                                              naverTokenRequest,
	                                              String.class);
	    
	    String responseBody = response.getBody();
	    JsonObject asJsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
	    
	    System.out.println( "getAccessToken 리턴 전"+ asJsonObject);
	    
	    return asJsonObject.get("access_token").getAsString();
	}
	
	public NaverProfileVO getUserInfo(String accessToken)
	{
	    String reqUrl = "https://openapi.naver.com/v1/nid/me";
	    
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // HttpHeader 오브젝트
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Bearer " + accessToken);
	    
	    HttpEntity<MultiValueMap<String, String>> naverProfileRequest = new HttpEntity<>(headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange(reqUrl,
	                                              HttpMethod.POST,
	                                              naverProfileRequest,
	                                              String.class);
	    
	    System.out.println("response = " + response);
	    NaverProfileVO naverProfile = new NaverProfileVO(response.getBody());
	    
	    return naverProfile;
	}
    
}
