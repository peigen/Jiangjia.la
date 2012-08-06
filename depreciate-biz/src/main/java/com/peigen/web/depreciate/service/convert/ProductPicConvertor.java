/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.convert;

import java.util.List;

import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductPicDO;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename ProductPicConvertor.java
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
 *<li>Date: 2011-11-24</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductPicConvertor {
	
	public static void convert(ProductPicInfo productPicInfo, DepreciateProductPicDO productPic) {
		productPicInfo.setId(productPic.getId());
		productPicInfo.setPicName(productPic.getPicName());
		productPicInfo.setCategory(TrackCategoryEnum.getByCode(productPic.getTrackCategory()));
		productPicInfo.setPicSourceUrl(productPic.getPicSourceUrl());
		productPicInfo.setProductId(productPic.getProductId());
		productPicInfo.setRawAddTime(productPic.getRawAddTime());
		productPicInfo.setRawUpdateTime(productPic.getRawUpdateTime());
	}
	
	public static void convert(DepreciateProductPicDO productPic, ProductPicInfo productPicInfo) {
		productPic.setId(productPicInfo.getId());
		productPic.setPicName(productPicInfo.getPicName());
		productPic.setTrackCategory(productPicInfo.getCategory().code());
		productPic.setPicSourceUrl(productPicInfo.getPicSourceUrl());
		productPic.setProductId(productPicInfo.getProductId());
		productPic.setRawAddTime(productPicInfo.getRawAddTime());
		productPic.setRawUpdateTime(productPicInfo.getRawUpdateTime());
	}
	
	public static void convertInfos(List<ProductPicInfo> productPicInfos,
									List<DepreciateProductPicDO> productPics) {
		for (DepreciateProductPicDO _productPic : productPics) {
			ProductPicInfo productPicInfo = new ProductPicInfo();
			convert(productPicInfo, _productPic);
			productPicInfos.add(productPicInfo);
		}
		
	}
	
	public static void convertDOs(List<DepreciateProductPicDO> productPics,
									List<ProductPicInfo> productPicInfos) {
		
		for (ProductPicInfo _productPicInfo : productPicInfos) {
			DepreciateProductPicDO productPic = new DepreciateProductPicDO();
			convert(productPic, _productPicInfo);
			productPics.add(productPic);
		}
	}
}
