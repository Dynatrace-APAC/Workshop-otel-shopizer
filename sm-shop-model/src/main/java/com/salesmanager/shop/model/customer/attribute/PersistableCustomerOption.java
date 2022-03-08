package com.salesmanager.shop.model.customer.attribute;

import java.util.List;

public class PersistableCustomerOption extends CustomerOptionEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CustomerOptionDescription> descriptions;

	public void setDescriptions(List<CustomerOptionDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public List<CustomerOptionDescription> getDescriptions() {
		return descriptions;
	}

}
