/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query.impl;

import com.peigen.web.depreciate.service.DepreciateServiceBase;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.query.UserQueryService;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename UserQueryServiceImpl.java
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
public class UserQueryServiceImpl extends DepreciateServiceBase implements UserQueryService {
	
	/**
	 * @param userId
	 * @return
	 * @see com.peigen.web.depreciate.service.query.UserQueryService#findUserById(java.lang.String)
	 */
	@Override
	public UserResult findUserById(String userId) {
		
		UserResult result = new UserResult();
		
		UserInfo userInfo = userLocalCache.getUserById(userId);
		
		if (userInfo != null) {
			result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
			result.setSuccess(true);
			
			result.setUserInfo(userInfo);
			
		}
		return result;
	}
	
	/**
	 * @param userName
	 * @return
	 * @see com.peigen.web.depreciate.service.query.UserQueryService#findUserByName(java.lang.String)
	 */
	@Override
	public UserResult findUserByName(String userName) {
		
		UserResult result = new UserResult();
		
		UserInfo userInfo = userLocalCache.getUserByName(userName);
		
		if (userInfo != null) {
			result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
			result.setSuccess(true);
			
			result.setUserInfo(userInfo);
			
		}
		
		return result;
	}
	
	/**
	 * @param email
	 * @return
	 * @see com.peigen.web.depreciate.service.query.UserQueryService#findUserByEmail(java.lang.String)
	 */
	@Override
	public UserResult findUserByEmail(String email) {
		UserResult result = new UserResult();
		
		UserInfo userInfo = userLocalCache.getUserByEmail(email);
		
		if (userInfo != null) {
			result.setSuccess(true);
			result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
			
			result.setUserInfo(userInfo);
		}
		
		return result;
	}
}
