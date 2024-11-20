package com.team.green.social.vo;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class NaverProfileVO
{
    private String id;
    private String nickname;
    private String email;
    private String mobile;
    private String name;
    private String birthyear;
    private String birthday;
    
	public NaverProfileVO(String jsonResponseBody)
    {
       @SuppressWarnings("deprecation")
	JsonParser jsonParser = new JsonParser();
       @SuppressWarnings("deprecation")
	JsonElement element = jsonParser.parse(jsonResponseBody);
       
       this.id = element.getAsJsonObject().get("response").getAsJsonObject().get("id").getAsString();
       this.nickname = element.getAsJsonObject().get("response").getAsJsonObject().get("nickname").getAsString();
       this.email = element.getAsJsonObject().get("response").getAsJsonObject().get("email").getAsString();
       this.mobile = element.getAsJsonObject().get("response").getAsJsonObject().get("mobile").getAsString();
       this.name = element.getAsJsonObject().get("response").getAsJsonObject().get("name").getAsString();
       this.birthyear = element.getAsJsonObject().get("response").getAsJsonObject().get("birthyear").getAsString();
       this.birthday = element.getAsJsonObject().get("response").getAsJsonObject().get("birthday").getAsString();
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
}
