package com.team.green.estimate.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class BuildingAPIClient {

    private static final String SERVICE_KEY = "G/yYIwXjeGYwjnyD4ILzXE22ekmc+ZYlA6bwEHASJLqMNjb2Hq99RqFYuDqConJVuf7xxGm4Fcgu2FyvvYfMCw=="; // 인증키 입력
    private static final String API_URL = "https://apis.data.go.kr/1613000/BldRgstHubService/getBrExposPubuseAreaInfo"; // API URL
    private static final String API_URL1 = "https://apis.data.go.kr/1613000/BldRgstHubService/getBrTitleInfo"; // API URL

    public String getBuildingAreaFromAPI(String sigunguCd, String bjdongCd, String bun, String ji, String dongNm, String hoNm) throws Exception {
       
    	StringBuilder urlBuilder;
        
        // dongNm 값이 "동"이거나 비어 있으면, 다른 API 호출
        if (dongNm == null || dongNm.isEmpty()) {
            // 다른 API URL로 변경하여 요청 URL 생성
            urlBuilder = new StringBuilder(API_URL1);
            urlBuilder.append("?serviceKey=").append(URLEncoder.encode(SERVICE_KEY, "UTF-8"))
                    .append("&sigunguCd=").append(URLEncoder.encode(sigunguCd, "UTF-8"))
                    .append("&bjdongCd=").append(URLEncoder.encode(bjdongCd, "UTF-8"))
                    .append("&bun=").append(URLEncoder.encode(bun, "UTF-8"))
                    .append("&ji=").append(URLEncoder.encode(ji, "UTF-8"));
            
        } else {
            // 기존 API URL로 요청 URL 생성
            urlBuilder = new StringBuilder(API_URL);
            urlBuilder.append("?serviceKey=").append(URLEncoder.encode(SERVICE_KEY, "UTF-8"))
                    .append("&sigunguCd=").append(URLEncoder.encode(sigunguCd, "UTF-8"))
                    .append("&bjdongCd=").append(URLEncoder.encode(bjdongCd, "UTF-8"))
                    .append("&bun=").append(URLEncoder.encode(bun, "UTF-8"))
                    .append("&ji=").append(URLEncoder.encode(ji, "UTF-8"))
                    .append("&dongNm=").append(URLEncoder.encode(dongNm, "UTF-8"));
            
            if (hoNm != null && !hoNm.isEmpty()) {
                urlBuilder.append("&hoNm=").append(URLEncoder.encode(hoNm, "UTF-8"));
            }
        }
		
		urlBuilder.append("&_type=json")         				// 응답 포맷
		        .append("&numOfRows=1")                    // 1개만 가져옴
		        .append("&pageNo=1");                       // 페이지 1
        
        System.out.println(urlBuilder);

        // HttpURLConnection 설정
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP 요청 실패: 응답 코드 " + responseCode);
        }

        // 응답 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();
        
        System.out.println(response.toString());

        // 응답에서 면적 정보 또는 다른 정보 추출
        if (dongNm == null || dongNm.isEmpty()) {
            // 다른 API에서 totArea 값을 추출
            return parseTotalAreaFromResponse(response.toString());
        } else {
            // 기존 API에서 area 값을 추출
            return parseAreaFromResponse(response.toString());
        }
    }

    private String parseAreaFromResponse(String jsonResponse) {
        // JSON 파싱
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject response = jsonObject.getAsJsonObject("response");
        JsonObject body = response.getAsJsonObject("body");
        JsonObject items = body.getAsJsonObject("items");

        if (items.has("item")) {
            // "item"은 배열이므로 첫 번째 항목을 추출
            JsonObject item = items.getAsJsonArray("item").get(0).getAsJsonObject();
            // 면적(area) 정보 추출
            if (item.has("area")) {
                return String.valueOf(item.get("area").getAsDouble()); // 면적 값을 Double로 가져옴
            }
        }

        return "정보 없음"; // 면적 정보가 없는 경우
    }
    
    // 다른 API에서 총 면적(totArea) 추출
    private String parseTotalAreaFromResponse(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject response = jsonObject.getAsJsonObject("response");
        JsonObject body = response.getAsJsonObject("body");
        JsonObject items = body.getAsJsonObject("items");

        if (items.has("item")) {
            JsonObject item = items.getAsJsonArray("item").get(0).getAsJsonObject();
            if (item.has("totArea")) {
                return String.valueOf(item.get("totArea").getAsDouble()); // totArea 값
            }
        }

        return "정보 없음"; // 면적 정보가 없는 경우
    }
    
}
