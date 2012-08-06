/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename BatchProductPicResult.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class BatchProductPicResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 9141126450919550826L;
	
	List<ProductPicInfo>		productPicInfos		= new ArrayList<ProductPicInfo>();
	
	/**
	 * 构建一个<code>BatchProductPicResult.java</code>
	 */
	public BatchProductPicResult() {
		super();
	}
	
	/**
	 * 构建一个<code>BatchProductPicResult.java</code>
	 * @param productPicInfos
	 */
	public BatchProductPicResult(List<ProductPicInfo> productPicInfos) {
		super();
		this.productPicInfos = productPicInfos;
	}
	
	/**
	 * @return Returns the productPicInfos
	 */
	public List<ProductPicInfo> getProductPicInfos() {
		return productPicInfos;
	}
	
	/**
	 * @param productPicInfos
	 * The productPicInfos to set.
	 */
	public void setProductPicInfos(List<ProductPicInfo> productPicInfos) {
		this.productPicInfos = productPicInfos;
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
