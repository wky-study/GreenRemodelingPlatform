package com.team.green.kakao.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class KakaoService {

    public String getAccessToken(String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // POST ��û ����
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // POST ��û �Ķ���� ����
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=171fb9566372cf9d17d200f53126c029"); // ������ �߱޹��� key
            sb.append("&redirect_uri=http://localhost:9090/green/member/kakaoLogin"); // ������ ������ �ּ�
            sb.append("&code=").append(authorize_code);
            bw.write(sb.toString());
            bw.flush();

            // ���� �ڵ� Ȯ��
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            // JSON ���� ó��
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            System.out.println("response body : " + response);

            // JSON �Ľ�
            Gson gson = new Gson();
            JsonObject responseJson = gson.fromJson(response.toString(), JsonObject.class);

            access_Token = responseJson.get("access_token").getAsString();
            refresh_Token = responseJson.get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }

    public HashMap<String, Object> getUserInfo(String access_Token) {

        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Authorization ��� �߰�
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            // ���� �ڵ� Ȯ��
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            // JSON ���� ó��
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            System.out.println("response body : " + response);

            // JSON �Ľ�
            Gson gson = new Gson();
            JsonObject responseJson = gson.fromJson(response.toString(), JsonObject.class);

            JsonObject properties = responseJson.getAsJsonObject("properties");
            JsonObject kakaoAccount = responseJson.getAsJsonObject("kakao_account");

            // �г��� ����
            String nickname = properties.get("nickname").getAsString();
            userInfo.put("nickname", nickname);

            // �̸����� �ʿ��ϸ� �Ʒ� �ڵ� Ȱ��ȭ
            // String email = kakaoAccount.get("email").getAsString();
            // userInfo.put("email", email);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
