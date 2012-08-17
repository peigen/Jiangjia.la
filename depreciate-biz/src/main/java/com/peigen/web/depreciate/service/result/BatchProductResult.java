/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.ProductInfo;

/**
 *                       
 * @Filename BatchProductResult.java
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
public class BatchProductResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -5633876198064328918L;
	
	List<ProductInfo>			productInfos		= new ArrayList<ProductInfo>();
	
	/**
	 * 构建一个<code>BatchProductResult.java</code>
	 */
	public BatchProductResult() {
		super();
	}
	
	/**
	 * @return Returns the productInfos
	 */
	public List<ProductInfo> getProductInfos() {
		return productInfos;
	}
	
	/**
	 * @param productInfos
	 * The productInfos to set.
	 */
	public void setProductInfos(List<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
