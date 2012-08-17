/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserDAO;

/**
 *                       
 * @Filename DepreciateDalTestBase.java
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
public class DepreciateDalTestBase extends DepreciateTestBase {
	
	@Autowired
	protected DepreciateUserDAO		depreciateUserDAO;
	
	@Autowired
	protected DepreciateProductDAO	depreciateProductDAO;
}
