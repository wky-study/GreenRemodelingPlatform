package com.team.green.chat.dto;

public class ChatLogDTO {
	
	private int chatNo;			/* ä�÷α� �ĺ���ȣ PK */
	private String memId;		/* �ۼ��� ���̵� */
	private String memNick;		/* �ۼ��� �г��� */
	private int roomNo;			/* ä�ù��� ��ȣ */
	private String chatMsg;		/* ä�� �޽��� ���� */
	private String sendDate;	/* �޽��� ��¥ */
	
	public ChatLogDTO() {}

	public ChatLogDTO(int chatNo, String memId, String memNick, int roomNo, String chatMsg, String sendDate) {
		super();
		this.chatNo = chatNo;
		this.memId = memId;
		this.memNick = memNick;
		this.roomNo = roomNo;
		this.chatMsg = chatMsg;
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "ChatLogDTO [chatNo=" + chatNo + ", memId=" + memId + ", memNick=" + memNick + ", roomNo=" + roomNo
				+ ", chatMsg=" + chatMsg + ", sendDate=" + sendDate + "]";
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getChatMsg() {
		return chatMsg;
	}

	public void setChatMsg(String chatMsg) {
		this.chatMsg = chatMsg;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
}
