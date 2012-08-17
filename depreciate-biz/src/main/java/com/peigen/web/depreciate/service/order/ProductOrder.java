/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.order;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.Assert;

/**
 *                       
 * @Filename ProductOrder.java
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
public class ProductOrder implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -1894802816755817077L;
	
	private String				userId;
	
	/** 收集商品信息的url */
	private String				url;
	
	public void check() {
		Assert.hasText(url);
		Assert.hasText(userId);
	}
	
	/**
	 * 构建一个<code>ProductOrder.java</code>
	 */
	public ProductOrder() {
		super();
	}
	
	/**
	 * 构建一个<code>ProductOrder.java</code>
	 * @param url
	 * @param userId
	 */
	public ProductOrder(String url, String userId) {
		super();
		this.url = url;
		this.userId = userId;
	}
	
	/**
	 * @return Returns the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url
	 * The url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return Returns the userId
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * @param userId
	 * The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
