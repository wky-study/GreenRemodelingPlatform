package com.team.green.member.dto;

import java.util.*;

public class MemberDTO {

	private String memName;		//	회원이름	사업자이름
	private String memId;		//	ID
	private String memPw;		//	비밀번호
	private String memRn;		//	주민번호	사업자등록번호
	private String memAddress;	//	회원주소	사업자주소
	private String memPhone;	//	전화번호	사업자대표번호
	private String memNick;		//	닉네임		닉네임
	private String memType;		//	회원유형	사업자유형
								//	0: 관리자, 1: 일반회원, 5: 시공사, 6: 판매사, 7: 설계사
	private String memImg;		//	프로필Img	프로필Img(로고)
	private String comCeo;		//	없음		대표자명
	private String comBrc;		//	없음		사업자등록증
	private String comMaNm;		//	없음		담당자명	
	private String comMaPn;		//	없음		담당자번호
	private String memHp;		//	HP주소		HP주소
	private Date memDate;		//	가입일
	private String memEmail;		//	이메일 		이메일
	
	public MemberDTO() {
	}

	public MemberDTO(String memName, String memId, String memPw, String memRn, String memAddress, String memPhone,
			String memNick, String memType, String memImg, String comCeo, String comBrc, String comMaNm, String comMaPn,
			String memHp, Date memDate, String memEmail) {
		this.memName = memName;
		this.memId = memId;
		this.memPw = memPw;
		this.memRn = memRn;
		this.memAddress = memAddress;
		this.memPhone = memPhone;
		this.memNick = memNick;
		this.memType = memType;
		this.memImg = memImg;
		this.comCeo = comCeo;
		this.comBrc = comBrc;
		this.comMaNm = comMaNm;
		this.comMaPn = comMaPn;
		this.memHp = memHp;
		this.memDate = memDate;
		this.memEmail = memEmail;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemRn() {
		return memRn;
	}

	public void setMemRn(String memRn) {
		this.memRn = memRn;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	public String getMemImg() {
		return memImg;
	}

	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}

	public String getComCeo() {
		return comCeo;
	}

	public void setComCeo(String comCeo) {
		this.comCeo = comCeo;
	}

	public String getComBrc() {
		return comBrc;
	}

	public void setComBrc(String comBrc) {
		this.comBrc = comBrc;
	}

	public String getComMaNm() {
		return comMaNm;
	}

	public void setComMaNm(String comMaNm) {
		this.comMaNm = comMaNm;
	}

	public String getComMaPn() {
		return comMaPn;
	}

	public void setComMaPn(String comMaPn) {
		this.comMaPn = comMaPn;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public Date getMemDate() {
		return memDate;
	}

	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	@Override
	public String toString() {
		return "MemberDTO [memName=" + memName + ", memId=" + memId + ", memPw=" + memPw + ", memRn=" + memRn
				+ ", memAddress=" + memAddress + ", memPhone=" + memPhone + ", memNick=" + memNick + ", memType="
				+ memType + ", memImg=" + memImg + ", comCeo=" + comCeo + ", comBrc=" + comBrc + ", comMaNm=" + comMaNm
				+ ", comMaPn=" + comMaPn + ", memHp=" + memHp + ", memDate=" + memDate + ", memEmail=" + memEmail
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
