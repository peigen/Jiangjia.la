/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.order;

import java.util.List;

import org.springframework.util.Assert;

import com.peigen.common.lang.util.money.Money;

/**
 *                       
 * @Filename ProductParaOrder.java
 *
 * @Description 由前端系统传入所需参数
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductParaOrder implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 2274513996795588928L;
	
	private String				userId;
	
	private String				productName;
	
	/** 收集商品信息的url */
	private String				url;
	
	private Money				price;
	
	private String				serialNo;
	
	private List<String>		images;
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.order.Order#check()
	 */
	@Override
	public void check() {
		Assert.hasText(url);
		Assert.hasText(userId);
		Assert.notNull(price);
		
		Assert.notNull(images);
		Assert.notEmpty(images);
	}
	
	/**
	 * 构建一个<code>ProductParaOrder.java</code>
	 */
	public ProductParaOrder() {
		super();
	}
	
	/**
	 * @return Returns the productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * @param productName
	 * The productName to set.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return Returns the price
	 */
	public Money getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 * The price to set.
	 */
	public void setPrice(Money price) {
		this.price = price;
	}
	
	/**
	 * @return Returns the serialNo
	 */
	public String getSerialNo() {
		return serialNo;
	}
	
	/**
	 * @param serialNo
	 * The serialNo to set.
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	/**
	 * @return Returns the images
	 */
	public List<String> getImages() {
		return images;
	}
	
	/**
	 * @param images
	 * The images to set.
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
			.format(
				"ProductParaOrder [userId=%s, productName=%s, url=%s, price=%s, serialNo=%s, images=%s]",
				userId, productName, url, price, serialNo, images);
	}
	
}