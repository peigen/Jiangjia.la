/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api;

import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.UserSignInOrder;
import com.peigen.web.depreciate.service.order.UserSignUpOrder;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename UserService.java
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
public interface UserService {
	
	/**
	 * 关注商品
	 * @param userId
	 * @param productOrder
	 * @return
	 */
	public UserResult attentionProduct(String userId, ProductOrder productOrder);
	
	/**
	 * 取消关注
	 * @param userId
	 * @param productId
	 * @return
	 */
	public UserResult ignoreProduct(String userId, String productId);
	
	/**
	 * 注册
	 * 
	 * @param signUpOrder
	 * @return
	 */
	public UserResult signUp(UserSignUpOrder signUpOrder);
	
	/**
	 * 通过email注册
	 * 
	 * @param email
	 * @return
	 */
	public UserResult signUpByEmail(String email);
	
	/**
	 * 登录
	 * @param signinOrder
	 * @return
	 */
	public UserResult signIn(UserSignInOrder signinOrder);
}
