/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.util;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.peigen.common.lang.util.CookieHelper;

/**
 *                       
 * @Filename TokenUtil.java
 *
 * @Description 令牌工具类
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2012-3-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class TokenUtil {
	
	private static final Logger	logger			= LoggerFactory.getLogger(TokenUtil.class);
	
	public static final String	COOKIE_TOKEN	= "COOKIE_TOKEN";
	
	public static final String	TOKEN			= "token";
	
	/**
	 *	生成令牌
	 *
	 * @param response
	 * @param domain 哉名
	 */
	public static void generate(HttpServletResponse response, ModelMap modelMap) {
		
		String uuid = UUID.randomUUID().toString();
		Cookie cookie = new Cookie(COOKIE_TOKEN, uuid);
		cookie.setPath("/");
		CookieHelper.addCookies(response, cookie, 30 * 60);
		modelMap.put(TOKEN, uuid);
	}
	
	/**
	 *	验证令牌 
	 *
	 * @param request
	 * @param response
	 * @param domain
	 * @return
	 */
	public static boolean verification(HttpServletRequest request, HttpServletResponse response) {
		
		Object object = request.getParameter(TOKEN);
		
		if (null == object) {
			return false;
		}
		String token = object.toString();
		String cookieToken = CookieHelper.getCookieByName(request, COOKIE_TOKEN);
		
		if (token.equals(cookieToken)) {
			clean(response);
			return true;
		} else {
			logger.error("表单提交token异常 [token = " + token + ", cookieToken =" + cookieToken + "]");
			return false;
		}
	}
	
	/**
	 *	清除令牌
	 *
	 * @param response
	 * @param domain 哉名
	 */
	private static void clean(HttpServletResponse response) {
		Cookie cookie = new Cookie(COOKIE_TOKEN, null);
		cookie.setPath("/");
		CookieHelper.removeCookie(response, cookie, COOKIE_TOKEN);
	}
}
