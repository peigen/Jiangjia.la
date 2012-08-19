/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.controller.base.ControllerBase;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.result.BatchUserAttentionResult;
import com.peigen.web.depreciate.service.result.ProductResult;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename IndexController.java
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
 *<li>Date: 2011-11-9</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class IndexController extends ControllerBase {
	
	@RequestMapping(value = "/index.html")
	public String index() {
		
		return "index.vm";
	}
	
	@RequestMapping(value = "/showMyFollow.html", method = { RequestMethod.GET })
	public String showMyFollow(ModelMap modelMap, HttpServletRequest request) {
		
		PrintLogTool.info("查找", logger);
		
		String userName = getParameterTrim(request, "userName");
		
		UserResult result = userQueryService.findUserByName(userName);
		
		if (result.isSuccess() && result.isExecuted()) {
			
			modelMap.put("userInfo", result.getUserInfo());
			
			UserInfo userInfo = result.getUserInfo();
			
			BatchUserAttentionResult batchUserAttentionResult = userAttentionQueryService
				.loadUserAttentions(userInfo.getId());
			
			if (batchUserAttentionResult.isSuccess() && batchUserAttentionResult.isExecuted()) {
				modelMap.put("attentionProducts", batchUserAttentionResult.getUserAttentions());
			}
			
		}
		return "index.vm";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/follow.html", method = { RequestMethod.POST })
	public String follow(ModelMap modelMap, HttpServletRequest request) {
		
		String attentionUrl = getParameterTrim(request, "attentionUrl");
		String userId = getParameterTrim(request, "userId");
		String userName = getParameterTrim(request, "userName");
		
		UserResult result = userQueryService.findUserByName(userName);
		
		if (result.isSuccess() && result.isExecuted()) {
			
			ProductOrder productOrder = new ProductOrder();
			productOrder.setUrl(attentionUrl);
			productOrder.setUserId(result.getUserInfo().getId());
			
			ProductResult productResult = productService.addProduct(productOrder);
			
		}
		return "index.vm";
	}
}
