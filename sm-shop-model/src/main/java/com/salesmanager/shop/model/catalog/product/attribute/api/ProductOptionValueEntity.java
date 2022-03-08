package com.salesmanager.shop.model.catalog.product.attribute.api;

import com.salesmanager.shop.model.catalog.product.attribute.ProductOptionValue;

public class ProductOptionValueEntity extends ProductOptionValue {

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
