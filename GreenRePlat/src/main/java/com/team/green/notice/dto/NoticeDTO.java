package com.team.green.notice.dto;

public class NoticeDTO {

	private int noticeNo;				/* 글 번호 */
	private String memId;				/* 작성자 아이디 */
	private String noticeTitle;			/* 공지 사항 제목 */
	private String noticeContent;		/* 공지 글 내용 */
	private String noticeDate;			/* 작성일 */
	private String delYn;				/* 삭제 여부 */
	private int noticeCount;			/* 조회수 */
	
	
	
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
