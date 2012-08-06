/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename ProductPicQualityEnum.java
 *
 * @Description 商品图片品质
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
public enum ProductPicQualityEnum {
	
	/** 低品质 */
	LOW("LOW", "低品质"),
	
	/** 中品质 */
	MID("MID", "中品质"),
	
	/** 高品质 */
	HIGH("HIGH", "高品质");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>ProductPicQualityEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private ProductPicQualityEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return ProductPicQualityEnum
	 */
	public static ProductPicQualityEnum getByCode(String code) {
		for (ProductPicQualityEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<ProductPicQualityEnum>
	 */
	public List<ProductPicQualityEnum> getAllEnum() {
		List<ProductPicQualityEnum> list = new ArrayList<ProductPicQualityEnum>();
		for (ProductPicQualityEnum cache : values()) {
			list.add(cache);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (ProductPicQualityEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
