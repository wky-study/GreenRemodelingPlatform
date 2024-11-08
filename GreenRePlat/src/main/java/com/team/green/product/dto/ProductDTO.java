package com.team.green.product.dto;

public class ProductDTO {
	
	private int prodNo;						/*  번호 */
	private String prodCompany;				/*  업체명 */
	private String prodModal;				/*  모델명 */
	private String prodManufacturer;		/*  제조원 */
	private String prodEfficiency;			/*  에너지효율등급 */
	private String prodImageSrc;			/*  이미지경로 */
	private String prodName;				/*  제품명 */
	private String prodPrice;				/*  가격 */
	private String prodCategory;			/*  분류 */
	
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
