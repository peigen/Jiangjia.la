/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peigen.web.depreciate.form.UserSignupForm;
import com.peigen.web.depreciate.service.order.UserSignUpOrder;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename RegisterController.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class UserController extends ControllerBase {
	
	@RequestMapping(value = "/signUp.html", method = { RequestMethod.POST })
	public String signup(ModelMap modelMap, HttpServletRequest request, UserSignupForm signupForm) {
		
		UserSignUpOrder signUpOrder = new UserSignUpOrder(signupForm.getPassword(),
			signupForm.getEmail());
		UserResult result = userService.signUp(signUpOrder);
		if (result.isExecuted()) {
			modelMap.put("result", "注册成功!");
			modelMap.put("userInfo", result.getUserInfo());
		}
		return "index.vm";
	}
}
