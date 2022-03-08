package com.salesmanager.shop.model.catalog.manufacturer;

public class ReadableManufacturer extends ManufacturerEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManufacturerDescription description;
	public void setDescription(ManufacturerDescription description) {
		this.description = description;
	}
	public ManufacturerDescription getDescription() {
		return description;
	}

}
