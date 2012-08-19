/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.misc;

import com.peigen.web.depreciate.service.result.BatchUserAttentionResult;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename ControllerTest.java
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
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ControllerTest extends DepreciateServiceTestBase {
	
	public void testLoadUserAttentions() {
		BatchUserAttentionResult result = userAttentionQueryService
			.loadUserAttentions("2011111800000001");
		print(result);
	}
	
	public void testLoadUserAttentionsController() {
		
	}
	
}
