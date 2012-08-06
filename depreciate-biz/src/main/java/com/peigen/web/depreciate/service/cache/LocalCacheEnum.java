/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.cache;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename LocalCacheEnum.java
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
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum LocalCacheEnum {
	
	/** 用户缓存 */
	USER_CACHE("USER_CACHE", "用户缓存"),
	
	/** 商品缓存 */
	PRODUCT_CACHE("PRODUCT_CACHE", "商品缓存");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>LocalCacheEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private LocalCacheEnum(String code, String message) {
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
	 * @return LocalCacheEnum
	 */
	public static LocalCacheEnum getByCode(String code) {
		for (LocalCacheEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<LocalCacheEnum>
	 */
	public List<LocalCacheEnum> getAllEnum() {
		List<LocalCacheEnum> list = new ArrayList<LocalCacheEnum>();
		for (LocalCacheEnum cache : values()) {
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
		for (LocalCacheEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
