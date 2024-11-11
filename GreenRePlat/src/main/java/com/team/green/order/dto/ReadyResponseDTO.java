package com.team.green.order.dto;

public class ReadyResponseDTO {

    private String tid;                  // ���� ������ȣ
    private String next_redirect_pc_url; // īī�������� ���� ��û �޽���(TMS)�� ������ ���� ����� ���� �Է�ȭ�� Redirect URL (īī�� �� ����)
	
    public ReadyResponseDTO() {
	}

	public ReadyResponseDTO(String tid, String next_redirect_pc_url) {
		this.tid = tid;
		this.next_redirect_pc_url = next_redirect_pc_url;
	}

	@Override
	public String toString() {
		return "ReadyResponseDTO [tid=" + tid + ", next_redirect_pc_url=" + next_redirect_pc_url + "]";
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}

	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
    
    
}
