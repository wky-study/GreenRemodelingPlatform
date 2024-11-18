package com.team.green.product.dto;

public class ProductDTO {
	
	private int prodNo;						/*  ��ȣ */
	private String prodCompany;				/*  ��ü�� */
	private String prodModel;				/*  �𵨸� */
	private String prodManufacturer;		/*  ������ */
	private String prodEfficiency;			/*  ������ȿ����� */
	private String prodImageSrc;			/*  �̹������ */
	private String prodName;				/*  ��ǰ�� */
	private String prodPrice;				/*  ���� */
	private String prodType;				/*  �з� */
	private String delYn;					/*  ���� ���� */
	
	private String cartId;					/* ��ٱ��� ������ȣ (DB�� ����) */
	
	public ProductDTO() {
	}

	public ProductDTO(int prodNo, String prodCompany, String prodModel, String prodManufacturer, String prodEfficiency,
			String prodImageSrc, String prodName, String prodPrice, String prodType, String delYn, String cartId) {
		this.prodNo = prodNo;
		this.prodCompany = prodCompany;
		this.prodModel = prodModel;
		this.prodManufacturer = prodManufacturer;
		this.prodEfficiency = prodEfficiency;
		this.prodImageSrc = prodImageSrc;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodType = prodType;
		this.delYn = delYn;
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "ProductDTO [prodNo=" + prodNo + ", prodCompany=" + prodCompany + ", prodModel=" + prodModel
				+ ", prodManufacturer=" + prodManufacturer + ", prodEfficiency=" + prodEfficiency + ", prodImageSrc="
				+ prodImageSrc + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodType=" + prodType
				+ ", delYn=" + delYn + ", cartId=" + cartId + "]";
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdCompany() {
		return prodCompany;
	}

	public void setProdCompany(String prodCompany) {
		this.prodCompany = prodCompany;
	}

	public String getProdModel() {
		return prodModel;
	}

	public void setProdModel(String prodModel) {
		this.prodModel = prodModel;
	}

	public String getProdManufacturer() {
		return prodManufacturer;
	}

	public void setProdManufacturer(String prodManufacturer) {
		this.prodManufacturer = prodManufacturer;
	}

	public String getProdEfficiency() {
		return prodEfficiency;
	}

	public void setProdEfficiency(String prodEfficiency) {
		this.prodEfficiency = prodEfficiency;
	}

	public String getProdImageSrc() {
		return prodImageSrc;
	}

	public void setProdImageSrc(String prodImageSrc) {
		this.prodImageSrc = prodImageSrc;
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

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}



	
}
