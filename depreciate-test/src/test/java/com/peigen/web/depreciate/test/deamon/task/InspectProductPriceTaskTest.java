/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.deamon.task;

import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename InspectProductPriceTaskTest.java
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
public class InspectProductPriceTaskTest extends DepreciateServiceTestBase {
	
	public void testInspect() {
		inspectProductPriceTask.inspect();
	}
}
