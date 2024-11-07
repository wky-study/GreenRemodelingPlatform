package com.team.green.product.dto;

public class ProductDTO {
	
	private int prodNo;						/*  ��ȣ */
	private String prodCompany;				/*  ��ü�� */
	private String prodModal;				/*  �𵨸� */
	private String prodManufacturer;		/*  ������ */
	private String prodEfficiency;			/*  ������ȿ����� */
	private String prodImageSrc;			/*  �̹������ */
	private String prodName;				/*  ��ǰ�� */
	private String prodPrice;				/*  ���� */
	private String prodCategory;			/*  �з� */
	
	public ProductDTO() {
	}

	public ProductDTO(int prodNo, String prodCompany, String prodModal, String prodManufacturer,
			String prodEfficiency, String prodImageSrc, String prodName, String prodPrice, String prodCategory) {
		this.prodNo = prodNo;
		this.prodCompany = prodCompany;
		this.prodModal = prodModal;
		this.prodManufacturer = prodManufacturer;
		this.prodEfficiency = prodEfficiency;
		this.prodImageSrc = prodImageSrc;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodCategory = prodCategory;
	}

	@Override
	public String toString() {
		return "ProductDTO [prodNo=" + prodNo + ", prodCompany=" + prodCompany + ", prodModal=" + prodModal
				+ ", prodManufacturer=" + prodManufacturer + ", prodEfficiency=" + prodEfficiency + ", prodImageSrc="
				+ prodImageSrc + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodCategory="
				+ prodCategory + "]";
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

	public String getProdModal() {
		return prodModal;
	}

	public void setProdModal(String prodModal) {
		this.prodModal = prodModal;
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

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	
	
	
}