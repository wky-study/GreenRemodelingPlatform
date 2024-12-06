package com.team.green.common.callapi;

public class OrderRequest {
	private String prod_no;
	private int prod_count;
	public OrderRequest() {
	}
	public OrderRequest(String prod_no, int prod_count) {
		this.prod_no = prod_no;
		this.prod_count = prod_count;
	}
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public int getProd_count() {
		return prod_count;
	}
	public void setProd_count(int prod_count) {
		this.prod_count = prod_count;
	}

}
