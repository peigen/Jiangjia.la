/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import org.springframework.dao.DataAccessException;

import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserAttentionDO;
import com.peigen.web.depreciate.service.convert.UserAttentionConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.UserAttentionInfo;

/**
 *                       
 * @Filename UserAttentionRepositoryImpl.java
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
 *<li>Date: 2011-11-23</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserAttentionRepositoryImpl extends RepositoryBase implements UserAttentionRepository {
	
	/**
	 * @param userAttention
	 * @see com.peigen.web.depreciate.service.repository.UserAttentionRepository#store(com.peigen.web.depreciate.service.info.UserAttentionInfo)
	 */
	@Override
	public void store(UserAttentionInfo userAttentionInfo) {
		
		DepreciateUserAttentionDO userAttention = depreciateUserAttentionDAO
			.findByUserIdAndProductId(userAttentionInfo.getUserId(), userAttentionInfo
				.getProductInfo().getId());
		
		if (userAttention != null) {
			
			depreciateUserAttentionDAO.updateForId(userAttentionInfo.getProductInfo().getId(),
				userAttentionInfo.getProductAliasName(), userAttentionInfo.getStatus().code(),
				userAttention.getId());
			return;
		}
		
		userAttention = new DepreciateUserAttentionDO();
		UserAttentionConvertor.convert(userAttention, userAttentionInfo);
		
		try {
			depreciateUserAttentionDAO.insert(userAttention);
		} catch (DataAccessException e) {
			logger.error("", e);
			throw new DepreciateException(DepreciateResultEnum.SQL_EXCEPTION);
		}
		
	}
}
