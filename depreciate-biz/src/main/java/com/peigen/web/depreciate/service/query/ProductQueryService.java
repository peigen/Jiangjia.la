/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query;

import java.util.List;

import com.peigen.web.depreciate.service.result.BatchProductResult;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename ProductQueryService.java
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
public interface ProductQueryService {
	
	/**
	 * @param productId
	 * @return
	 */
	public ProductResult findProductById(String productId);
	
	/**
	 * @param productId
	 * @return
	 */
	public BatchProductResult findProductById(List<String> productIds);
	
	/**
	 * @param serialNo
	 * @param category
	 * @return
	 */
	public ProductResult findProductBySerialNoAndCategory(String serialNo, String category);
	
	/**
	 * 读取整个产品列表，不推荐试用，日后量大了重构掉
	 * @return
	 */
	public BatchProductResult loadAll();
}
