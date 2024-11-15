package com.team.green.attach.dto;

public class AttachDTO {

	private int atchNo;						/* ÷������ ��ȣ */
	private int atchNoticeNo;				/* ����� notice �� ��ȣ */
	private int prodNo;						/* ����� product �� ��ȣ */
	private String atchFileName;			/* ���� ���� ���ÿ� ����� ���ϸ� */
	private String atchOriginalName;		/* ����ڰ� ÷�������� ���ϸ� */
	private long atchFileSize;				/* byte ���� ���� ������ */
	private String atchFancySize;			/* byte, KB, MB, GB ������ */
	private String atchContentType;			/* ÷������ Ȯ���� */
	private String atchPath;				/* ÷������ Ǯ ��� */
	
	
	public AttachDTO() {
	}


	public AttachDTO(int atchNo, int atchNoticeNo, int prodNo, String atchFileName, String atchOriginalName,
			long atchFileSize, String atchFancySize, String atchContentType, String atchPath) {
		this.atchNo = atchNo;
		this.atchNoticeNo = atchNoticeNo;
		this.prodNo = prodNo;
		this.atchFileName = atchFileName;
		this.atchOriginalName = atchOriginalName;
		this.atchFileSize = atchFileSize;
		this.atchFancySize = atchFancySize;
		this.atchContentType = atchContentType;
		this.atchPath = atchPath;
	}


	@Override
	public String toString() {
		return "AttachDTO [atchNo=" + atchNo + ", atchNoticeNo=" + atchNoticeNo + ", prodNo=" + prodNo
				+ ", atchFileName=" + atchFileName + ", atchOriginalName=" + atchOriginalName + ", atchFileSize="
				+ atchFileSize + ", atchFancySize=" + atchFancySize + ", atchContentType=" + atchContentType
				+ ", atchPath=" + atchPath + "]";
	}


	public int getAtchNo() {
		return atchNo;
	}


	public void setAtchNo(int atchNo) {
		this.atchNo = atchNo;
	}


	public int getAtchNoticeNo() {
		return atchNoticeNo;
	}


	public void setAtchNoticeNo(int atchNoticeNo) {
		this.atchNoticeNo = atchNoticeNo;
	}


	public int getProdNo() {
		return prodNo;
	}


	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}


	public String getAtchFileName() {
		return atchFileName;
	}


	public void setAtchFileName(String atchFileName) {
		this.atchFileName = atchFileName;
	}


	public String getAtchOriginalName() {
		return atchOriginalName;
	}


	public void setAtchOriginalName(String atchOriginalName) {
		this.atchOriginalName = atchOriginalName;
	}


	public long getAtchFileSize() {
		return atchFileSize;
	}


	public void setAtchFileSize(long atchFileSize) {
		this.atchFileSize = atchFileSize;
	}


	public String getAtchFancySize() {
		return atchFancySize;
	}


	public void setAtchFancySize(String atchFancySize) {
		this.atchFancySize = atchFancySize;
	}


	public String getAtchContentType() {
		return atchContentType;
	}


	public void setAtchContentType(String atchContentType) {
		this.atchContentType = atchContentType;
	}


	public String getAtchPath() {
		return atchPath;
	}


	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}
	
	

	
}