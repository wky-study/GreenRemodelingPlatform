package com.team.green.order.dto;


public class OrderCreateFormDTO {
	
    private String name;
    private int totalPrice;
    private String mamId;
    private String partnerOrderId;

    public OrderCreateFormDTO() {}

	public OrderCreateFormDTO(String name, int totalPrice, String mamId, String partnerOrderId) {
		this.name = name;
		this.totalPrice = totalPrice;
		this.mamId = mamId;
		this.partnerOrderId = partnerOrderId;
	}

	@Override
	public String toString() {
		return "OrderCreateFormDTO [name=" + name + ", totalPrice=" + totalPrice + ", mamId=" + mamId
				+ ", partnerOrderId=" + partnerOrderId + "]";
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

	public String getPartnerOrderId() {
		return partnerOrderId;
	}

	public void setPartnerOrderId(String partnerOrderId) {
		this.partnerOrderId = partnerOrderId;
	}


    
    	
}
