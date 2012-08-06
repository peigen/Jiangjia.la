/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api;

import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;

/**
 *                       
 * @Filename ParseService.java
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
public interface ParseService {
	
	public ProductInfo parse(String productUrl);
	
	public TrackCategoryEnum parseCategory(String url);
}
