package com.team.green.estimate.dto;

public class AddressVO {

	 private String bunji;  // 번지
	 private String jibun;  // 지번
	public AddressVO() {
	}
	public AddressVO(String bunji, String jibun) {
		this.bunji = bunji;
		this.jibun = jibun;
	}
	@Override
	public String toString() {
		return "AddressVO [bunji=" + bunji + ", jibun=" + jibun + "]";
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	
	 
	 
}
