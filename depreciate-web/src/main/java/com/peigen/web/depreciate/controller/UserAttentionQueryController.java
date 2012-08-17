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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.service.result.BatchUserAttentionResult;

/**
 *                       
 * @Filename UserAttentionQueryController.java
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
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Controller
public class UserAttentionQueryController extends ControllerBase {
	
	@RequestMapping(value = "/userAttentionQueryService/loadUserAttentions.ws", method = { RequestMethod.GET })
	@ResponseBody
	public String loadUserAttentions(ModelMap modelMap, HttpServletRequest request) {
		
		String userId = getParameterTrim(request, "userId");
		
		PrintLogTool.info("根据用户ID查询关注商品[userId=" + userId + "]", logger);
		
		BatchUserAttentionResult result = userAttentionQueryService.loadUserAttentions(userId);
		
		if (result.isSuccess() && result.isExecuted()) {
			
			return JSONObject.toJSONString(result);
		}
		
		return "日~~~出错了";
	}
}
