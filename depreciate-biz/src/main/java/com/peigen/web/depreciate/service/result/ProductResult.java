/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.ProductInfo;

/**
 *                       
 * @Filename DepreciateProductResult.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 6496893688968033352L;
	
	private ProductInfo			productInfo;
	
	/**
	 * 构建一个<code>DepreciateProductResult.java</code>
	 */
	public ProductResult() {
		super();
	}
	
	/**
	 * @return Returns the productInfo
	 */
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	
	/**
	 * @param productInfo
	 * The productInfo to set.
	 */
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
