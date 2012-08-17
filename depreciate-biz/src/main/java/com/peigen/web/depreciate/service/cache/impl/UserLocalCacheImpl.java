/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.cache.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.CacheMessageUtil;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserDAO;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserDO;
import com.peigen.web.depreciate.service.cache.LocalCacheEnum;
import com.peigen.web.depreciate.service.cache.UserLocalCache;
import com.peigen.web.depreciate.service.constants.LogConstant;
import com.peigen.web.depreciate.service.convert.UserConvertor;
import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename UserLocalCacheImpl.java
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
public class UserLocalCacheImpl implements UserLocalCache {
	
	/** 缓存日志 */
	private static final Logger		logger			= LoggerFactory
														.getLogger(LogConstant.CACHE_LOGGER);
	
	private Map<String, UserInfo>	userIdMap		= new HashMap<String, UserInfo>();
	private Map<String, UserInfo>	userNameMap		= new HashMap<String, UserInfo>();
	private Map<String, UserInfo>	userEmailMap	= new HashMap<String, UserInfo>();
	private Map<String, UserInfo>	userPasswdMap	= new HashMap<String, UserInfo>();
	
	@Autowired
	private DepreciateUserDAO		depreciateUserDAO;
	
	/**
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.UserLocalCache#loadAllUser()
	 */
	@Override
	public Set<UserInfo> loadAllUser() {
		return null;
	}
	
	/**
	 * @param userId
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.UserLocalCache#getUserById(java.lang.String)
	 */
	@Override
	public UserInfo getUserById(String userId) {
		
		if (userIdMap.isEmpty()) {
			refreshLocalCache();
		}
		
		return userIdMap.get(userId);
	}
	
	/**
	 * @param userName
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.UserLocalCache#getUserByName(java.lang.String)
	 */
	@Override
	public UserInfo getUserByName(String userName) {
		if (userNameMap.isEmpty()) {
			refreshLocalCache();
		}
		
		return userNameMap.get(userName);
	}
	
	/**
	 * @param email
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.UserLocalCache#getUserByEmail(java.lang.String)
	 */
	@Override
	public UserInfo getUserByEmail(String email) {
		if (userEmailMap.isEmpty()) {
			refreshLocalCache();
		}
		
		return userEmailMap.get(email);
	}
	
	/**
	 * @param passwd
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.UserLocalCache#getUserByPasswd(java.lang.String)
	 */
	@Override
	public UserInfo getUserByPasswd(String passwd) {
		
		if (userPasswdMap.isEmpty()) {
			refreshLocalCache();
		}
		
		return userPasswdMap.get(passwd);
	}
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.cache.LocalCache#initLocalCache()
	 */
	@Override
	public void initLocalCache() {
		
		synchronized (this) {
			
			List<DepreciateUserDO> users = depreciateUserDAO.loadAll();
			
			genAllUserMap(users);
			
			dump();
			
		}
	}
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.cache.LocalCache#refreshLocalCache()
	 */
	@Override
	public void refreshLocalCache() {
		initLocalCache();
	}
	
	/**
	 * @return
	 * @see com.peigen.web.depreciate.service.cache.LocalCache#getLocalCacheName()
	 */
	@Override
	public String getLocalCacheName() {
		return getLocalCacheEnum().code();
	}
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.cache.LocalCache#dump()
	 */
	@Override
	public void dump() {
		try {
			
			if (logger.isInfoEnabled()) {
				
				StringBuffer sb = new StringBuffer();
				
				sb.append(ENTERSTR + SEPARATOR + "开始输出缓存" + getLocalCacheName() + "信息" + SEPARATOR);
				
				sb.append(ENTERSTR + getLocalCacheEnum().message() + ":");
				if (userNameMap == null) {
					
					sb.append(ENTERSTR + "[" + getLocalCacheEnum().message() + "为空]");
					
				} else {
					
					sb.append(CacheMessageUtil.mapStringAndObject(userNameMap));
				}
				
				sb.append(ENTERSTR + SEPARATOR + "结束输出缓存" + getLocalCacheName() + "信息" + SEPARATOR);
				
				PrintLogTool.info(sb.toString(), logger);
			}
			
		} catch (Exception e) {
			logger.warn("本地缓存对象打印异常[" + getLocalCacheName() + "]：", e);
		}
	}
	
	private LocalCacheEnum getLocalCacheEnum() {
		return LocalCacheEnum.USER_CACHE;
	}
	
	/**
	 * 组装allPayChannelApiMap
	 * 
	 * @param users
	 */
	/**
	 * @param tmpAllUsers
	 * @param users
	 */
	private void genAllUserMap(List<DepreciateUserDO> users) {
		
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		UserConvertor.convert(userInfos, users);
		
		for (UserInfo _userInfo : userInfos) {
			userIdMap.put(String.valueOf(_userInfo.getId()), _userInfo);
			userNameMap.put(String.valueOf(_userInfo.getUserName()), _userInfo);
			userEmailMap.put(String.valueOf(_userInfo.getEmail()), _userInfo);
			userPasswdMap.put(String.valueOf(_userInfo.getUserPasswd()), _userInfo);
		}
		
	}
}
