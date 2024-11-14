package com.team.green.notice.dto;

import java.util.List;
import com.team.green.attach.dto.AttachDTO; // AttachDTO�� import

public class NoticeDTO {

    private int noticeNo;             /* �� ��ȣ */
    private String memId;             /* �ۼ��� ���̵� */
    private String noticeTitle;       /* ���� ���� ���� */
    private String noticeContent;     /* ���� �� ���� */
    private String noticeDate;        /* �ۼ��� */
    private String delYn;             /* ���� ���� */
    private int noticeCount;          /* ��ȸ�� */
    
    private List<AttachDTO> attachList; // ÷������ ����Ʈ �߰�

    private String boardType = "NOTICE"; // �⺻�� "NOTICE" ����

    public NoticeDTO() {
    }

    public NoticeDTO(int noticeNo, String memId, String noticeTitle, String noticeContent, String noticeDate,
                     String delYn, int noticeCount, List<AttachDTO> attachList) {
        this.noticeNo = noticeNo;
        this.memId = memId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.delYn = delYn;
        this.noticeCount = noticeCount;
        this.attachList = attachList;
    }

    @Override
    public String toString() {
        return "NoticeDTO [noticeNo=" + noticeNo + ", memId=" + memId + ", noticeTitle=" + noticeTitle
                + ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", delYn=" + delYn
                + ", noticeCount=" + noticeCount + ", attachList=" + attachList + "]";
    }

    // Getter, Setter Methods
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

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
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

    public List<AttachDTO> getAttachList() {
        return attachList;
    }

    public void setAttachList(List<AttachDTO> attachList) {
        this.attachList = attachList;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    // getBoardNo() �߰�
    public int getBoardNo() {
        return this.noticeNo; // noticeNo�� boardNo�� ���
    }
}
