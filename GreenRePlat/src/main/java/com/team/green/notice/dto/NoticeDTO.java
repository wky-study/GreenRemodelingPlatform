package com.team.green.notice.dto;

public class NoticeDTO {

	private int noticeNo;				/* �� ��ȣ */
	private String memId;				/* �ۼ��� ���̵� */
	private String noticeTitle;			/* ���� ���� ���� */
	private String noticewContent;		/* ���� �� ���� */
	private String noticeDate;			/* �ۼ��� */
	private String reviewPath;			/* ���ϰ�� */
	private String delYn;				/* ���� ���� */
	private int noticeCount;			/* ��ȸ�� */
	
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", memId=" + memId + ", noticeTitle=" + noticeTitle
				+ ", noticewContent=" + noticewContent + ", noticeDate=" + noticeDate + ", reviewPath=" + reviewPath
				+ ", delYn=" + delYn + ", noticeCount=" + noticeCount + "]";
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


	public String getNoticewContent() {
		return noticewContent;
	}


	public void setNoticewContent(String noticewContent) {
		this.noticewContent = noticewContent;
	}


	public String getNoticeDate() {
		return noticeDate;
	}


	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}


	public String getReviewPath() {
		return reviewPath;
	}


	public void setReviewPath(String reviewPath) {
		this.reviewPath = reviewPath;
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





	public NoticeDTO() {
		super();
	}


	public NoticeDTO(int noticeNo, String memId, String noticeTitle, String noticewContent, String noticeDate,
			String reviewPath, String delYn, int noticeCount) {
		this.noticeNo = noticeNo;
		this.memId = memId;
		this.noticeTitle = noticeTitle;
		this.noticewContent = noticewContent;
		this.noticeDate = noticeDate;
		this.reviewPath = reviewPath;
		this.delYn = delYn;
		this.noticeCount = noticeCount;
	}

}
