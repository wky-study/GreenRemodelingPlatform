package com.team.green.common.callapi;

public class ProductDTOCopy {
	
	private int prod_no;						/*  ��ȣ */
	private String prod_company;				/*  ��ü�� */
	private String prod_model;				/*  �𵨸� */
	private String prod_manufacturer;		/*  ������ */
	private String prod_efficiency;			/*  ������ȿ����� */
	private String prod_imageSrc;			/*  �̹������ */
	private String prod_name;				/*  ��ǰ�� */
	private String prod_price;				/*  ���� */
	private String prod_type;				/*  �з� */
	private String del_yn;					/*  ���� ���� */
	
	
	private int quantity;				/* ��ٱ��Ͽ� ���� ���� (DB�� ����) */
	private String cartId;					/* ��ٱ��� ������ȣ (DB�� ����) */

	public ProductDTOCopy() {

	}

	public ProductDTOCopy(int prod_no, String prod_company, String prod_model, String prod_manufacturer,
			String prod_efficiency, String prod_imageSrc, String prod_name, String prod_price, String prod_type,
			String del_yn, int quantity, String cartId) {
		super();
		this.prod_no = prod_no;
		this.prod_company = prod_company;
		this.prod_model = prod_model;
		this.prod_manufacturer = prod_manufacturer;
		this.prod_efficiency = prod_efficiency;
		this.prod_imageSrc = prod_imageSrc;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_type = prod_type;
		this.del_yn = del_yn;
		this.quantity = quantity;
		this.cartId = cartId;
	}

	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public String getProd_company() {
		return prod_company;
	}

	public void setProd_company(String prod_company) {
		this.prod_company = prod_company;
	}

	public String getProd_model() {
		return prod_model;
	}

	public void setProd_model(String prod_model) {
		this.prod_model = prod_model;
	}

	public String getProd_manufacturer() {
		return prod_manufacturer;
	}

	public void setProd_manufacturer(String prod_manufacturer) {
		this.prod_manufacturer = prod_manufacturer;
	}

	public String getProd_efficiency() {
		return prod_efficiency;
	}

	public void setProd_efficiency(String prod_efficiency) {
		this.prod_efficiency = prod_efficiency;
	}

	public String getProd_imageSrc() {
		return prod_imageSrc;
	}

	public void setProd_imageSrc(String prod_imageSrc) {
		this.prod_imageSrc = prod_imageSrc;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_price() {
		return prod_price;
	}

	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_type() {
		return prod_type;
	}

	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "ProductDTOCopy [prod_no=" + prod_no + ", prod_company=" + prod_company + ", prod_model=" + prod_model
				+ ", prod_manufacturer=" + prod_manufacturer + ", prod_efficiency=" + prod_efficiency
				+ ", prod_imageSrc=" + prod_imageSrc + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_type=" + prod_type + ", del_yn=" + del_yn + ", quantity=" + quantity + ", cartId=" + cartId
				+ "]";
	}

}
