package com.salesmanager.shop.model.catalog.catalog;

import com.salesmanager.shop.model.entity.Entity;

public class CatalogEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean visible;
	private boolean defaultCatalog;
	private String code;
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isDefaultCatalog() {
		return defaultCatalog;
	}
	public void setDefaultCatalog(boolean defaultCatalog) {
		this.defaultCatalog = defaultCatalog;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
