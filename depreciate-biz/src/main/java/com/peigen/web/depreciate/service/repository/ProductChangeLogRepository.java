/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import com.peigen.web.depreciate.service.info.ProductChangeLogInfo;

/**
 *                       
 * @Filename ProductChangeLogRepository.java
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
 *<li>Date: 2011-11-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface ProductChangeLogRepository {
	
	/**
	 * @param changeLogInfo
	 */
	public void store(ProductChangeLogInfo changeLogInfo);
}
