package com.team.green.notice.dto;

public class NoticeDTO {

	private int noticeNo;				/* �� ��ȣ */
	private String memId;				/* �ۼ��� ���̵� */
	private String noticeTitle;			/* ���� ���� ���� */
	private String noticeContent;		/* ���� �� ���� */
	private String noticeDate;			/* �ۼ��� */
	private String delYn;				/* ���� ���� */
	private int noticeCount;			/* ��ȸ�� */
	
	
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", memId=" + memId + ", noticeTitle=" + noticeTitle
				+ ", noticewContent=" + noticeContent + ", noticeDate=" + noticeDate + ", delYn=" + delYn
				+ ", noticeCount=" + noticeCount + "]";
	}
	public NoticeDTO() {
	}
	public NoticeDTO(int noticeNo, String memId, String noticeTitle, String noticewContent, String noticeDate,
			String delYn, int noticeCount) {
		this.noticeNo = noticeNo;
		this.memId = memId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticewContent;
		this.noticeDate = noticeDate;
		this.delYn = delYn;
		this.noticeCount = noticeCount;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticewContent) {
		this.noticeContent = noticewContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}
	
	
	

}
