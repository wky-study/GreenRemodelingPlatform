package com.team.green.material.dto;

public class MaterialDTO {
	
	private String itemName;						/*  �����̸� */
	private String itemId;							/*  ����id */
	private String itemModel;						/*  �𵨸� */
	private String itemBrand;						/*  ������ */
	private String itemEffiLevel;					/*  ������ ȿ�� ��� */
	private String itemType;						/*  ����Ÿ�� */
	private String itemSize;						/*  ����ũ�� */
	private String itemImg;							/*  �����̹��� */
	
	private double itemQuantity;					/* ���� �������� */
	
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
