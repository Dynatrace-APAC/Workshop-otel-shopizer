package com.salesmanager.shop.model.order.v1;

import java.util.List;

import com.salesmanager.shop.model.entity.ReadableList;


public class ReadableOrderList extends ReadableList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ReadableOrder> orders;
	
	
	
	public List<ReadableOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ReadableOrder> orders) {
		this.orders = orders;
	}

}
