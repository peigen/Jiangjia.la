/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.api;

import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.result.UserResult;
import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename UserServiceTest.java
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
 *<li>Date: 2011-11-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserServiceTest extends DepreciateServiceTestBase {
	
	@DepreciateTestAnnotated(description = "用户注册测试用例---成功用例")
	public void testUserSignUp() {
		UserInfo user = initUserPeigen();
		
		assertNotNull(user);
		assertTrue(StringUtil.isNotBlank(user.getId()));
		
		print(user);
	}
	
	@DepreciateTestAnnotated(description = "用email注册用户测试用例---成功用例")
	public void testUserSignUpByEmail() {
		String email = "TEST@jiangjia.la";
		
		cleanUserByEmail(email);
		
		UserResult result = userService.signUpByEmail(email);
		
		print(result);
		assertResult(result);
	}
}
