/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.helper.StringUtil;

import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductPicDO;
import com.peigen.web.depreciate.service.DepreciateServiceBase;
import com.peigen.web.depreciate.service.convert.ProductPicConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.enums.ProductPicQualityEnum;
import com.peigen.web.depreciate.service.info.ProductPicInfo;
import com.peigen.web.depreciate.service.query.ProductPicQueryService;
import com.peigen.web.depreciate.service.result.BatchProductPicResult;

/**
 *                       
 * @Filename ProductPicQueryServiceImpl.java
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
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductPicQueryServiceImpl extends DepreciateServiceBase implements
																		ProductPicQueryService {
	
	private final String	lowPicBucketUrl		= "http://pic_low.b0.upaiyun.com/";
	private final String	midPicBucketUrl		= "http://pic_mid.b0.upaiyun.com/";
	private final String	highPicBucketUrl	= "http://pic_high.b0.upaiyun.com/";
	
	/**
	 * @param productId
	 * @return
	 * @see com.peigen.web.depreciate.service.query.ProductPicQueryService#loadProductPicsByProductId(java.lang.String)
	 */
	@Override
	public BatchProductPicResult loadProductPicsByProductId(String productId) {
		
		PrintLogTool.info("收到根据商品ID批量查询[productId=" + productId + "]", logger);
		
		BatchProductPicResult result = new BatchProductPicResult();
		
		if (StringUtil.isBlank(productId)) {
			result.setSuccess(true);
			result.setResultCode(DepreciateResultEnum.INCOMPLETE_REQ_PARAM);
			return result;
		}
		
		List<DepreciateProductPicDO> productPics = depreciateProductPicDAO
			.loadByProductId(productId);
		
		if (productPics == null || productPics.isEmpty()) {
			
			result.setSuccess(true);
			result.setResultCode(DepreciateResultEnum.HAVE_NOT_DATA_EXCEPTION);
			return result;
		}
		
		List<ProductPicInfo> productPicInfos = new ArrayList<ProductPicInfo>();
		for (DepreciateProductPicDO _productPic : productPics) {
			ProductPicInfo productPicInfo = new ProductPicInfo();
			ProductPicConvertor.convert(productPicInfo, _productPic);
			fillInPicPath(productPicInfo, ProductPicQualityEnum.HIGH);
			productPicInfos.add(productPicInfo);
		}
		
		result.setProductPicInfos(productPicInfos);
		result.setSuccess(true);
		result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
		
		PrintLogTool.info("收到根据商品ID批量查询结果[result{success=" + result.isSuccess() + ",resultCode="
							+ result.getResultCode() + "},result.size="
							+ result.getProductPicInfos().size() + ",productId=" + productId + "]",
			logger);
		
		return result;
	}
	
	private void fillInPicPath(ProductPicInfo productPicInfo, ProductPicQualityEnum quality) {
		
		String picPath = productPicInfo.getCategory().code()
							+ DepreciateConstants.SEPARATOR_CHAR_SLASH
							+ productPicInfo.getProductId()
							+ DepreciateConstants.SEPARATOR_CHAR_HYPHEN
							+ productPicInfo.getPicName();
		switch (quality) {
			case LOW:
				picPath = lowPicBucketUrl + picPath;
				break;
			
			case MID:
				picPath = midPicBucketUrl + picPath;
				break;
			
			case HIGH:
				picPath = highPicBucketUrl + picPath;
				break;
			
			default:
				picPath = highPicBucketUrl + picPath;
				break;
		
		}
		productPicInfo.setPicUrl(picPath);
		
	}
}
