package com.team.green.review.dto;

public class ReviewDTO {

	private int reviewNo;				/* 리뷰 게시글 번호 */
	private String memId;				/* 작성자 아이디 */
	private String memName;				/* 작성자 이름 */
	private String reviewTitle;			/* 리뷰 게시글 제목 */
	private String reviewContent;		/* 리뷰 게시글 내용 */
	private String reviewDate;			/* 작성일 */
	private String reviewPath;			/* 파일경로 */
	private String delYn;				/* 삭제 여부 */
	private int reviewCount;			/* 게시글 조회수 */
	
	public ReviewDTO() {
	}

	public ReviewDTO(int reviewNo, String memId, String memName, String reviewTitle, String reviewContent,
			String reviewDate, String reviewPath, String delYn, int reviewCount) {
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

	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", memId=" + memId + ", memName=" + memName + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", reviewPath="
				+ reviewPath + ", delYn=" + delYn + ", reviewCount=" + reviewCount + "]";
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

}
