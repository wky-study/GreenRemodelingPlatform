package com.team.green.common.callapi;

import java.text.DateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.team.green.product.dto.ProductDTO;

@RestController
public class FastAPIController {

	private final FastApiService fastApiService;

	@Autowired
	public FastAPIController(FastApiService fastApiService) {
		this.fastApiService = fastApiService;
	}

	// 클라이언트가 /get-products 경로로 요청을 보낼 때 FastAPI 서버에 POST 요청을 보냄
	@PostMapping("/getProducts")
	@ResponseBody
	public List<Map<String, String>> getProducts(@RequestBody Map<String, String> requestData) {
		String memId = requestData.get("memId");
		System.out.println();
		System.out.println(memId);
		String answ = fastApiService.postProductsList(memId);
		System.out.println();
		System.out.println(answ);
		System.out.println("parsing");

		List<Map<String, String>> resp = parseJsonArray(answ);
		;

		return resp;
	}

	@PostMapping("/requestOrder")
	@ResponseBody
	public Map<String, String> reqOrder(@RequestBody List<Map<String, String>> requestData) {
		System.out.println("reqdata: " + requestData);
		String answ = fastApiService.postOrderList(requestData);
		System.out.println();
		System.out.println(answ);
		System.out.println("parsing");

		Map<String, String> resp = parseJson(answ);

		System.out.println("resppp: " + resp);

		return resp;
	}

	private Map<String, String> parseJson(String jsonResponse) {
		// JSON 파싱
		Map<String, String> resp = new HashMap<>();

		JsonObject jsonObj = JsonParser.parseString(jsonResponse).getAsJsonObject();
		Set<String> keys = new HashSet<>();
		if (jsonObj != null) {
			keys = jsonObj.keySet();
		}
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			resp.put(key, String.valueOf(jsonObj.get(key).getAsString()));
		}
		return resp;
	}

	private List<Map<String, String>> parseJsonArray(String jsonResponse) {
		// JSON 파싱
		List<Map<String, String>> resp = new ArrayList<>();

		JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
		JsonObject jsonObj;
		Set<String> keys = new HashSet<>();
		if (jsonArray != null) {
			jsonObj = jsonArray.get(0).getAsJsonObject();
			keys = jsonObj.keySet();
		}
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.println(i + ": " + jsonArray.get(i));
			jsonObj = jsonArray.get(i).getAsJsonObject();
			Iterator<String> iter = keys.iterator();
			Map<String, String> temp = new HashMap<>();
			while (iter.hasNext()) {
				String key = iter.next();
				temp.put(key, String.valueOf(jsonObj.get(key).getAsString()));
			}
			resp.add(temp);
		}

		return resp;
	}

}
