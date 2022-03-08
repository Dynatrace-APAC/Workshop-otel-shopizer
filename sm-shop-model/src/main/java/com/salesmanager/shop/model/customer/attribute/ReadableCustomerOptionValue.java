package com.salesmanager.shop.model.customer.attribute;

public class ReadableCustomerOptionValue extends CustomerOptionValueEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerOptionValueDescription description;
	public void setDescription(CustomerOptionValueDescription description) {
		this.description = description;
	}
	public CustomerOptionValueDescription getDescription() {
		return description;
	}



}
