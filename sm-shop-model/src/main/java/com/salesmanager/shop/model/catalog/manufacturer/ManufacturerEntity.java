package com.salesmanager.shop.model.catalog.manufacturer;

public class ManufacturerEntity extends Manufacturer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order;

	public void setOrder(int order) {
		this.order = order;
	}
	public int getOrder() {
		return order;
	}


}
