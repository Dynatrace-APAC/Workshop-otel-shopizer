package com.salesmanager.shop.model.catalog.product;


public class RelatedProduct extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String relationShipType; //RELATED_ITEM ~ BUNDLED_ITEM
	public void setRelationShipType(String relationShipType) {
		this.relationShipType = relationShipType;
	}
	public String getRelationShipType() {
		return relationShipType;
	}

}
