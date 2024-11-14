package com.team.green.compage.dto;

import java.util.Date;

public class CompageDTO {

	private int cpNo;				/* ���� �Խñ� ��ȣ */
	private String memId;				/* �ۼ��� ���̵� */
	private String memName;				/* �ۼ��� �̸� */
	private String cpTitle;			/* ���� �Խñ� ���� */
	private String cpContent;		/* ���� �Խñ� ���� */
	private Date cpDate;			/* �ۼ��� */
	private String cpPath;			/* ���ϰ�� */
	private String delYn;				/* ���� ���� */
	private int cpCount;			/* �Խñ� ��ȸ�� */

	public CompageDTO() {
	}

	public CompageDTO(int cpNo, String memId, String memName, String cpTitle, String cpContent, Date cpDate,
			String cpPath, String delYn, int cpCount) {
		this.cpNo = cpNo;
		this.memId = memId;
		this.memName = memName;
		this.cpTitle = cpTitle;
		this.cpContent = cpContent;
		this.cpDate = cpDate;
		this.cpPath = cpPath;
		this.delYn = delYn;
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

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
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

	public String getCpPath() {
		return cpPath;
	}

	public void setCpPath(String cpPath) {
		this.cpPath = cpPath;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public int getCpCount() {
		return cpCount;
	}

	public void setCpCount(int cpCount) {
		this.cpCount = cpCount;
	}

	@Override
	public String toString() {
		return "CompageDTO [cpNo=" + cpNo + ", memId=" + memId + ", memName=" + memName + ", cpTitle=" + cpTitle
				+ ", cpContent=" + cpContent + ", cpDate=" + cpDate + ", cpPath=" + cpPath + ", delYn=" + delYn
				+ ", cpCount=" + cpCount + "]";
	}
	
}
