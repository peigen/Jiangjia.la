/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.depreciate.dal.daointerface;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductDO;

/**
 *                       
 * @Filename ExtraDAO.java
 *
 * @Description 手动写的sql
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-9-6</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface ExtraDAO {
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public Date getSysdate();
	
	/**
	 * 获取Seq
	 * 
	 * @param name
	 * @return
	 * @throws DataAccessException
	 */
	public int getNextSeq(String name) throws DataAccessException;
	
	/**
	 * 根据商品id集合查询
	 * 
	 * @param productIds
	 * @return
	 */
	public List<DepreciateProductDO> loadByProductIds(List<String> productIds);
	
}
