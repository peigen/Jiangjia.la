/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;

import com.peigen.web.depreciate.service.enums.ProductPicQualityEnum;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;

/**
 *                       
 * @Filename PicBucketInfo.java
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
 *<li>Date: 2011-11-26</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PicBucketInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -9053912144911932831L;
	
	String						picName;
	ProductPicQualityEnum		quality;
	TrackCategoryEnum			category;
	String						productId;
	String						picSourceUrl;
	
	/**
	 * 构建一个<code>PicBucketInfo.java</code>
	 */
	public PicBucketInfo() {
		super();
	}
	
	/**
	 * 构建一个<code>PicBucketInfo.java</code>
	 * @param picName
	 * @param quality
	 * @param category
	 * @param productId
	 * @param picSourceUrl
	 */
	public PicBucketInfo(String picName, ProductPicQualityEnum quality, TrackCategoryEnum category,
							String productId, String picSourceUrl) {
		super();
		this.picName = picName;
		this.quality = quality;
		this.category = category;
		this.productId = productId;
		this.picSourceUrl = picSourceUrl;
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
	 * @return Returns the quality
	 */
	public ProductPicQualityEnum getQuality() {
		return quality;
	}
	
	/**
	 * @param quality
	 * The quality to set.
	 */
	public void setQuality(ProductPicQualityEnum quality) {
		this.quality = quality;
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
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
			"PicBucketInfo [picName=%s, quality=%s, category=%s, productId=%s, picSourceUrl=%s]",
			picName, quality, category, productId, picSourceUrl);
	}
	
}
