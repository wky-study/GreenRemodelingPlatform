package com.team.green.cart.dto;

public class CartDTO {

	private String cartId;			/* 장바구니 고유번호 */
	private String memId;			/* 장바구니를 소유한 사용자 ID */
	private int prodNo;				/* 장바구니에 추가된 상품 번호 */
	private int quantity;			/* 상품 수량 */
	private String cartDate;		/* 장바구니에 추가한 시간 */
	
	public CartDTO() {
	}

	public CartDTO(String cartId, String memId, int prodNo, int quantity, String cartDate) {
		this.cartId = cartId;
		this.memId = memId;
		this.prodNo = prodNo;
		this.quantity = quantity;
		this.cartDate = cartDate;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", memId=" + memId + ", prodNo=" + prodNo + ", quantity=" + quantity
				+ ", cartDate=" + cartDate + "]";
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartDate() {
		return cartDate;
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}

	
	
	
}
