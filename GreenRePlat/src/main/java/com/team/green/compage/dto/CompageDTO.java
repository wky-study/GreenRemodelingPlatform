package com.team.green.compage.dto;

import java.util.Date;

public class CompageDTO {

	private int cpNo;				/* �Խñ� ��ȣ */
	private String memId;				/* �ۼ��� ���̵� */
	private String cpTitle;			/* mem_img */
	private String cpContent;		/* (������) */
	private Date cpDate;			/* �ۼ��� */
	private String delYn;				/* ���� ���� */
	private String cpPath;			/* ��Ʈ��������� */
	private String memName;				/* ����� */
	private int cpCount;			/* �Խñ� ��ȸ�� */

	public CompageDTO() {
	}

	@Override
	public String toString() {
		return "CompageDTO [cpNo=" + cpNo + ", memId=" + memId + ", cpTitle=" + cpTitle + ", cpContent=" + cpContent
				+ ", cpDate=" + cpDate + ", delYn=" + delYn + ", cpPath=" + cpPath + ", memName=" + memName
				+ ", cpCount=" + cpCount + "]";
	}

	public CompageDTO(int cpNo, String memId, String cpTitle, String cpContent, Date cpDate, String delYn,
			String cpPath, String memName, int cpCount) {
		super();
		this.cpNo = cpNo;
		this.memId = memId;
		this.cpTitle = cpTitle;
		this.cpContent = cpContent;
		this.cpDate = cpDate;
		this.delYn = delYn;
		this.cpPath = cpPath;
		this.memName = memName;
		this.cpCount = cpCount;
	}

	public int getCpNo() {
		return cpNo;
	}

	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getCpTitle() {
		return cpTitle;
	}

	public void setCpTitle(String cpTitle) {
		this.cpTitle = cpTitle;
	}

	public String getCpContent() {
		return cpContent;
	}

	public void setCpContent(String cpContent) {
		this.cpContent = cpContent;
	}

	public Date getCpDate() {
		return cpDate;
	}

	public void setCpDate(Date cpDate) {
		this.cpDate = cpDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getCpPath() {
		return cpPath;
	}

	public void setCpPath(String cpPath) {
		this.cpPath = cpPath;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getCpCount() {
		return cpCount;
	}

	public void setCpCount(int cpCount) {
		this.cpCount = cpCount;
	}

	
}
