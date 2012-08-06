/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;
import java.util.Date;

import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;

/**
 *                       
 * @Filename ProductPicInfo.java
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
public class ProductPicInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -3150360322785821787L;
	
	private long				id;
	
	private String				productId;
	
	private String				picName;
	
	private TrackCategoryEnum	category;
	
	private String				picSourceUrl;
	
	private String				lowPicSourceUrl;
	private String				midPicSourceUrl;
	private String				highPicSourceUrl;
	
	/** 根据不同的使用场景，此处的图片地址会变更不同的图片质量图片 */
	private String				picUrl;
	
	private Date				rawAddTime;
	
	private Date				rawUpdateTime;
	
	/**
	 * 构建一个<code>ProductPicInfo.java</code>
	 */
	public ProductPicInfo() {
		super();
	}
	
	/**
	 * 构建一个<code>ProductPicInfo.java</code>
	 * @param id
	 * @param productId
	 * @param picName
	 * @param category
	 * @param picSourceUrl
	 * @param lowPicSourceUrl
	 * @param midPicSourceUrl
	 * @param highPicSourceUrl
	 * @param picUrl
	 * @param rawAddTime
	 * @param rawUpdateTime
	 */
	public ProductPicInfo(long id, String productId, String picName, TrackCategoryEnum category,
							String picSourceUrl, String lowPicSourceUrl, String midPicSourceUrl,
							String highPicSourceUrl, String picUrl, Date rawAddTime,
							Date rawUpdateTime) {
		super();
		this.id = id;
		this.productId = productId;
		this.picName = picName;
		this.category = category;
		this.picSourceUrl = picSourceUrl;
		this.lowPicSourceUrl = lowPicSourceUrl;
		this.midPicSourceUrl = midPicSourceUrl;
		this.highPicSourceUrl = highPicSourceUrl;
		this.picUrl = picUrl;
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
	 * @return Returns the picName
	 */
	public String getPicName() {
		return picName;
	}
	
	/**
	 * @param picName
	 * The picName to set.
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
	/**
	 * @return Returns the category
	 */
	public TrackCategoryEnum getCategory() {
		return category;
	}
	
	/**
	 * @param category
	 * The category to set.
	 */
	public void setCategory(TrackCategoryEnum category) {
		this.category = category;
	}
	
	/**
	 * @return Returns the picSourceUrl
	 */
	public String getPicSourceUrl() {
		return picSourceUrl;
	}
	
	/**
	 * @param picSourceUrl
	 * The picSourceUrl to set.
	 */
	public void setPicSourceUrl(String picSourceUrl) {
		this.picSourceUrl = picSourceUrl;
	}
	
	/**
	 * @return Returns the lowPicSourceUrl
	 */
	public String getLowPicSourceUrl() {
		return lowPicSourceUrl;
	}
	
	/**
	 * @param lowPicSourceUrl
	 * The lowPicSourceUrl to set.
	 */
	public void setLowPicSourceUrl(String lowPicSourceUrl) {
		this.lowPicSourceUrl = lowPicSourceUrl;
	}
	
	/**
	 * @return Returns the midPicSourceUrl
	 */
	public String getMidPicSourceUrl() {
		return midPicSourceUrl;
	}
	
	/**
	 * @param midPicSourceUrl
	 * The midPicSourceUrl to set.
	 */
	public void setMidPicSourceUrl(String midPicSourceUrl) {
		this.midPicSourceUrl = midPicSourceUrl;
	}
	
	/**
	 * @return Returns the highPicSourceUrl
	 */
	public String getHighPicSourceUrl() {
		return highPicSourceUrl;
	}
	
	/**
	 * @param highPicSourceUrl
	 * The highPicSourceUrl to set.
	 */
	public void setHighPicSourceUrl(String highPicSourceUrl) {
		this.highPicSourceUrl = highPicSourceUrl;
	}
	
	/**
	 * @return Returns the picUrl
	 */
	public String getPicUrl() {
		return picUrl;
	}
	
	/**
	 * @param picUrl
	 * The picUrl to set.
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
				"ProductPicInfo [id=%s, productId=%s, picName=%s, category=%s, picSourceUrl=%s, lowPicSourceUrl=%s, midPicSourceUrl=%s, highPicSourceUrl=%s, picUrl=%s, rawAddTime=%s, rawUpdateTime=%s]",
				id, productId, picName, category, picSourceUrl, lowPicSourceUrl, midPicSourceUrl,
				highPicSourceUrl, picUrl, rawAddTime, rawUpdateTime);
	}
	
}
