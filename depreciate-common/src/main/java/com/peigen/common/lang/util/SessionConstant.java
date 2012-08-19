/**
 * www.yuitat.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.common.lang.util;

/**
 *                       
 * @Filename SessionConstant.java
 *
 * @Description session常量
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
public class SessionConstant {
	
	/** 登录用户信息key */
	public final static String	SESSION_LOGIN_INFO_KEY		= "SESSION_LOGIN_INFO_KEY";
	
	/**	登录错误次数key*/
	public static String		SESSION_LOGIN_ERROR_NUM_KEY	= "SESSION_LOGIN_ERROR_NUM_KEY";
	
	/** 最大登录错误次数*/
	public static int			LOGIN_ERROR_MAX_NUM			= 3;
	
	/** 验证码key */
	public final static String	SESSION_CHECK_CODE_KEY		= "SESSION_CHECK_CODE_KEY";
	
	/** 登录角色KEY*/
	public final static String	SESSION_LOGIN_ROLE_CODE		= "SESSION_LOGIN_ROLE_CODE";
}
