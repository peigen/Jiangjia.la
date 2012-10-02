/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api;

import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.ProductParaOrder;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename ProductService.java
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
 *<li>Date: 2011-11-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface ProductService {
	
	/**
	 * 增加商品
	 * 
	 * @param productOrder
	 * @return
	 */
	public ProductResult resolveProduct(ProductOrder productOrder);
	
	/**
	 * 增加商品
	 * 
	 * @param productOrder
	 * @return
	 */
	public ProductResult addProduct(ProductOrder productOrder);
	
	/**
	 * 增加商品
	 * 
	 * @param productOrder
	 * @return
	 */
	public ProductResult addProduct(ProductParaOrder productOrder);
	
	/**
	 * 改变商品单价
	 * 
	 * @param productId
	 * @param changePrice
	 * @return
	 */
	public ProductResult changeProductPrice(String productId, Money changePrice);
	
	/**
	 * 改变商品属性
	 * 
	 * @param productId
	 * @param url
	 * @param productName
	 * @return
	 */
	public ProductResult editProduct(String productId, String url, String productName);
}
