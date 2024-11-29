package com.team.green.member.dto;

import java.util.*;

public class MemberDTO {

	private String memName;		//	ȸ���̸�	������̸�
	private String memId;		//	ID
	private String memPw;		//	��й�ȣ
	private String memRn;		//	�ֹι�ȣ	����ڵ�Ϲ�ȣ
	private String memAddress;	//	ȸ���ּ�	������ּ�
	private String memPhone;	//	��ȭ��ȣ	����ڴ�ǥ��ȣ
	private String memNick;		//	�г���		�г���
	private String memType;		//	ȸ������	���������
								//	0: ������, 1: �Ϲ�ȸ��, 5: �ð���, 6: �ǸŻ�, 7: �����
	private String memImg;		//	������Img	������Img(�ΰ�)
	private String comCeo;		//	����		��ǥ�ڸ�
	private String comBrc;		//	����		����ڵ����
	private String comMaNm;		//	����		����ڸ�	
	private String comMaPn;		//	����		����ڹ�ȣ
	private String memHp;		//	HP�ּ�		HP�ּ�
	private Date memDate;		//	������
	private String memEmail;		//	�̸��� 		�̸���
	
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
