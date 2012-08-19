/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.api.ProductService;
import com.peigen.web.depreciate.service.api.UserService;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.query.ProductQueryService;
import com.peigen.web.depreciate.service.query.UserAttentionQueryService;
import com.peigen.web.depreciate.service.query.UserQueryService;
import com.peigen.web.depreciate.service.result.Result;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename ControllerBase.java
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
 *<li>Date: 2011-11-10</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ControllerBase {
	
	protected final Logger				logger	= LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected UserQueryService			userQueryService;
	
	@Autowired
	protected ProductService			productService;
	
	@Autowired
	protected ProductQueryService		productQueryService;
	
	@Autowired
	protected UserAttentionQueryService	userAttentionQueryService;
	
	@Autowired
	protected UserService				userService;
	
	/**
	 * @param request
	 * @param parameterName
	 * @return
	 */
	protected String getParameterTrim(HttpServletRequest request, String parameterName) {
		return StringUtil.trim(request.getParameter(parameterName));
	}
	
	/**
	 * @param result
	 * @return
	 */
	protected boolean isResultSuccess(Result result) {
		if (result.isSuccess() && result.isExecuted()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected UserInfo getUser(String email) {
		UserResult userResult = userQueryService.findUserByEmail(email);
		
		// 没有就注册一个
		if (!userResult.isSuccess() || !userResult.isExecuted()) {
			userResult = userService.signUpByEmail(email);
		}
		
		return userResult.getUserInfo();
	}
	
}
