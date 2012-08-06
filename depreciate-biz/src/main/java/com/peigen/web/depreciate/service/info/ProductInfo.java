/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.enums.ProductStatusEnum;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;

/**
 *                       
 * @Filename ProductInfo.java
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
public class ProductInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long		serialVersionUID	= -6197293128954834250L;
	
	private String					id;
	
	/** 网站类别 */
	private TrackCategoryEnum		category;
	
	/** 商品序列号-通常是商家的序列号 */
	private String					productSerialNo;
	
	/** 商品名称-通常是商家的title里面的名字 */
	private String					productName;
	
	/** 图片 */
	private List<ProductPicInfo>	productPicInfos;
	
	/** 状态 */
	private ProductStatusEnum		status;
	
	/** 商品当前价格 */
	private Money					productCurrentPrice	= new Money();
	
	private String					productUrl;
	
	private Date					rawAddTime;
	
	private Date					rawUpdateTime;
	
	/**
	 * 构建一个<code>ProductInfo.java</code>
	 */
	public ProductInfo() {
		super();
	}
	
	/**
	 * @return Returns the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id
	 * The id to set.
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return Returns the productName
	 */
	public String getProductName() {
		return productName;
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
	 * @param productName
	 * The productName to set.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * @return Returns the productSerialNo
	 */
	public String getProductSerialNo() {
		return productSerialNo;
	}
	
	/**
	 * @param productSerialNo
	 * The productSerialNo to set.
	 */
	public void setProductSerialNo(String productSerialNo) {
		this.productSerialNo = productSerialNo;
	}
	
	/**
	 * @return Returns the status
	 */
	public ProductStatusEnum getStatus() {
		return status;
	}
	
	/**
	 * @param status
	 * The status to set.
	 */
	public void setStatus(ProductStatusEnum status) {
		this.status = status;
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
	 * @return Returns the productUrl
	 */
	public String getProductUrl() {
		return productUrl;
	}
	
	/**
	 * @param productUrl
	 * The productUrl to set.
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
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
				"ProductInfo [id=%s, category=%s, productSerialNo=%s, productName=%s, productPicInfos=%s, status=%s, productCurrentPrice=%s, productUrl=%s, rawAddTime=%s, rawUpdateTime=%s]",
				id, category, productSerialNo, productName, productPicInfos, status,
				productCurrentPrice, productUrl, rawAddTime, rawUpdateTime);
	}
	
}
