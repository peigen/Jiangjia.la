/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.convert;

import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserAttentionDO;
import com.peigen.web.depreciate.service.enums.AttentionStatusEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.UserAttentionInfo;

/**
 *                       
 * @Filename UserAttentionConvertor.java
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
public class UserAttentionConvertor {
	
	public static void convert(UserAttentionInfo userAttentionInfo,
								DepreciateUserAttentionDO userAttention, ProductInfo productInfo) {
		userAttentionInfo.setId(userAttention.getId());
		userAttentionInfo.setRawAddTime(userAttention.getRawAddTime());
		userAttentionInfo.setRawUpdateTime(userAttention.getRawUpdateTime());
		userAttentionInfo.setStatus(AttentionStatusEnum.getByCode(userAttention.getStatus()));
		userAttentionInfo.setUserId(userAttention.getUserId());
		userAttentionInfo.setProductAliasName(userAttention.getProductAliasName());
		
		// productInfo
		userAttentionInfo.setProductInfo(productInfo);
	}
	
	public static void convert(DepreciateUserAttentionDO userAttention,
								UserAttentionInfo userAttentionInfo) {
		userAttention.setId(userAttentionInfo.getId());
		userAttention.setRawAddTime(userAttentionInfo.getRawAddTime());
		userAttention.setRawUpdateTime(userAttentionInfo.getRawUpdateTime());
		userAttention.setStatus(userAttentionInfo.getStatus().code());
		userAttention.setUserAttentionProductId(userAttentionInfo.getProductInfo().getId());
		userAttention.setUserId(userAttentionInfo.getUserId());
		userAttention.setProductAliasName(userAttentionInfo.getProductAliasName());
	}
	
}
