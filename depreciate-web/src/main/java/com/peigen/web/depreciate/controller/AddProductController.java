/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.peigen.common.lang.util.ListUtil;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.ProductParaOrder;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename AddProductController.java
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
public class AddProductController extends ControllerBase {
	
	@RequestMapping(value = "/addByEmail.ws", method = { RequestMethod.GET })
	@ResponseBody
	public String addByEmail(HttpServletRequest request) {
		
		String email = getParameterTrim(request, "email");
		String url = getParameterTrim(request, "url");
		
		if (StringUtil.isBlank(email) || StringUtil.isBlank(url)) {
			JSONObject.toJSONString("狗日，你丫是二啊!");
		}
		
		ProductResult result = new ProductResult();
		
		ProductOrder productOrder = new ProductOrder();
		productOrder.setUrl(url);
		productOrder.setUserId(getUser(email).getId());
		
		result = productService.addProduct(productOrder);
		
		return JSONObject.toJSONString(result);
	}
	
	@RequestMapping(value = "/addByPara.ws", method = { RequestMethod.GET })
	@ResponseBody
	public String addByPara(HttpServletRequest request) {
		
		String email = getParameterTrim(request, "email");
		String url = getParameterTrim(request, "url");
		String price = getParameterTrim(request, "price");
		String serialNo = getParameterTrim(request, "serialNo");
		String imagesStr = getParameterTrim(request, "imagesStr");
		
		if (StringUtil.isBlank(email) || StringUtil.isBlank(url) || StringUtil.isBlank(price)
			|| StringUtil.isBlank(serialNo)) {
			return JSONObject.toJSONString("狗日，你丫是二啊!");
		}
		
		ProductResult result = new ProductResult();
		
		ProductParaOrder productOrder = new ProductParaOrder();
		productOrder.setUrl(url);
		productOrder.setUserId(getUser(email).getId());
		productOrder.setPrice(new Money(price));
		productOrder.setSerialNo(serialNo);
		
		List<String> images = ListUtil.toList(imagesStr);
		productOrder.setImages(images);
		
		result = productService.addProduct(productOrder);
		
		return JSONObject.toJSONString(result);
	}
}
