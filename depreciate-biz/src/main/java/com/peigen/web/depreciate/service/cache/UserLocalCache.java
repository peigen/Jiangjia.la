/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.cache;

import java.util.Set;

import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename UserLocalCache.java
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
public interface UserLocalCache extends LocalCache {
	
	public Set<UserInfo> loadAllUser();
	
	public UserInfo getUserById(String userId);
	
	public UserInfo getUserByName(String userName);
	
	public UserInfo getUserByEmail(String email);
	
	public UserInfo getUserByPasswd(String passwd);
}
