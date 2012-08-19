/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductPicDO;
import com.peigen.web.depreciate.service.convert.ProductPicConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.PicBucketInfo;
import com.peigen.web.depreciate.service.info.ProductPicInfo;
import com.peigen.web.depreciate.service.misc.image.PicBucketService;

/**
 *                       
 * @Filename ProductPicRepositoryImpl.java
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
public class ProductPicRepositoryImpl extends RepositoryBase implements ProductPicRepository {
	
	@Autowired
	private PicBucketService	picBucketService;
	
	/**
	 * @param productPicInfo
	 * @see com.peigen.web.depreciate.service.repository.ProductPicRepository#store(com.peigen.web.depreciate.service.info.ProductPicInfo)
	 */
	@Override
	public void store(ProductPicInfo productPicInfo) {
		
		DepreciateProductPicDO productPic = depreciateProductPicDAO.findByProductIdAndName(
			productPicInfo.getProductId(), productPicInfo.getPicName());
		
		if (productPic != null) {
			return;
		}
		
		productPic = new DepreciateProductPicDO();
		
		ProductPicConvertor.convert(productPic, productPicInfo);
		
		//		storePicToYupoo(productPicInfo);
		
		try {
			depreciateProductPicDAO.insert(productPic);
		} catch (DataAccessException e) {
			logger.error("", e);
			throw new DepreciateException(DepreciateResultEnum.SQL_EXCEPTION);
		}
		
	}
	
	// 存入云端存储
	@SuppressWarnings("unused")
	private void storePicToYupoo(ProductPicInfo productPicInfo) {
		PicBucketInfo bucket = new PicBucketInfo(productPicInfo.getProductId()
													+ DepreciateConstants.SEPARATOR_CHAR_HYPHEN
													+ productPicInfo.getPicName(), null,
			productPicInfo.getCategory(), productPicInfo.getProductId(),
			productPicInfo.getPicSourceUrl());
		picBucketService.addPic(bucket);
	}
	
}
