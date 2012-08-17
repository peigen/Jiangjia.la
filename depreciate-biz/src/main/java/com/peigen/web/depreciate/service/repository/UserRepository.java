/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename UserRepository.java
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
 *<li>Date: 2011-11-17</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface UserRepository {
	
	/**
	 * @param user
	 */
	public void store(UserInfo user);
	
}
