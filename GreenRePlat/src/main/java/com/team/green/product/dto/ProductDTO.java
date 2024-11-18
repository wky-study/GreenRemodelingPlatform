package com.team.green.product.dto;

public class ProductDTO {
	
	private int prodNo;						/*  번호 */
	private String prodCompany;				/*  업체명 */
	private String prodModel;				/*  모델명 */
	private String prodManufacturer;		/*  제조원 */
	private String prodEfficiency;			/*  에너지효율등급 */
	private String prodImageSrc;			/*  이미지경로 */
	private String prodName;				/*  제품명 */
	private String prodPrice;				/*  가격 */
	private String prodType;				/*  분류 */
	private String delYn;					/*  삭제 여부 */
	
	private String cartId;					/* 장바구니 고유번호 (DB엔 없음) */
	
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
