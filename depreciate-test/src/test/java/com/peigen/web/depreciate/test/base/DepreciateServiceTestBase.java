/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.web.depreciate.deamon.task.InspectProductPriceTask;
import com.peigen.web.depreciate.service.api.ProductService;
import com.peigen.web.depreciate.service.api.UserService;
import com.peigen.web.depreciate.service.cache.UserLocalCache;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.misc.image.PicBucketService;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.UserSignUpOrder;
import com.peigen.web.depreciate.service.query.ProductQueryService;
import com.peigen.web.depreciate.service.query.UserAttentionQueryService;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename DepreciateServiceTestBase.java
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
public class DepreciateServiceTestBase extends DepreciateDalTestBase {
	
	// service
	@Autowired
	protected ProductService			productService;
	
	@Autowired
	protected UserService				userService;
	
	@Autowired
	protected ProductQueryService		productQueryService;
	
	@Autowired
	protected UserAttentionQueryService	userAttentionQueryService;
	
	// task
	@Autowired
	protected InspectProductPriceTask	inspectProductPriceTask;
	
	// cache
	@Autowired
	protected UserLocalCache			userLocalCache;
	
	// misc
	@Autowired
	protected PicBucketService			picBucketService;
	
	// 内部方法
	protected ProductOrder genProductOrder() {
		ProductOrder order = new ProductOrder();
		order.setUrl(TEST_URL_MBAOBAO);
		
		UserInfo user = initUserPeigen();
		order.setUserId(user.getId());
		
		return order;
	}
	
	protected void cleanProduct() {
		depreciateProductDAO.deleteBySerialNoForTest(TEST_CATEGORY_MBAOBAO,
			TrackCategoryEnum.MBAOBAO.code());
	}
	
	protected UserInfo initUserPeigen() {
		
		cleanUser(TEST_USER_NAME);
		
		UserSignUpOrder signUpOrder = new UserSignUpOrder();
		signUpOrder.setUserEmail(TEST_USER_EMAIL);
		signUpOrder.setUserPasswd(TEST_USER_PASSWD);
		
		UserResult result = userService.signUp(signUpOrder);
		
		return result.getUserInfo();
	}
	
	protected void cleanUser(String userName) {
		depreciateUserDAO.deleteByUserNameForTest(userName);
	}
	
	protected void cleanUserByEmail(String userEmail) {
		depreciateUserDAO.deleteByUserEmailForTest(userEmail);
	}
	
}
