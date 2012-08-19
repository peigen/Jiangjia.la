/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserAttentionDO;
import com.peigen.web.depreciate.service.DepreciateServiceBase;
import com.peigen.web.depreciate.service.convert.UserAttentionConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.UserAttentionInfo;
import com.peigen.web.depreciate.service.query.ProductQueryService;
import com.peigen.web.depreciate.service.query.UserAttentionQueryService;
import com.peigen.web.depreciate.service.result.BatchProductResult;
import com.peigen.web.depreciate.service.result.BatchUserAttentionResult;

/**
 *                       
 * @Filename UserAttentionQueryServiceImpl.java
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
 *<li>Date: 2011-11-23</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserAttentionQueryServiceImpl extends DepreciateServiceBase implements
																		UserAttentionQueryService {
	
	@Autowired
	private ProductQueryService	productQueryService;
	
	/**
	 * @param userId
	 * @return
	 * @see com.peigen.web.depreciate.service.query.UserAttentionQueryService#loadUserAttentions(java.lang.String)
	 */
	@Override
	public BatchUserAttentionResult loadUserAttentions(String userId) {
		
		BatchUserAttentionResult result = new BatchUserAttentionResult();
		
		if (StringUtil.isBlank(userId)) {
			
			result.setResultCode(DepreciateResultEnum.INCOMPLETE_REQ_PARAM);
			return result;
		}
		
		List<DepreciateUserAttentionDO> userAttentions = null;
		try {
			userAttentions = depreciateUserAttentionDAO.findByUserId(userId);
		} catch (DataAccessException e) {
			logger.error("", e);
			result.setSuccess(false);
			result.setResultCode(DepreciateResultEnum.SQL_EXCEPTION);
		}
		
		result.setSuccess(true);
		
		if (userAttentions != null && !userAttentions.isEmpty()) {
			
			List<String> productIds = genProductIds(userAttentions);
			
			BatchProductResult batchProductResult = productQueryService.findProductById(productIds);
			
			if (batchProductResult.isExecuted() && batchProductResult.isSuccess()) {
				for (DepreciateUserAttentionDO _userAttention : userAttentions) {
					UserAttentionInfo userAttentionInfo = new UserAttentionInfo();
					
					UserAttentionConvertor.convert(
						userAttentionInfo,
						_userAttention,
						getProductInfo(batchProductResult.getProductInfos(),
							_userAttention.getUserAttentionProductId()));
					
					result.getUserAttentions().add(userAttentionInfo);
				}
				
			}
			
			result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
			
			return result;
		}
		
		result.setResultCode(DepreciateResultEnum.HAVE_NOT_DATA_EXCEPTION);
		return result;
	}
	
	// 内部方法
	private List<String> genProductIds(List<DepreciateUserAttentionDO> userAttentions) {
		List<String> productIds = new ArrayList<String>();
		
		for (DepreciateUserAttentionDO _userAttention : userAttentions) {
			productIds.add(_userAttention.getUserAttentionProductId());
		}
		
		return productIds;
	}
	
	private ProductInfo getProductInfo(List<ProductInfo> productInfos, String productId) {
		
		for (ProductInfo _productInfo : productInfos) {
			
			if (StringUtil.equals(productId, _productInfo.getId())) {
				return _productInfo;
			}
			
		}
		
		return null;
	}
}
