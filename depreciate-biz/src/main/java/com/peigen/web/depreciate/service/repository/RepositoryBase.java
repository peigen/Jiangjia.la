/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductChangeLogDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductPicDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserAttentionDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.ExtraDAO;

/**
 *                       
 * @Filename RepositoryBase.java
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
public class RepositoryBase {
	
	protected final Logger					logger	= LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected ExtraDAO						extraDAO;
	
	@Autowired
	protected DepreciateProductDAO			depreciateProductDAO;
	
	@Autowired
	protected DepreciateProductPicDAO		depreciateProductPicDAO;
	
	@Autowired
	protected DepreciateUserDAO				depreciateUserDAO;
	
	@Autowired
	protected DepreciateProductChangeLogDAO	depreciateProductChangeLogDAO;
	
	@Autowired
	protected DepreciateUserAttentionDAO	depreciateUserAttentionDAO;
	
}
