/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename DepreciateResultEnum.java
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
public enum DepreciateResultEnum {
	
	/** 未知异常 */
	UN_KNOWN_EXCEPTION("UN_KNOWN_EXCEPTION", "未知异常"),
	
	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功"),
	
	/** 请求参数异常 */
	INCOMPLETE_REQ_PARAM("INCOMPLETE_REQ_PARAM", "请求参数异常"),
	
	/** 警告：不支持的日期格式化字符，请使用yyyymmdd格式 */
	UN_SUPPROT_DATE_FORMAT("UN_SUPPROT_DATE_FORMAT", "警告：不支持的日期格式化字符，请使用yyyymmdd格式"),
	
	/** 警告：不支持的日期范围段 */
	UN_SUPPROT_DATE_SCALE("UN_SUPPROT_DATE_SCALE", "警告：不支持的日期范围段"),
	
	/** 警告：不支持的额度区间 */
	UN_SUPPROT_QUOTA_SCALE("UN_SUPPROT_QUOTA_SCALE", "警告：不支持的额度区间"),
	
	/** ==============领域模型异常==============*/
	
	/** 激活领域对象异常 */
	DEPRECIATE_ACTIVE_EXCEPTION("DEPRECIATE_ACTIVE_EXCEPTION", "激活领域对象异常"),
	
	/** 重复的 */
	DEPRECIATE_DUPLICATE_EXCEPTION("DEPRECIATE_DUPLICATE_EXCEPTION", "重复的"),
	
	/** 解析产品异常 */
	DEPRECIATE_PARSE_PRODUCT_EXCEPTION("DEPRECIATE_PARSE_PRODUCT_EXCEPTION", "解析产品异常"),
	
	/** ==============数据库异常==============*/
	/** 数据库异常 */
	SQL_EXCEPTION("SQL_EXCEPTION", "数据库异常"),
	
	/** 未查到数据异常 */
	HAVE_NOT_DATA_EXCEPTION("HAVE_NOT_DATA_EXCEPTION", "未查到数据异常"),
	
	/** ==============图片存储异常==============*/
	/** 创建文件夹异常 */
	MKDIR_EXCEPTION("MKDIR_EXCEPTION", "创建文件夹异常"),
	
	/** 添加图片异常 */
	ADD_PIC_EXCEPTION("ADD_PIC_EXCEPTION", "添加图片异常"), ;
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>DepreciateResultEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private DepreciateResultEnum(String code, String message) {
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
	 * @return DepreciateResultEnum
	 */
	public static DepreciateResultEnum getByCode(String code) {
		for (DepreciateResultEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DepreciateResultEnum>
	 */
	public List<DepreciateResultEnum> getAllEnum() {
		List<DepreciateResultEnum> list = new ArrayList<DepreciateResultEnum>();
		for (DepreciateResultEnum cache : values()) {
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
		for (DepreciateResultEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
