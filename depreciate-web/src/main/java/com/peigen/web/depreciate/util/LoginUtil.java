/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.peigen.common.lang.util.SessionConstant;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename LoginUtil.java
 *
 * @Description 登录工具类
 *
 * @Version 1.0
 *
 * @Author huqing
 *
 * @Email qing.hu2009@gmail.com
 *       
 * @History
 *<li>Author: huqing</li>
 *<li>Date: 2012-2-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class LoginUtil {
	
	private static final Logger	logger	= LoggerFactory.getLogger(LoginUtil.class);
	
	/**
	 *	 清理session
	 */
	public static void cleanSession(HttpServletRequest request) {
		
		request.getSession().removeAttribute(SessionConstant.SESSION_LOGIN_ERROR_NUM_KEY);
		request.getSession().removeAttribute(SessionConstant.SESSION_CHECK_CODE_KEY);
		request.getSession().removeAttribute(SessionConstant.SESSION_LOGIN_INFO_KEY);
		request.getSession().removeAttribute(SessionConstant.SESSION_LOGIN_ROLE_CODE);
	}
	
	/**
	 *	验证是否为当前登录会员ID 
	 */
	public static boolean isCurrentMember(HttpServletRequest request, String memberId) {
		
		try {
			String currMemberId = getCurrentLoginId(request);
			
			if (null != currMemberId && currMemberId.equals(memberId)) {
				return true;
			}
		} catch (Exception e) {
			logger.error("验证是否为当前登录会员ID异常 [memberId = " + memberId + "]");
		}
		return false;
	}
	
	/**
	 *	检测是否登录 
	 */
	public static boolean isLogin(HttpServletRequest request) {
		return StringUtil.isNotBlank(getCurrentLoginId(request)) ? true : false;
	}
	
	/**
	 *	 用户登录写入Session 
	 */
	public static void updateLoginSession(HttpServletRequest request, ModelMap modelMap,
											Object object) {
		
		PrintLogTool.info("用户登录写入Session [object = " + object + "]", logger);
		request.getSession().setAttribute(SessionConstant.SESSION_LOGIN_INFO_KEY, object);
		
	}
	
	/**
	 *	获取当前登录会员ID 
	 */
	public static String getCurrentLoginId(HttpServletRequest request) {
		
		Object object = request.getSession().getAttribute(SessionConstant.SESSION_LOGIN_INFO_KEY);
		
		if (object instanceof UserInfo) {
			return ((UserInfo) object).getId();
		}
		
		return null;
	}
	
	/**
	 *	获取当前登录会员名称 
	 */
	public static String getCurrentLoginUserName(HttpServletRequest request) {
		
		//		Object object = request.getSession().getAttribute(SessionConstant.SESSION_LOGIN_INFO_KEY);
		
		//		if (object instanceof MemberInfo) {
		//			return ((MemberInfo) object).getUserName();
		//		}
		//		
		//		else if (object instanceof SupplierInfo) {
		//			return ((SupplierInfo) object).getUserName();
		//		}
		
		return null;
	}
	
	/**
	 *	记录登录失败次数 
	 */
	public static void recordLoginErrorNum(HttpServletRequest request) {
		
		int errorNum = 0;
		try {
			errorNum = Integer.parseInt(request.getSession()
				.getAttribute(SessionConstant.SESSION_LOGIN_ERROR_NUM_KEY).toString());
		} catch (Exception e) {
			
		}
		errorNum = errorNum + 1;
		request.getSession().setAttribute(SessionConstant.SESSION_LOGIN_ERROR_NUM_KEY, errorNum);
		logger.info(request.getSession().getAttribute(SessionConstant.SESSION_LOGIN_ERROR_NUM_KEY)
			.toString());
	}
	
	/**
	 *	校验验证码 
	 */
	public static boolean verifyLoginCheckCode(HttpServletRequest request, String checkCode) {
		
		if (!needCheckCode(request)) {
			return true;
		}
		return getSessionCheckCode(request).equalsIgnoreCase(checkCode) ? true : false;
	}
	
	/**
	 *	是否需要验证码 
	 */
	public static boolean needCheckCode(HttpServletRequest request) {
		
		int errorNum = 0;
		try {
			errorNum = Integer.parseInt(request.getSession()
				.getAttribute(SessionConstant.SESSION_LOGIN_ERROR_NUM_KEY).toString());
		} catch (Exception e) {
			
		}
		
		return errorNum >= SessionConstant.LOGIN_ERROR_MAX_NUM ? true : false;
	}
	
	/**
	 *	获取session验证码 
	 */
	private static String getSessionCheckCode(HttpServletRequest request) {
		
		Object checkCode = request.getSession()
			.getAttribute(SessionConstant.SESSION_CHECK_CODE_KEY);
		return null == checkCode ? null : checkCode.toString();
	}
	
}
