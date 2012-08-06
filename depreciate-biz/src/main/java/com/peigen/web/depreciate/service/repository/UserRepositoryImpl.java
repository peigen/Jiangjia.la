/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import org.springframework.dao.DuplicateKeyException;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserDO;
import com.peigen.web.depreciate.service.convert.UserConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename UserRepositoryImpl.java
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
public class UserRepositoryImpl extends RepositoryBase implements UserRepository {
	
	/**
	 * @param userInfo
	 * @see com.peigen.web.depreciate.service.repository.UserRepository#store(com.peigen.web.depreciate.service.info.UserInfo)
	 */
	@Override
	public void store(UserInfo userInfo) {
		
		PrintLogTool.info("持久化用户数据[user=" + userInfo + "]", logger);
		
		DepreciateUserDO user = new DepreciateUserDO();
		UserConvertor.convert(user, userInfo);
		
		try {
			depreciateUserDAO.insert(user);
		} catch (DuplicateKeyException e) {
			
			PrintLogTool.info("用户已存在[userName=" + userInfo.getUserName() + "]", logger);
			throw new DepreciateException(DepreciateResultEnum.DEPRECIATE_DUPLICATE_EXCEPTION);
		}
	}
	
}
