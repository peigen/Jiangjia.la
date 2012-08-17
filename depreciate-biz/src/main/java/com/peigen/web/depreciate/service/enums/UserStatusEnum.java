/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename UserStatusEnum.java
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
public enum UserStatusEnum {
	
	/** 初始 */
	INIT("INIT", "初始"),
	
	/** 邮箱认证 */
	MAIL_CERTIFIED("MAIL_CERTIFIED", "邮箱认证");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>UserStatusEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private UserStatusEnum(String code, String message) {
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
	 * @return UserStatusEnum
	 */
	public static UserStatusEnum getByCode(String code) {
		for (UserStatusEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<UserStatusEnum>
	 */
	public List<UserStatusEnum> getAllEnum() {
		List<UserStatusEnum> list = new ArrayList<UserStatusEnum>();
		for (UserStatusEnum cache : values()) {
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
		for (UserStatusEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
