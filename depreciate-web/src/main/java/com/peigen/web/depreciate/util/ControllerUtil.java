/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.util;

import javax.servlet.http.HttpServletRequest;

import com.peigen.common.lang.util.context.OperationContext;
import com.peigen.common.lang.util.context.OperationContext.OperationTypeEnum;

/**
 *                       
 * @Filename ControllerUtil.java
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
 *<li>Date: 2012-2-17</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ControllerUtil {
	
	/**
	 * 构造上下文对象
	 *  
	 * @param request
	 * @return
	 */
	public static OperationContext buildOperationContext(HttpServletRequest request) {
		
		OperationContext operationContext = new OperationContext();
		
		operationContext.setOperationIp(getRemoteAddress(request));
		operationContext.setOperationType(OperationTypeEnum.member);
		//		operationContext.setOperationId(LoginUtil.getCurrentLoginId(request));
		//		operationContext.setOperationName(LoginUtil.getCurrentLoginUserName(request));
		
		return operationContext;
	}
	
	private static String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
