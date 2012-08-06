/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductDO;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductPicDO;
import com.peigen.web.depreciate.service.convert.ProductConvertor;
import com.peigen.web.depreciate.service.convert.ProductPicConvertor;
import com.peigen.web.depreciate.service.info.ProductChangeLogInfo;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename ProductRepositoryImpl.java
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
 *<li>Date: 2011-11-14</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductRepositoryImpl extends RepositoryBase implements ProductRepository {
	
	@Autowired
	private ProductPicRepository			productPicRepository;
	
	@Autowired
	protected ProductChangeLogRepository	productChangeLogRepository;
	
	/**
	 * @param productInfo
	 * @see com.peigen.web.depreciate.service.repository.ProductRepository#store(com.peigen.web.depreciate.service.info.ProductInfo)
	 */
	@Override
	public void store(ProductInfo productInfo) {
		
		PrintLogTool.info("存入商品数据[productInfo=" + productInfo + "]", logger);
		
		// 查询是否已存在
		DepreciateProductDO product = depreciateProductDAO.findBySerialNoAndCategory(productInfo
			.getCategory().code(), productInfo.getProductSerialNo());
		
		if (product == null) {
			product = new DepreciateProductDO();
			
			ProductConvertor.convert(product, productInfo);
			
			depreciateProductDAO.insert(product);
			
			// 商品变更记录
			productChangeLogRepository.store(genChangeLog(productInfo));
			
			// pic
			storeProductPic(productInfo);
			return;
		}
		
		ProductConvertor.convert(productInfo, product);
		
		// 补全
		fillInProductInfo(productInfo);
		
	}
	
	/**
	 * @param productInfo
	 * @see com.peigen.web.depreciate.service.repository.ProductRepository#reStore(com.peigen.web.depreciate.service.info.ProductInfo)
	 */
	@Override
	public void reStore(ProductInfo productInfo) {
		
		PrintLogTool.info("更新商品数据[productInfo=" + productInfo + "]", logger);
		
		DepreciateProductDO product = new DepreciateProductDO();
		
		ProductConvertor.convert(product, productInfo);
		
		depreciateProductDAO.updateForId(product);
		
		// 商品变更记录
		Money currentAmount = productInfo.getProductCurrentPrice();
		ProductChangeLogInfo changeLogInfo = genChangeLog(productInfo);
		changeLogInfo.setProductCurrentPrice(currentAmount);
		productChangeLogRepository.store(changeLogInfo);
	}
	
	/**
	 * @param productId
	 * @return
	 * @see com.peigen.web.depreciate.service.repository.ProductRepository#active(java.lang.String)
	 */
	@Override
	public ProductInfo active(String productId) {
		
		PrintLogTool.info("激活商品[productId=" + productId + "]", logger);
		
		DepreciateProductDO product = depreciateProductDAO.selectForUpdate(productId);
		
		if (product != null) {
			ProductInfo productInfo = new ProductInfo();
			ProductConvertor.convert(productInfo, product);
		}
		
		return null;
	}
	
	// 内部方法
	/**
	 * 存储图片
	 * 
	 * @param productInfo
	 */
	private void storeProductPic(ProductInfo productInfo) {
		
		List<ProductPicInfo> productPics = productInfo.getProductPicInfos();
		
		if (productPics != null && !productPics.isEmpty()) {
			
			for (ProductPicInfo _productPicInfo : productPics) {
				
				_productPicInfo.setProductId(productInfo.getId());
				_productPicInfo.setRawAddTime(productInfo.getRawAddTime());
				_productPicInfo.setCategory(productInfo.getCategory());
				productPicRepository.store(_productPicInfo);
			}
		}
		
	}
	
	private void fillInProductInfo(ProductInfo productInfo) {
		List<DepreciateProductPicDO> productPics = depreciateProductPicDAO
			.loadByProductId(productInfo.getId());
		
		List<ProductPicInfo> productPicInfos = new ArrayList<ProductPicInfo>();
		ProductPicConvertor.convertInfos(productPicInfos, productPics);
		
		productInfo.setProductPicInfos(productPicInfos);
	}
	
	private ProductChangeLogInfo genChangeLog(ProductInfo productInfo) {
		ProductChangeLogInfo changeLogInfo = new ProductChangeLogInfo();
		changeLogInfo.setProductChangePrice(productInfo.getProductCurrentPrice());
		changeLogInfo.setProductCurrentPrice(productInfo.getProductCurrentPrice());
		changeLogInfo.setProductId(productInfo.getId());
		
		return changeLogInfo;
	}
}
