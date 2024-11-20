package com.team.green.chat.dto;

public class RoomDTO {
    private int roomNo;			/* 방 번호 */
    private String roomName;	/* 방 제목 */
    private String memId;		/* 방장 아이디 */
    private String memNick;		/* 방장 닉네임 */
    private String regDate;		/* 등록일 */
    private String delYn;		/* 방 삭제여부 */
    private String partMem;		/* 참여자의 id(닉네임아님) */
    
    
	public RoomDTO() { }
	
	public RoomDTO(int roomNo, String roomName, String memId, String memNick, String regDate, String delYn,
			String partMem) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.memId = memId;
		this.memNick = memNick;
		this.regDate = regDate;
		this.delYn = delYn;
		this.partMem = partMem;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getPartMem() {
		return partMem;
	}
	public void setPartMem(String partMem) {
		this.partMem = partMem;
	}
	@Override
	public String toString() {
		return "RoomDTO [roomNo=" + roomNo + ", roomName=" + roomName + ", memId=" + memId + ", memNick=" + memNick
				+ ", regDate=" + regDate + ", delYn=" + delYn + ", partMem=" + partMem + "]";
	}
    
	

}
