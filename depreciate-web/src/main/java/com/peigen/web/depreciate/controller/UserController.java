/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.peigen.web.depreciate.controller.base.UserControllerBase;
import com.peigen.web.depreciate.form.UserSigninForm;
import com.peigen.web.depreciate.form.UserSignupForm;
import com.peigen.web.depreciate.service.order.UserSignInOrder;
import com.peigen.web.depreciate.service.order.UserSignUpOrder;
import com.peigen.web.depreciate.service.result.UserResult;
import com.peigen.web.depreciate.util.LoginUtil;

/**
 *                       
 * @Filename UserController.java
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
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class UserController extends UserControllerBase {
	
	@RequestMapping(value = "/signUp.html", method = { RequestMethod.POST })
	public ModelAndView signup(ModelMap modelMap, HttpServletRequest request,
								UserSignupForm signupForm) {
		
		UserSignUpOrder signUpOrder = new UserSignUpOrder(signupForm.getPassword(),
			signupForm.getEmail());
		UserResult result = userService.signUp(signUpOrder);
		
		String referUrl = getReferUrl(request);
		
		if (isResultSuccess(result)) {
			modelMap.put("result", "注册成功!");
			modelMap.put("userInfo", result.getUserInfo());
			
			//清理session
			LoginUtil.cleanSession(request);
			LoginUtil.updateLoginSession(request, modelMap, result.getUserInfo());
			// 重定向到来源url
			return new ModelAndView(new RedirectView(referUrl), modelMap);
		}
		
		return new ModelAndView(new RedirectView(referUrl), modelMap);
	}
	
	@RequestMapping(value = "/signIn.html", method = { RequestMethod.POST })
	public ModelAndView signin(ModelMap modelMap, HttpServletRequest request,
								UserSigninForm signinForm) {
		
		UserSignInOrder signinOrder = new UserSignInOrder(signinForm.getPassword(),
			signinForm.getEmail());
		
		UserResult result = userService.signIn(signinOrder);
		
		String referUrl = getReferUrl(request);
		
		if (isResultSuccess(result)) {
			modelMap.put("result", "登录成功!");
			modelMap.put("userInfo", result.getUserInfo());
			
			//清理session
			LoginUtil.cleanSession(request);
			LoginUtil.updateLoginSession(request, modelMap, result.getUserInfo());
			// 重定向到来源url
			return new ModelAndView(new RedirectView(referUrl), modelMap);
		}
		
		else {
			
		}
		return new ModelAndView(new RedirectView(referUrl), modelMap);
	}
	
	@RequestMapping("/signOut.html")
	public ModelAndView signOut(HttpServletRequest request) throws IOException {
		LoginUtil.cleanSession(request);
		return new ModelAndView(new RedirectView("/index.html"));
	}
}
