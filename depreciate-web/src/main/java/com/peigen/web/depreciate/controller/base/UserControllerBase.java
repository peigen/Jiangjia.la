/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 *                       
 * @Filename UserControllerBase.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen@yiji.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2012-8-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserControllerBase extends ControllerBase {
	
	protected static String	REFER_URL	= "referrerURL";
	
	/**
	 *	获取登录来源 url
	 */
	@SuppressWarnings("deprecation")
	public String getReferUrl(HttpServletRequest request) {
		
		try {
			String referUrl = java.net.URLDecoder.decode(request.getParameter(REFER_URL));
			if (logger.isInfoEnabled()) {
				logger.info("获取登录来源 url[referUrl = " + referUrl + "]");
			}
			
			return StringUtils.isBlank(referUrl) ? "/index.html" : referUrl;
		} catch (Exception e) {
			logger.warn("获取登录来源 url异常: 来源url为空");
			return "/index.html";
		}
	}
}
