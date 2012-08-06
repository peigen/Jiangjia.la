/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;
import java.util.Date;

import com.peigen.common.lang.util.money.Money;

/**
 *                       
 * @Filename ProductChangeLogInfo.java
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
 *<li>Date: 2011-11-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductChangeLogInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 5339730456747311276L;
	
	private long				id;
	
	private String				productId;
	
	private Money				productCurrentPrice;
	
	private Money				productChangePrice;
	
	private Date				rawAddTime;
	
	/**
	 * 构建一个<code>ProductChangeLogInfo.java</code>
	 */
	public ProductChangeLogInfo() {
		super();
	}
	
	/**
	 * 构建一个<code>ProductChangeLogInfo.java</code>
	 * @param id
	 * @param productId
	 * @param productCurrentPrice
	 * @param productChangePrice
	 * @param rawAddTime
	 */
	public ProductChangeLogInfo(long id, String productId, Money productCurrentPrice,
								Money productChangePrice, Date rawAddTime) {
		super();
		this.id = id;
		this.productId = productId;
		this.productCurrentPrice = productCurrentPrice;
		this.productChangePrice = productChangePrice;
		this.rawAddTime = rawAddTime;
	}
	
	/**
	 * @return Returns the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id
	 * The id to set.
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return Returns the productId
	 */
	public String getProductId() {
		return productId;
	}
	
	/**
	 * @param productId
	 * The productId to set.
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	/**
	 * @return Returns the productCurrentPrice
	 */
	public Money getProductCurrentPrice() {
		return productCurrentPrice;
	}
	
	/**
	 * @param productCurrentPrice
	 * The productCurrentPrice to set.
	 */
	public void setProductCurrentPrice(Money productCurrentPrice) {
		this.productCurrentPrice = productCurrentPrice;
	}
	
	/**
	 * @return Returns the productChangePrice
	 */
	public Money getProductChangePrice() {
		return productChangePrice;
	}
	
	/**
	 * @param productChangePrice
	 * The productChangePrice to set.
	 */
	public void setProductChangePrice(Money productChangePrice) {
		this.productChangePrice = productChangePrice;
	}
	
	/**
	 * @return Returns the rawAddTime
	 */
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	/**
	 * @param rawAddTime
	 * The rawAddTime to set.
	 */
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
			.format(
				"ProductChangeLogInfo [id=%s, productId=%s, productCurrentPrice=%s, productChangePrice=%s, rawAddTime=%s]",
				id, productId, productCurrentPrice, productChangePrice, rawAddTime);
	}
	
}
