/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.convert;

import java.util.List;

import com.peigen.common.lang.util.MoneyUtil;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductDO;
import com.peigen.web.depreciate.service.enums.ProductStatusEnum;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;

/**
 *                       
 * @Filename ProductConvertor.java
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
 *<li>Date: 2011-11-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductConvertor {
	
	public static void convert(ProductInfo productInfo, DepreciateProductDO product) {
		productInfo.setCategory(TrackCategoryEnum.getByCode(product.getTrackCategory()));
		productInfo.setId(product.getId());
		productInfo.setProductCurrentPrice(MoneyUtil.genMoney(product.getProductCurrentPrice()));
		productInfo.setProductName(product.getProductName());
		productInfo.setProductSerialNo(product.getProductSerialNo());
		productInfo.setStatus(ProductStatusEnum.getByCode(product.getStatus()));
		productInfo.setProductUrl(product.getProductUrl());
		productInfo.setRawAddTime(product.getRawAddTime());
		productInfo.setRawUpdateTime(product.getRawUpdateTime());
	}
	
	public static void convert(DepreciateProductDO product, ProductInfo productInfo) {
		product.setTrackCategory(productInfo.getCategory().code());
		product.setId(productInfo.getId());
		product.setProductCurrentPrice(productInfo.getProductCurrentPrice().getCent());
		product.setProductName(productInfo.getProductName());
		product.setProductSerialNo(productInfo.getProductSerialNo());
		product.setStatus(productInfo.getStatus().code());
		product.setProductUrl(productInfo.getProductUrl());
		product.setRawAddTime(productInfo.getRawAddTime());
		product.setRawUpdateTime(productInfo.getRawUpdateTime());
	}
	
	public static void convertInfos(List<ProductInfo> productInfos,
									List<DepreciateProductDO> products) {
		for (DepreciateProductDO _product : products) {
			ProductInfo productInfo = new ProductInfo();
			convert(productInfo, _product);
			productInfos.add(productInfo);
		}
		
	}
	
	public static void convertDOs(List<DepreciateProductDO> products, List<ProductInfo> productInfos) {
		
		for (ProductInfo _productInfo : productInfos) {
			DepreciateProductDO product = new DepreciateProductDO();
			convert(product, _productInfo);
			products.add(product);
		}
	}
}
