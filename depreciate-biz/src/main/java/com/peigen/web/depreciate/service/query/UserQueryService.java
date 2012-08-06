/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query;

import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename UserQueryService.java
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
public interface UserQueryService {
	
	/**
	 * @param userId
	 * @return
	 */
	public UserResult findUserById(String userId);
	
	/**
	 * @param userName
	 * @return
	 */
	public UserResult findUserByName(String userName);
	
	/**
	 * @param email
	 * @return
	 */
	public UserResult findUserByEmail(String email);
	
}
