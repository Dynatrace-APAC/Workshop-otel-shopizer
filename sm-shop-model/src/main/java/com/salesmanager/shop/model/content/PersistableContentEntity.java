package com.salesmanager.shop.model.content;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class PersistableContentEntity extends ContentEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ContentDescriptionEntity> descriptions = new ArrayList<ContentDescriptionEntity>();

	public List<ContentDescriptionEntity> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<ContentDescriptionEntity> descriptions) {
		this.descriptions = descriptions;
	}

}
