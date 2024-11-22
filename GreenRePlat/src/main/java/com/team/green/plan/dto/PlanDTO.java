package com.team.green.plan.dto;
import java.sql.Timestamp;
import java.util.Date;

public class PlanDTO {
	private String quoId; // 견적서 ID 
	private String estId; // 고객이 작성한 견적서 ID(고객ID)
	private String comId; // 시공사 ID
	private Timestamp quoSdate; // 공사 시작일
	private Timestamp quoEdate; // 공사 종료일
	private Timestamp quoMdate; // 견적서 수정한 날짜
	private String quoOpen; // 견적서 확정 여부
	private String memId; //멤버ID
	private String quoContNo;
	private String quoCont;

	
	public PlanDTO() {
	}
	

	public PlanDTO(String quoId, String estId, String comId, Timestamp quoSdate, Timestamp quoEdate, Timestamp quoMdate,
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


	@Override
	public String toString() {
		return "PlanDTO [quoId=" + quoId + ", estId=" + estId + ", comId=" + comId + ", quoSdate=" + quoSdate
				+ ", quoEdate=" + quoEdate + ", quoMdate=" + quoMdate + ", quoOpen=" + quoOpen + ", memId=" + memId
				+ ", quoContNo=" + quoContNo + ", quoCont=" + quoCont + "]";
	}


	public String getQuoId() {
		return quoId;
	}


	public void setQuoId(String quoId) {
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


	public Timestamp getQuoSdate() {
		return quoSdate;
	}


	public void setQuoSdate(Timestamp quoSdate) {
		this.quoSdate = quoSdate;
	}


	public Timestamp getQuoEdate() {
		return quoEdate;
	}


	public void setQuoEdate(Timestamp quoEdate) {
		this.quoEdate = quoEdate;
	}


	public Timestamp getQuoMdate() {
		return quoMdate;
	}


	public void setQuoMdate(Timestamp quoMdate) {
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

	

}
