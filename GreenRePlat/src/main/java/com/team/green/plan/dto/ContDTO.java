package com.team.green.plan.dto;

public class ContDTO {
	private String contNo; // ��۹�ȣ(PK)
	private int quoId; // ������ ID (FK)
	private String memId; // ��� �ۼ��� ���̵� (FK) 
	private String cont; // ��۳���
	private String contDate; // ����ۼ���¥
	private String contDel; // ��� ���� ����
	
	public ContDTO() {
	}

	public ContDTO(String contNo, int quoId, String memId, String cont, String contDate, String contDel) {
		super();
		this.contNo = contNo;
		this.quoId = quoId;
		this.memId = memId;
		this.cont = cont;
		this.contDate = contDate;
		this.contDel = contDel;
	}

	@Override
	public String toString() {
		return "ContDTO [contNo=" + contNo + ", quoId=" + quoId + ", memId=" + memId + ", cont=" + cont + ", contDate="
				+ contDate + ", contDel=" + contDel + "]";
	}

	public String getContNo() {
		return contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public int getQuoId() {
		return quoId;
	}

	public void setQuoId(int quoId) {
		this.quoId = quoId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getContDate() {
		return contDate;
	}

	public void setContDate(String contDate) {
		this.contDate = contDate;
	}

	public String getContDel() {
		return contDel;
	}

	public void setContDel(String contDel) {
		this.contDel = contDel;
	}

	
	
}


