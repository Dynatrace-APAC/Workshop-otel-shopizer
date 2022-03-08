package com.salesmanager.shop.utils;

import org.springframework.stereotype.Component;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.shop.constants.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * To be used when using an external web server for managing images
 * 	<beans:bean id="img" class="com.salesmanager.shop.utils.LocalImageFilePathUtils">
		<beans:property name="basePath" value="/static" />
	</beans:bean>
 * @author c.samson
 *
 */
@Component
public class ImageFilePathUtils extends AbstractimageFilePath{

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageFilePathUtils.class);

	
	private String basePath = Constants.STATIC_URI;

	@Override
	public String getBasePath(MerchantStore store) {
		LOGGER.info("getBasePath(...): " + basePath);
		return basePath;
	}

	@Override
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	@Override
	public String getContextPath() {
		return super.getProperties().getProperty(CONTEXT_PATH);
	}



	
}
