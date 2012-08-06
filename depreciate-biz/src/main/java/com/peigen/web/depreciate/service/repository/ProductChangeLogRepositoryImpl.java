/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductChangeLogDO;
import com.peigen.web.depreciate.service.info.ProductChangeLogInfo;

/**
 *                       
 * @Filename ProductChangeLogRepositoryImpl.java
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
public class ProductChangeLogRepositoryImpl extends RepositoryBase implements
																	ProductChangeLogRepository {
	
	/**
	 * @param changeLogInfo
	 * @see com.peigen.web.depreciate.service.repository.ProductChangeLogRepository#store(com.peigen.web.depreciate.service.info.ProductChangeLogInfo)
	 */
	@Override
	public void store(ProductChangeLogInfo changeLogInfo) {
		PrintLogTool.info("存入商品变更记录[changeLog=" + changeLogInfo + "]", logger);
		
		DepreciateProductChangeLogDO changeLog = new DepreciateProductChangeLogDO();
		
		changeLog.setProductChangePrice(changeLogInfo.getProductChangePrice().getCent());
		changeLog.setProductCurrentPrice(changeLogInfo.getProductCurrentPrice().getCent());
		changeLog.setProductId(changeLogInfo.getProductId());
		
		depreciateProductChangeLogDAO.insert(changeLog);
	}
	
}
