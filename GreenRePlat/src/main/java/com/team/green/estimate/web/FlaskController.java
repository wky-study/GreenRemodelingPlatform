package com.team.green.estimate.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.green.estimate.dto.EstimateDTO;
import com.team.green.estimate.service.EstimateService;

@Controller
public class FlaskController {

	@Autowired
	EstimateService estSvc;
	
	@GetMapping("/fetchAndSave")
	public String fetchAndSave(@RequestParam String estAddress, HttpSession session) {
		// Flask 서버 URL
		String flaskUrl = "http://192.168.0.47:5000/data?addr=" + estAddress;

		System.out.println("Flask URL: " + flaskUrl);

		// RestTemplate 생성
		RestTemplate restTemplate = new RestTemplate();

		// Flask 서버에 요청 보내기
		ResponseEntity<String> response = restTemplate.getForEntity(flaskUrl, String.class);

		System.out.println("요청 보낸 후");

		if (response.getStatusCode().is2xxSuccessful()) {
			// Flask 서버 응답을 JSON 파싱
			String responseData = response.getBody();

			System.out.println("Flask에서 온 응답: " + responseData);

			try {
				// ObjectMapper로 JSON을 JsonNode로 파싱
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(responseData);
				// "type" 값을 추출
				String type = jsonNode.get("type").asInt() + "";
				System.out.println("추출된 type 값: " + type);
				// 이 값은 DB에 저장하거나 후속 처리에 사용될 수 있습니다.
				// 예시로 DB 처리 로직 추가 가능
				EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
				est.setEstType(type);
				System.out.println("가져온 est: "+ est);
				
				estSvc.updateType(est);
				

				return "데이터가 저장되었습니다. type: " + type;
			} catch (Exception e) {
				return "Flask 응답 처리 중 오류가 발생했습니다.";
			}
		} else {
			return "Flask 서버와 통신 실패!";
		}
	}
	
	
	
	
}