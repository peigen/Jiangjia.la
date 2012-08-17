/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.dal;

import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;
import com.peigen.web.depreciate.test.base.DepreciateDalTestBase;

/**
 *                       
 * @Filename ExtraDAOTest.java
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
public class ExtraDAOTest extends DepreciateDalTestBase {
	
	@DepreciateTestAnnotated(description = "Extra测试用例")
	public void testGetSysdate() {
		int i = extraDAO.getNextSeq("test");
		print(i);
	}
	
}
