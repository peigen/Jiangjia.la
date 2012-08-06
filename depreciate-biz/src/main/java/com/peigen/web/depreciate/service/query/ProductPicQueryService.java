/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query;

import com.peigen.web.depreciate.service.result.BatchProductPicResult;

/**
 *                       
 * @Filename ProductPicQueryService.java
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
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface ProductPicQueryService {
	
	public BatchProductPicResult loadProductPicsByProductId(String productId);
}
