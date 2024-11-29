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

    private static final String SERVICE_KEY = "G/yYIwXjeGYwjnyD4ILzXE22ekmc+ZYlA6bwEHASJLqMNjb2Hq99RqFYuDqConJVuf7xxGm4Fcgu2FyvvYfMCw=="; // ����Ű �Է�
    private static final String API_URL = "https://apis.data.go.kr/1613000/BldRgstHubService/getBrExposPubuseAreaInfo"; // API URL
    private static final String API_URL1 = "https://apis.data.go.kr/1613000/BldRgstHubService/getBrTitleInfo"; // API URL

    public String getBuildingAreaFromAPI(String sigunguCd, String bjdongCd, String bun, String ji, String dongNm, String hoNm) throws Exception {
       
    	StringBuilder urlBuilder;
        
        // dongNm ���� "��"�̰ų� ��� ������, �ٸ� API ȣ��
        if (dongNm == null || dongNm.isEmpty()) {
            // �ٸ� API URL�� �����Ͽ� ��û URL ����
            urlBuilder = new StringBuilder(API_URL1);
            urlBuilder.append("?serviceKey=").append(URLEncoder.encode(SERVICE_KEY, "UTF-8"))
                    .append("&sigunguCd=").append(URLEncoder.encode(sigunguCd, "UTF-8"))
                    .append("&bjdongCd=").append(URLEncoder.encode(bjdongCd, "UTF-8"))
                    .append("&bun=").append(URLEncoder.encode(bun, "UTF-8"))
                    .append("&ji=").append(URLEncoder.encode(ji, "UTF-8"));
            
        } else {
            // ���� API URL�� ��û URL ����
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
		
		urlBuilder.append("&_type=json")         				// ���� ����
		        .append("&numOfRows=1")                    // 1���� ������
		        .append("&pageNo=1");                       // ������ 1
        
        System.out.println(urlBuilder);

        // HttpURLConnection ����
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HTTP ��û ����: ���� �ڵ� " + responseCode);
        }

        // ���� �б�
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();
        
        System.out.println(response.toString());

        // ���信�� ���� ���� �Ǵ� �ٸ� ���� ����
        if (dongNm == null || dongNm.isEmpty()) {
            // �ٸ� API���� totArea ���� ����
            return parseTotalAreaFromResponse(response.toString());
        } else {
            // ���� API���� area ���� ����
            return parseAreaFromResponse(response.toString());
        }
    }

    private String parseAreaFromResponse(String jsonResponse) {
        // JSON �Ľ�
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject response = jsonObject.getAsJsonObject("response");
        JsonObject body = response.getAsJsonObject("body");
        JsonObject items = body.getAsJsonObject("items");

        if (items.has("item")) {
            // "item"�� �迭�̹Ƿ� ù ��° �׸��� ����
            JsonObject item = items.getAsJsonArray("item").get(0).getAsJsonObject();
            // ����(area) ���� ����
            if (item.has("area")) {
                return String.valueOf(item.get("area").getAsDouble()); // ���� ���� Double�� ������
            }
        }

        return "���� ����"; // ���� ������ ���� ���
    }
    
    // �ٸ� API���� �� ����(totArea) ����
    private String parseTotalAreaFromResponse(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject response = jsonObject.getAsJsonObject("response");
        JsonObject body = response.getAsJsonObject("body");
        JsonObject items = body.getAsJsonObject("items");

        if (items.has("item")) {
            JsonObject item = items.getAsJsonArray("item").get(0).getAsJsonObject();
            if (item.has("totArea")) {
                return String.valueOf(item.get("totArea").getAsDouble()); // totArea ��
            }
        }

        return "���� ����"; // ���� ������ ���� ���
    }
    
}
