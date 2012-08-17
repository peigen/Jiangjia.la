/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.query.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductDO;
import com.peigen.web.depreciate.service.DepreciateServiceBase;
import com.peigen.web.depreciate.service.convert.ProductConvertor;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.query.ProductPicQueryService;
import com.peigen.web.depreciate.service.query.ProductQueryService;
import com.peigen.web.depreciate.service.result.BatchProductPicResult;
import com.peigen.web.depreciate.service.result.BatchProductResult;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename ProductQueryServiceImpl.java
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
public class ProductQueryServiceImpl extends DepreciateServiceBase implements ProductQueryService {
	
	@Autowired
	private ProductPicQueryService	productPicQueryService;
	
	/**
	 * @param productId
	 * @return
	 * @see com.peigen.web.depreciate.service.query.ProductQueryService#findProductById(java.lang.String)
	 */
	@Override
	public ProductResult findProductById(String productId) {
		return null;
	}
	
	/**
	 * @param productIds
	 * @return
	 * @see com.peigen.web.depreciate.service.query.ProductQueryService#findProductById(java.util.List)
	 */
	@Override
	public BatchProductResult findProductById(List<String> productIds) {
		
		PrintLogTool.info("收到根据商品Id批量查询[productIds=" + productIds + "]", logger);
		
		BatchProductResult result = new BatchProductResult();
		
		if (productIds == null || productIds.isEmpty()) {
			result.setSuccess(true);
			result.setResultCode(DepreciateResultEnum.INCOMPLETE_REQ_PARAM);
			return result;
		}
		
		List<DepreciateProductDO> products = extraDAO.loadByProductIds(productIds);
		
		result.setSuccess(true);
		if (products == null || products.isEmpty()) {
			
			result.setResultCode(DepreciateResultEnum.HAVE_NOT_DATA_EXCEPTION);
			return result;
		}
		
		for (DepreciateProductDO _product : products) {
			ProductInfo productInfo = new ProductInfo();
			
			ProductConvertor.convert(productInfo, _product);
			
			fillInProductPic(productInfo);
			
			result.getProductInfos().add(productInfo);
		}
		
		result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
		
		PrintLogTool.info("根据商品Id批量查询结果[result{success=" + result.isSuccess() + ",resultCode="
							+ result.getResultCode() + "},result.size="
							+ result.getProductInfos().size() + ",productIds=" + productIds + "]",
			logger);
		return result;
	}
	
	/**
	 * @param serialNo
	 * @param category
	 * @return
	 * @see com.peigen.web.depreciate.service.query.ProductQueryService#findProductBySerialNoAndCategory(java.lang.String, java.lang.String)
	 */
	@Override
	public ProductResult findProductBySerialNoAndCategory(String serialNo, String category) {
		return null;
	}
	
	/**
	 * @return
	 * @see com.peigen.web.depreciate.service.query.ProductQueryService#loadAll()
	 */
	@Override
	public BatchProductResult loadAll() {
		
		int limitStart = 0;
		int pageSize = 0;
		
		BatchProductResult result = new BatchProductResult();
		
		List<DepreciateProductDO> products = depreciateProductDAO.loadAllPageList(limitStart,
			pageSize);
		
		List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
		ProductConvertor.convertInfos(productInfos, products);
		
		result.setSuccess(true);
		result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
		result.setProductInfos(productInfos);
		
		return result;
	}
	
	// 内部方法
	
	private void fillInProductPic(ProductInfo productInfo) {
		BatchProductPicResult result = productPicQueryService
			.loadProductPicsByProductId(productInfo.getId());
		
		if (result.isSuccess() && result.isExecuted()) {
			productInfo.setProductPicInfos(result.getProductPicInfos());
		}
	}
	
}
