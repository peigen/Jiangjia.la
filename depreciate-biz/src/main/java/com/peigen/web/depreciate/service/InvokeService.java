/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service;

import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.order.Order;

/**
 *                       
 * @Filename InvokeService.java
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
 *<li>Date: 2011-11-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface InvokeService {
	
	public ProductInfo invoke(Order order, ProductInfo productInfo);
}
