package com.team.green.estimate.dto;

public class EstimateDTO {

	private int estId;
	private String memId;
	private String estAddress;
	private String dongNm;
	private String hoNm;
	private String estSdate;
	private String estInteriorDesc;
	private String estSubmit;
	private String sigunguCd;
	private String bjdongCd;
	private String estArea;
	private String comId;
	private String estType;
	
	public EstimateDTO() {
	}

	public EstimateDTO(int estId, String memId, String estAddress, String dongNm, String hoNm, String estSdate,
			String estInteriorDesc, String estSubmit, String sigunguCd, String bjdongCd, String estArea, String comId,
			String estType) {
		this.estId = estId;
		this.memId = memId;
		this.estAddress = estAddress;
		this.dongNm = dongNm;
		this.hoNm = hoNm;
		this.estSdate = estSdate;
		this.estInteriorDesc = estInteriorDesc;
		this.estSubmit = estSubmit;
		this.sigunguCd = sigunguCd;
		this.bjdongCd = bjdongCd;
		this.estArea = estArea;
		this.comId = comId;
		this.estType = estType;
	}

	@Override
	public String toString() {
		return "EstimateDTO [estId=" + estId + ", memId=" + memId + ", estAddress=" + estAddress + ", dongNm=" + dongNm
				+ ", hoNm=" + hoNm + ", estSdate=" + estSdate + ", estInteriorDesc=" + estInteriorDesc + ", estSubmit="
				+ estSubmit + ", sigunguCd=" + sigunguCd + ", bjdongCd=" + bjdongCd + ", estArea=" + estArea
				+ ", comId=" + comId + ", estType=" + estType + "]";
	}

	public int getEstId() {
		return estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getEstAddress() {
		return estAddress;
	}

	public void setEstAddress(String estAddress) {
		this.estAddress = estAddress;
	}

	public String getDongNm() {
		return dongNm;
	}

	public void setDongNm(String dongNm) {
		this.dongNm = dongNm;
	}

	public String getHoNm() {
		return hoNm;
	}

	public void setHoNm(String hoNm) {
		this.hoNm = hoNm;
	}

	public String getEstSdate() {
		return estSdate;
	}

	public void setEstSdate(String estSdate) {
		this.estSdate = estSdate;
	}

	public String getEstInteriorDesc() {
		return estInteriorDesc;
	}

	public void setEstInteriorDesc(String estInteriorDesc) {
		this.estInteriorDesc = estInteriorDesc;
	}

	public String getEstSubmit() {
		return estSubmit;
	}

	public void setEstSubmit(String estSubmit) {
		this.estSubmit = estSubmit;
	}

	public String getSigunguCd() {
		return sigunguCd;
	}

	public void setSigunguCd(String sigunguCd) {
		this.sigunguCd = sigunguCd;
	}

	public String getBjdongCd() {
		return bjdongCd;
	}

	public void setBjdongCd(String bjdongCd) {
		this.bjdongCd = bjdongCd;
	}

	public String getEstArea() {
		return estArea;
	}

	public void setEstArea(String estArea) {
		this.estArea = estArea;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getEstType() {
		return estType;
	}

	public void setEstType(String estType) {
		this.estType = estType;
	}





	
	
	
}
