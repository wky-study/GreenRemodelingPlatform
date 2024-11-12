package com.team.green.reply.dto;

public class ReplyDTO {

	private String replyNo;					/* 댓글 번호 */
	private int articleNo;					/* 게시글 번호 */
	private int reviewNo;					/* 리뷰 게시글 번호 */
	private String memId;					/* 작성자 이름 */
	private String replyContent;			/* 댓글 내용 */
	private String replyDate;				/* 댓글 작성일 */
	private String delYn;					/* 삭제 여부 */
	private String tableName;				/* 연관 테이블 이름 */
	
	
	public ReplyDTO() {
	}


	public ReplyDTO(String replyNo, int articleNo, int reviewNo, String memId, String replyContent, String replyDate,
			String delYn, String tableName) {
		this.replyNo = replyNo;
		this.articleNo = articleNo;
		this.reviewNo = reviewNo;
		this.memId = memId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.delYn = delYn;
		this.tableName = tableName;
	}


	@Override
	public String toString() {
		return "ReplyDTO [replyNo=" + replyNo + ", articleNo=" + articleNo + ", reviewNo=" + reviewNo + ", memId="
				+ memId + ", replyContent=" + replyContent + ", replyDate=" + replyDate + ", delYn=" + delYn
				+ ", tableName=" + tableName + "]";
	}


	public String getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}


	public int getArticleNo() {
		return articleNo;
	}


	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
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


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public String getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}


	public String getDelYn() {
		return delYn;
	}


	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	
}
