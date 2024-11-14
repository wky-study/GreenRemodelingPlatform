package com.team.green.order.dto;


public class OrderCreateFormDTO {
	
    private String name;
    private int totalPrice;
    private String mamId;
    private int quantity;
    private String partnerOrderId;
    private String cartId;              // 장바구니 번호
    private String prodImageSrc; 	// 이미지 src

    public OrderCreateFormDTO() {}

	public OrderCreateFormDTO(String name, int totalPrice, String mamId, int quantity, String partnerOrderId,
			String cartId, String prodImageSrc) {
		this.name = name;
		this.totalPrice = totalPrice;
		this.mamId = mamId;
		this.quantity = quantity;
		this.partnerOrderId = partnerOrderId;
		this.cartId = cartId;
		this.prodImageSrc = prodImageSrc;
	}

	@Override
	public String toString() {
		return "OrderCreateFormDTO [name=" + name + ", totalPrice=" + totalPrice + ", mamId=" + mamId + ", quantity="
				+ quantity + ", partnerOrderId=" + partnerOrderId + ", cartId=" + cartId + ", prodImageSrc="
				+ prodImageSrc + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMamId() {
		return mamId;
	}

	public void setMamId(String mamId) {
		this.mamId = mamId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPartnerOrderId() {
		return partnerOrderId;
	}

	public void setPartnerOrderId(String partnerOrderId) {
		this.partnerOrderId = partnerOrderId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getProdImageSrc() {
		return prodImageSrc;
	}

	public void setProdImageSrc(String prodImageSrc) {
		this.prodImageSrc = prodImageSrc;
	}






    
    	
}
