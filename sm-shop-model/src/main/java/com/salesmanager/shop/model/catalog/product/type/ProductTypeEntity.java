package com.salesmanager.shop.model.catalog.product.type;

import com.salesmanager.shop.model.entity.Entity;

public class ProductTypeEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private boolean visible;
	boolean allowAddToCart;

	public boolean isAllowAddToCart() {
		return allowAddToCart;
	}

	public void setAllowAddToCart(boolean allowAddToCart) {
		this.allowAddToCart = allowAddToCart;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


}
