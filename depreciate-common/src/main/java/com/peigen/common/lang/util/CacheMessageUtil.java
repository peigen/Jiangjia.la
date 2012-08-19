/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *                       
 * @Filename CacheMessageUtil.java
 *
 * @Description 根据不同类型整合cache输出内容到Stringbuffer中。
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CacheMessageUtil {
	public static final String	ENTERSTR	= "\n";
	
	/**
	 * 对于Map<String, Object>的类型转换
	 * 
	 * @param Map<String, Object>
	 * @return StringBuffer
	 */
	public static StringBuffer mapStringAndObject(Map map) {
		
		StringBuffer cacheMessage = new StringBuffer();
		
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {
			
			String name = i.next();
			
			cacheMessage.append(ENTERSTR
								+ "["
								+ name
								+ "={"
								+ ToStringBuilder.reflectionToString(map.get(name),
									ToStringStyle.SHORT_PREFIX_STYLE) + "}]");
			
		}
		return cacheMessage;
	}
	
	/**
	 * 对于List<Object>的类型转换
	 * 
	 * @param List<Object>
	 * @return StringBuffer
	 */
	public static StringBuffer listObject(List list) {
		
		StringBuffer cacheMessage = new StringBuffer();
		
		for (Object data : list) {
			
			cacheMessage.append(ENTERSTR + "["
			
			+ ToStringBuilder.reflectionToString(data, ToStringStyle.SHORT_PREFIX_STYLE) + "]");
		}
		return cacheMessage;
	}
	
	/**
	 * 对于Map<String, List<String>>的类型转换
	 * 
	 * @param Map<String, List<String>>
	 * @return StringBuffer
	 */
	public static StringBuffer mapStringAndListString(Map<String, List<String>> map) {
		
		StringBuffer cacheMessage = new StringBuffer();
		
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			
			cacheMessage.append(ENTERSTR + "[" + entry.getKey() + "={");
			
			for (String s : entry.getValue()) {
				
				cacheMessage.append("|" + s);
				
			}
			cacheMessage.append("}]");
			
		}
		return cacheMessage;
	}
	
	/**
	 * 对于Map<String, String>的类型转换
	 * 
	 * @param Map<String, String>
	 * @return StringBuffer
	 */
	public static StringBuffer mapStringAndString(Map map) {
		
		StringBuffer cacheMessage = new StringBuffer();
		
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext();) {
			
			String name = i.next();
			
			cacheMessage.append(ENTERSTR + "[" + name + "=" + map.get(name) + "]");
			
		}
		
		return cacheMessage;
	}
	
	/**
	 * 对于List<String>的类型转换
	 * 
	 * @param List<String>
	 * @return StringBuffer
	 */
	public static StringBuffer listString(List<String> list) {
		
		StringBuffer cacheMessage = new StringBuffer();
		
		for (String s : list) {
			
			cacheMessage.append(ENTERSTR + "[" + s + "]");
		}
		return cacheMessage;
	}
}
