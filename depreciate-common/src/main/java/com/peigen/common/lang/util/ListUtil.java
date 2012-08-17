/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import java.util.Arrays;
import java.util.List;

import com.peigen.common.lang.util.StringUtil;

/**
 *                       
 * @Filename ListUtil.java
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
 *<li>Date: 2011-11-12</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ListUtil {
	
	/**
	 * 把收到的页面内容转换成核心程序可识别的格式
	 * @param str
	 * @return
	 */
	public static List<String> toList(String str) {
		
		if (StringUtil.isBlank(str)) {
			return null;
		}
		
		// 1. 统一转换中文标点
		str = StringUtil.replace(str, "，", ",");
		
		// 2. 约定只用逗号分割
		String[] array = StringUtil.split(str, DepreciateConstants.SEPARATOR_CHAR_COMMA);
		List<String> list = Arrays.asList(array);
		return list;
	}
	
	public static String toStr(List<String> list) {
		
		String str = "";
		
		if (list == null || list.isEmpty()) {
			return str;
		}
		
		for (String _str : list) {
			str += _str + DepreciateConstants.SEPARATOR_CHAR_COMMA;
		}
		
		return str;
	}
	
}
