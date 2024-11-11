package com.team.green.order.dto;

public class ApproveResponseDTO {

	private String aid; // ��û ���� ��ȣ
	private String tid; // ���� ���� ��ȣ
	private String cid; // ������ �ڵ�
	private String partner_order_id; // ������ �ֹ���ȣ
	private String partner_user_id; // ������ ȸ�� id
	private String payment_method_type; // ���� ����, CARD �Ǵ� MONEY �� �ϳ�
	private String item_name; // ��ǰ �̸�
	private String item_code; // ��ǰ �ڵ�
	private int quantity; // ��ǰ ����
	private String created_at; // ���� �غ� ��û �ð�
	private String approved_at; // ���� ���� �ð�
	private String payload; // ���� ���� ��û�� ���� ������ ��, ��û �� ���޵� ����
	
	public ApproveResponseDTO() {
	}

	public ApproveResponseDTO(String aid, String tid, String cid, String partner_order_id, String partner_user_id,
			String payment_method_type, String item_name, String item_code, int quantity, String created_at,
			String approved_at, String payload) {
		this.aid = aid;
		this.tid = tid;
		this.cid = cid;
		this.partner_order_id = partner_order_id;
		this.partner_user_id = partner_user_id;
		this.payment_method_type = payment_method_type;
		this.item_name = item_name;
		this.item_code = item_code;
		this.quantity = quantity;
		this.created_at = created_at;
		this.approved_at = approved_at;
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "AproveResponseDTO [aid=" + aid + ", tid=" + tid + ", cid=" + cid + ", partner_order_id="
				+ partner_order_id + ", partner_user_id=" + partner_user_id + ", payment_method_type="
				+ payment_method_type + ", item_name=" + item_name + ", item_code=" + item_code + ", quantity="
				+ quantity + ", created_at=" + created_at + ", approved_at=" + approved_at + ", payload=" + payload
				+ "]";
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPartner_order_id() {
		return partner_order_id;
	}

	public void setPartner_order_id(String partner_order_id) {
		this.partner_order_id = partner_order_id;
	}

	public String getPartner_user_id() {
		return partner_user_id;
	}

	public void setPartner_user_id(String partner_user_id) {
		this.partner_user_id = partner_user_id;
	}

	public String getPayment_method_type() {
		return payment_method_type;
	}

	public void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getApproved_at() {
		return approved_at;
	}

	public void setApproved_at(String approved_at) {
		this.approved_at = approved_at;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	
	
}
