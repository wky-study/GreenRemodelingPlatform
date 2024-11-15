package com.team.green.order.dto;

public class PaymentDTO {
	
    private String tid;                // 결제 고유번호
    private String representativeOrderId;       // 대표 주문번호
    private String partnerOrderId;       // 주문번호
    private String memId;              // 회원 아이디
    private String cartId;              // 장바구니 번호
    private String prodName;           // 상품명
    private String prodPrice;          	// 상품 가격
    private int totalPrice;          	// 전체 상품 가격
    private String pgToken;            // 결제 토큰
    private String paymentDate;          // 결제일
	private String prodImageSrc;			/*  이미지경로 */

    
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
