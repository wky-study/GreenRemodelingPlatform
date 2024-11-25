package com.team.green.plan.dto;
import java.sql.Timestamp;
import java.util.Date;

public class PlanDTO {
	private int quoId; // 견적서 ID 
	private String estId; // 고객이 작성한 견적서 ID(고객ID)
	private String comId; // 시공사 ID
	private String quoSdate; // 공사 시작일
	private String quoEdate; // 공사 종료일
	private String quoMdate; // 견적서 수정한 날짜
	private String quoOpen; // 견적서 확정 여부
	private String memId; //멤버ID
	private String quoContNo;
	private String quoCont;

	
	public PlanDTO() {
	}


	public int getQuoId() {
		return quoId;
	}


	public void setQuoId(int quoId) {
		this.quoId = quoId;
	}


	public String getEstId() {
		return estId;
	}


	public void setEstId(String estId) {
		this.estId = estId;
	}


	public String getComId() {
		return comId;
	}


	public void setComId(String comId) {
		this.comId = comId;
	}


	public String getQuoSdate() {
		return quoSdate;
	}


	public void setQuoSdate(String quoSdate) {
		this.quoSdate = quoSdate;
	}


	public String getQuoEdate() {
		return quoEdate;
	}


	public void setQuoEdate(String quoEdate) {
		this.quoEdate = quoEdate;
	}


	public String getQuoMdate() {
		return quoMdate;
	}


	public void setQuoMdate(String quoMdate) {
		this.quoMdate = quoMdate;
	}


	public String getQuoOpen() {
		return quoOpen;
	}


	public void setQuoOpen(String quoOpen) {
		this.quoOpen = quoOpen;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getQuoContNo() {
		return quoContNo;
	}


	public void setQuoContNo(String quoContNo) {
		this.quoContNo = quoContNo;
	}


	public String getQuoCont() {
		return quoCont;
	}


	public void setQuoCont(String quoCont) {
		this.quoCont = quoCont;
	}


	@Override
	public String toString() {
		return "PlanDTO [quoId=" + quoId + ", estId=" + estId + ", comId=" + comId + ", quoSdate=" + quoSdate
				+ ", quoEdate=" + quoEdate + ", quoMdate=" + quoMdate + ", quoOpen=" + quoOpen + ", memId=" + memId
				+ ", quoContNo=" + quoContNo + ", quoCont=" + quoCont + "]";
	}


	public PlanDTO(int quoId, String estId, String comId, String quoSdate, String quoEdate, String quoMdate,
			String quoOpen, String memId, String quoContNo, String quoCont) {
		super();
		this.quoId = quoId;
		this.estId = estId;
		this.comId = comId;
		this.quoSdate = quoSdate;
		this.quoEdate = quoEdate;
		this.quoMdate = quoMdate;
		this.quoOpen = quoOpen;
		this.memId = memId;
		this.quoContNo = quoContNo;
		this.quoCont = quoCont;
	}


	
	

	

}
