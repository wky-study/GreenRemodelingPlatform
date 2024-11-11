package com.team.green.order.dto;

public class OrderCreateFormDTO {
	
    private String name;
    private int totalPrice;

    public OrderCreateFormDTO() {}

	public OrderCreateFormDTO(String name, int totalPrice) {
		this.name = name;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderCreateFormDTO [name=" + name + ", totalPrice=" + totalPrice + "]";
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

    
    	
}
