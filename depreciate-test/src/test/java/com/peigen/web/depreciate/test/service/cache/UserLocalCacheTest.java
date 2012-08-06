/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.cache;

import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename UserLocalCacheTest.java
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
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserLocalCacheTest extends DepreciateServiceTestBase {
	
	public void testGetUserByUserName() {
		String userName = "peigen";
		
		UserInfo userInfo = userLocalCache.getUserByName(userName);
		
		print(userInfo);
		assertNotNull(userInfo);
		
	}
	
}
