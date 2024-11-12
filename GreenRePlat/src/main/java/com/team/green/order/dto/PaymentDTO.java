package com.team.green.order.dto;

public class PaymentDTO {
	
    private String tid;                // 결제 고유번호
    private String partnerOrderId;       // 주문번호
    private String memId;              // 회원 아이디
    private String prodName;           // 상품명
    private int prodPrice;          	// 상품 가격
    private int totalPrice;          	// 전체 상품 가격
    private String pgToken;            // 결제 토큰
    private String paymentDate;          // 결제일
    
	public PaymentDTO() {
	}

	public PaymentDTO(String tid, String partnerOrderId, String memId, String prodName, int prodPrice, int totalPrice,
			String pgToken, String paymentDate) {
		this.tid = tid;
		this.partnerOrderId = partnerOrderId;
		this.memId = memId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.totalPrice = totalPrice;
		this.pgToken = pgToken;
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "PaymentDTO [tid=" + tid + ", partnerOrderId=" + partnerOrderId + ", memId=" + memId + ", prodName="
				+ prodName + ", prodPrice=" + prodPrice + ", totalPrice=" + totalPrice + ", pgToken=" + pgToken
				+ ", paymentDate=" + paymentDate + "]";
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
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

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
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



    
    
}
