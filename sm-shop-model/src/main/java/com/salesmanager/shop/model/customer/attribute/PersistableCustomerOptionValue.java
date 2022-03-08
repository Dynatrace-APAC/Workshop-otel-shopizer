package com.salesmanager.shop.model.customer.attribute;

import java.util.List;

public class PersistableCustomerOptionValue extends CustomerOptionValueEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CustomerOptionValueDescription> descriptions;

	public void setDescriptions(List<CustomerOptionValueDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public List<CustomerOptionValueDescription> getDescriptions() {
		return descriptions;
	}

}
