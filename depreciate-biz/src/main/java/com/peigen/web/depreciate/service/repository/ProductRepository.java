/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import com.peigen.web.depreciate.service.info.ProductInfo;

/**
 *                       
 * @Filename ProductRepository.java
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
 *<li>Date: 2011-11-14</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface ProductRepository extends repository {
	
	/** 
	 * 存入商品数据
	 * 
	 * @param product
	 */
	public void store(ProductInfo product);
	
	/** 
	 * 更新商品数据
	 * 
	 * @param productInfo
	 */
	public void reStore(ProductInfo productInfo);
	
	/**
	 * 激活，主要用于锁定
	 * 
	 * @param productId
	 * @return
	 */
	public ProductInfo active(String productId);
}
