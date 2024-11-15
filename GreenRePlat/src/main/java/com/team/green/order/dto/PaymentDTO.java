package com.team.green.order.dto;

public class PaymentDTO {
	
    private String tid;                // ���� ������ȣ
    private String representativeOrderId;       // ��ǥ �ֹ���ȣ
    private String partnerOrderId;       // �ֹ���ȣ
    private String memId;              // ȸ�� ���̵�
    private String cartId;              // ��ٱ��� ��ȣ
    private String prodName;           // ��ǰ��
    private String prodPrice;          	// ��ǰ ����
    private int totalPrice;          	// ��ü ��ǰ ����
    private String pgToken;            // ���� ��ū
    private String paymentDate;          // ������
	private String prodImageSrc;			/*  �̹������ */

    
	public PaymentDTO() {
	}


	public PaymentDTO(String tid, String representativeOrderId, String partnerOrderId, String memId, String cartId,
			String prodName, String prodPrice, int totalPrice, String pgToken, String paymentDate,
			String prodImageSrc) {
		this.tid = tid;
		this.representativeOrderId = representativeOrderId;
		this.partnerOrderId = partnerOrderId;
		this.memId = memId;
		this.cartId = cartId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.totalPrice = totalPrice;
		this.pgToken = pgToken;
		this.paymentDate = paymentDate;
		this.prodImageSrc = prodImageSrc;
	}


	@Override
	public String toString() {
		return "PaymentDTO [tid=" + tid + ", representativeOrderId=" + representativeOrderId + ", partnerOrderId="
				+ partnerOrderId + ", memId=" + memId + ", cartId=" + cartId + ", prodName=" + prodName + ", prodPrice="
				+ prodPrice + ", totalPrice=" + totalPrice + ", pgToken=" + pgToken + ", paymentDate=" + paymentDate
				+ ", prodImageSrc=" + prodImageSrc + "]";
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getRepresentativeOrderId() {
		return representativeOrderId;
	}


	public void setRepresentativeOrderId(String representativeOrderId) {
		this.representativeOrderId = representativeOrderId;
	}


	public String getPartnerOrderId() {
		return partnerOrderId;
	}


	public void setPartnerOrderId(String partnerOrderId) {
		this.partnerOrderId = partnerOrderId;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getCartId() {
		return cartId;
	}


	public void setCartId(String cartId) {
		this.cartId = cartId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public String getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getPgToken() {
		return pgToken;
	}


	public void setPgToken(String pgToken) {
		this.pgToken = pgToken;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getProdImageSrc() {
		return prodImageSrc;
	}


	public void setProdImageSrc(String prodImageSrc) {
		this.prodImageSrc = prodImageSrc;
	}





    
    
}
