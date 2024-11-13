package com.team.green.compage.dto;

public class CompageDTO {
	private int reviewNo;				/* ���� �Խñ� ��ȣ */
	private String memId;				/* �ۼ��� ���̵� */
	private String memName;				/* �ۼ��� �̸� */
	private String reviewTitle;			/* ���� �Խñ� ���� */
	private String reviewContent;		/* ���� �Խñ� ���� */
	private String reviewDate;			/* �ۼ��� */
	private String reviewPath;			/* ���ϰ�� */
	private String delYn;				/* ���� ���� */
	private int reviewCount;			/* �Խñ� ��ȸ�� */
	
	public CompageDTO() {
	}

	public CompageDTO(int reviewNo, String memId, String memName, String reviewTitle, String reviewContent,
			String reviewDate, String reviewPath, String delYn, int reviewCount) {
		super();
		this.reviewNo = reviewNo;
		this.memId = memId;
		this.memName = memName;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewPath = reviewPath;
		this.delYn = delYn;
		this.reviewCount = reviewCount;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
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

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "CompageDTO [reviewNo=" + reviewNo + ", memId=" + memId + ", memName=" + memName + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", reviewPath="
				+ reviewPath + ", delYn=" + delYn + ", reviewCount=" + reviewCount + "]";
	}
	
}