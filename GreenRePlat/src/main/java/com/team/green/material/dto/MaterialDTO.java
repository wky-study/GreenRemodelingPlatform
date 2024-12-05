package com.team.green.material.dto;

public class MaterialDTO {
	
	private String itemName;						/*  자재이름 */
	private String itemId;							/*  자재id */
	private String itemModel;						/*  모델명 */
	private String itemBrand;						/*  제조사 */
	private String itemEffiLevel;					/*  에너지 효율 등급 */
	private String itemType;						/*  자재타입 */
	private String itemSize;						/*  자재크기 */
	private String itemImg;							/*  자재이미지 */
	
	private double itemQuantity;					/* 수량 견적서용 */
	
	public MaterialDTO() {
	}

	public MaterialDTO(String itemName, String itemId, String itemModel, String itemBrand, String itemEffiLevel,
			String itemType, String itemSize, String itemImg, double itemQuantity) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemModel = itemModel;
		this.itemBrand = itemBrand;
		this.itemEffiLevel = itemEffiLevel;
		this.itemType = itemType;
		this.itemSize = itemSize;
		this.itemImg = itemImg;
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "MaterialDTO [itemName=" + itemName + ", itemId=" + itemId + ", itemModel=" + itemModel + ", itemBrand="
				+ itemBrand + ", itemEffiLevel=" + itemEffiLevel + ", itemType=" + itemType + ", itemSize=" + itemSize
				+ ", itemImg=" + itemImg + ", itemQuantity=" + itemQuantity + "]";
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemModel() {
		return itemModel;
	}

	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemEffiLevel() {
		return itemEffiLevel;
	}

	public void setItemEffiLevel(String itemEffiLevel) {
		this.itemEffiLevel = itemEffiLevel;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	
}
