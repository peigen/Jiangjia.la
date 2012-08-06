/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename TrackCategoryEnum.java
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
public enum TrackCategoryEnum {
	
	/** 麦包包 */
	MBAOBAO("MBAOBAO", "麦包包"),
	
	/** 麦考林 */
	M18("M18", "麦考林"),
	
	/** 好乐买 */
	OKBUY("OKBUY", "好乐买"),
	
	/** 唯品会 */
	VIPSHOP("VIPSHOP", "唯品会"),
	
	/** 当当网 */
	DANGDANG("DANGDANG", "当当网");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>TrackCategoryEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private TrackCategoryEnum(String code, String message) {
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
	 * @return TrackCategoryEnum
	 */
	public static TrackCategoryEnum getByCode(String code) {
		for (TrackCategoryEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TrackCategoryEnum>
	 */
	public List<TrackCategoryEnum> getAllEnum() {
		List<TrackCategoryEnum> list = new ArrayList<TrackCategoryEnum>();
		for (TrackCategoryEnum cache : values()) {
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
		for (TrackCategoryEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
