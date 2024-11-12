package com.team.green.material.dto;

public class MaterialDTO {
	
	private String itemName;						/*  자재이름 */
	private String itemId;							/*  자재id */
	private String itemModel;						/*  모델명 */
	private String itemBrand;						/*  제조사 */
	private String itemImg;							/*  자재이미지 */
	private String itemEffiLevel;					/*  에너지 효율 등급 */
	private String itemEffiStat;					/*  에너지 효율 수치 */
	private String itemType;						/*  자재타입 */
	private String itemSize;						/*  자재크기 */
	
	public MaterialDTO() {
	}

	public MaterialDTO(String itemName, String itemId, String itemModel, String itemBrand, String itemImg,
			String itemEffiLevel, String itemEffiStat, String itemType, String itemSize) {
		super();
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemModel = itemModel;
		this.itemBrand = itemBrand;
		this.itemImg = itemImg;
		this.itemEffiLevel = itemEffiLevel;
		this.itemEffiStat = itemEffiStat;
		this.itemType = itemType;
		this.itemSize = itemSize;
	}

	@Override
	public String toString() {
		return "MaterialDTO [itemName=" + itemName + ", itemId=" + itemId + ", itemModel=" + itemModel + ", itemBrand="
				+ itemBrand + ", itemImg=" + itemImg + ", itemEffiLevel=" + itemEffiLevel + ", itemEffiStat="
				+ itemEffiStat + ", itemType=" + itemType + ", itemSize=" + itemSize + "]";
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

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemEffiLevel() {
		return itemEffiLevel;
	}

	public void setItemEffiLevel(String itemEffiLevel) {
		this.itemEffiLevel = itemEffiLevel;
	}

	public String getItemEffiStat() {
		return itemEffiStat;
	}

	public void setItemEffiStat(String itemEffiStat) {
		this.itemEffiStat = itemEffiStat;
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

}
