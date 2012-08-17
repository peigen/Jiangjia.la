/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;
import java.util.Date;

import com.peigen.web.depreciate.service.enums.AttentionStatusEnum;

/**
 *                       
 * @Filename UserAttentionInfo.java
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
 *<li>Date: 2011-11-23</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserAttentionInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -6332245351840199770L;
	
	private long				id;
	
	private String				userId;
	
	private ProductInfo			productInfo;
	
	private String				productAliasName;
	
	private AttentionStatusEnum	status;
	
	private Date				rawAddTime;
	
	private Date				rawUpdateTime;
	
	/**
	 * 构建一个<code>UserAttentionInfo.java</code>
	 */
	public UserAttentionInfo() {
		super();
	}
	
	/**
	 * 构建一个<code>UserAttentionInfo.java</code>
	 * @param id
	 * @param userId
	 * @param productInfo
	 * @param productAliasName
	 * @param status
	 * @param rawAddTime
	 * @param rawUpdateTime
	 */
	public UserAttentionInfo(long id, String userId, ProductInfo productInfo,
								String productAliasName, AttentionStatusEnum status,
								Date rawAddTime, Date rawUpdateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.productInfo = productInfo;
		this.productAliasName = productAliasName;
		this.status = status;
		this.rawAddTime = rawAddTime;
		this.rawUpdateTime = rawUpdateTime;
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
	
	/**
	 * @return Returns the status
	 */
	public AttentionStatusEnum getStatus() {
		return status;
	}
	
	/**
	 * @return Returns the productAliasName
	 */
	public String getProductAliasName() {
		return productAliasName;
	}
	
	/**
	 * @param productAliasName
	 * The productAliasName to set.
	 */
	public void setProductAliasName(String productAliasName) {
		this.productAliasName = productAliasName;
	}
	
	/**
	 * @param status
	 * The status to set.
	 */
	public void setStatus(AttentionStatusEnum status) {
		this.status = status;
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
	 * @return Returns the rawUpdateTime
	 */
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	/**
	 * @param rawUpdateTime
	 * The rawUpdateTime to set.
	 */
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
			.format(
				"UserAttentionInfo [id=%s, userId=%s, productInfo=%s, productAliasName=%s, status=%s, rawAddTime=%s, rawUpdateTime=%s]",
				id, userId, productInfo, productAliasName, status, rawAddTime, rawUpdateTime);
	}
	
}
