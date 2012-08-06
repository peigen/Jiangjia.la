/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.deamon.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.api.ParseService;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.query.ProductQueryService;
import com.peigen.web.depreciate.service.result.BatchProductResult;

/**
 *                       
 * @Filename InspectProductPriceTaskImpl.java
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
 *<li>Date: 2011-11-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class InspectProductPriceTaskImpl implements InspectProductPriceTask {
	
	private final Logger		logger	= LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductQueryService	productQueryService;
	
	@Autowired
	private ParseService		parseService;
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.deamon.task.InspectProductPriceTask#inspect()
	 */
	@Override
	public void inspect() {
		PrintLogTool.info("开始执行【检查商品价格变动】", logger);
		
		BatchProductResult result = productQueryService.loadAll();
		
		if (result.isSuccess() && result.isExecuted() && !result.getProductInfos().isEmpty()) {
			for (ProductInfo _product : result.getProductInfos()) {
				
				ProductInfo newProduct = parseService.parse(_product.getProductUrl());
				
				if (changeAmount(_product.getProductCurrentPrice(),
					newProduct.getProductCurrentPrice())) {
					_product.setProductCurrentPrice(newProduct.getProductCurrentPrice());
					
				}
			}
		}
		
		PrintLogTool.info("【商品价格变动检查完毕】", logger);
	}
	
	// 内部方法
	/**
	 * 假设商家金额有变动，对金额进行判断。并返回boolean值表示要不要更新该商品的金额
	 * 
	 * @param orgiAmount	原始金额---已存在库里面的金额
	 * @param newAmount		新的金额---商家商品价格变动后的金额
	 * 
	 * return boolean
	 */
	private boolean changeAmount(Money orgiAmount, Money newAmount) {
		
		// 如果金额相等
		// 1. 跳出方法
		// 2. 不需要更新商品金额
		if (orgiAmount.equals(newAmount)) {
			return false;
		}
		
		// 如果不相等则更新
		return true;
		
	}
}
