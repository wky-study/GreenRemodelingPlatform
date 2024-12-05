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
		// Flask ���� URL
		String flaskUrl = "http://192.168.0.47:5000/data?addr=" + estAddress;

		System.out.println("Flask URL: " + flaskUrl);

		// RestTemplate ����
		RestTemplate restTemplate = new RestTemplate();

		// Flask ������ ��û ������
		ResponseEntity<String> response = restTemplate.getForEntity(flaskUrl, String.class);

		System.out.println("��û ���� ��");

		if (response.getStatusCode().is2xxSuccessful()) {
			// Flask ���� ������ JSON �Ľ�
			String responseData = response.getBody();

			System.out.println("Flask���� �� ����: " + responseData);

			try {
				// ObjectMapper�� JSON�� JsonNode�� �Ľ�
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(responseData);
				// "type" ���� ����
				String type = jsonNode.get("type").asInt() + "";
				System.out.println("����� type ��: " + type);
				// �� ���� DB�� �����ϰų� �ļ� ó���� ���� �� �ֽ��ϴ�.
				// ���÷� DB ó�� ���� �߰� ����
				EstimateDTO est = (EstimateDTO) session.getAttribute("keyEst");
				est.setEstType(type);
				System.out.println("������ est: "+ est);
				
				estSvc.updateType(est);
				

				return "�����Ͱ� ����Ǿ����ϴ�. type: " + type;
			} catch (Exception e) {
				return "Flask ���� ó�� �� ������ �߻��߽��ϴ�.";
			}
		} else {
			return "Flask ������ ��� ����!";
		}
	}
	
	
	
	
}