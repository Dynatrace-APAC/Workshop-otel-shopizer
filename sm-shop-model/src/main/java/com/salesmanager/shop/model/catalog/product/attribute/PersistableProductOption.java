package com.salesmanager.shop.model.catalog.product.attribute;

import java.util.List;

public class PersistableProductOption extends ProductOptionEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductOptionDescription> descriptions;
	public void setDescriptions(List<ProductOptionDescription> descriptions) {
		this.descriptions = descriptions;
	}
	public List<ProductOptionDescription> getDescriptions() {
		return descriptions;
	}

}
