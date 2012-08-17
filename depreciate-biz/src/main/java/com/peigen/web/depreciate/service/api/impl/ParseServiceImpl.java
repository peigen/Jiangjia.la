/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.api.ParseService;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.parse.DangdangParse;
import com.peigen.web.depreciate.service.parse.M18Parse;
import com.peigen.web.depreciate.service.parse.MbaobaoParse;
import com.peigen.web.depreciate.service.parse.OkbuyParse;
import com.peigen.web.depreciate.service.parse.VipshopParse;

/**
 *                       
 * @Filename ParseServiceImpl.java
 *
 * @Description 专门用于解析网站类型的类
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ParseServiceImpl implements ParseService {
	
	private final Logger	logger	= LoggerFactory.getLogger(getClass());
	
	/**
	 * @param productUrl
	 * @return
	 * @see com.peigen.web.depreciate.service.api.ParseService#parse(java.lang.String)
	 */
	@Override
	public ProductInfo parse(String productUrl) {
		
		ProductInfo productInfo = null;
		
		PrintLogTool.info("开始解析URL[URL=" + productUrl + "]", logger);
		
		if (StringUtil.isBlank(productUrl)) {
			return productInfo;
		}
		
		TrackCategoryEnum category = parseCategory(productUrl);
		
		if (category == TrackCategoryEnum.MBAOBAO) {
			productInfo = MbaobaoParse.parse(productUrl);
		}
		
		if (category == TrackCategoryEnum.M18) {
			productInfo = M18Parse.parse(productUrl);
		}
		
		if (category == TrackCategoryEnum.DANGDANG) {
			productInfo = DangdangParse.parse(productUrl);
		}
		
		if (category == TrackCategoryEnum.OKBUY) {
			productInfo = OkbuyParse.parse(productUrl);
		}
		
		if (category == TrackCategoryEnum.VIPSHOP) {
			productInfo = VipshopParse.parse(productUrl);
		}
		
		productInfo.setProductUrl(productUrl);
		
		PrintLogTool.info("解析完毕", logger);
		
		return productInfo;
	}
	
	public TrackCategoryEnum parseCategory(String url) {
		TrackCategoryEnum category = null;
		
		if (StringUtil.contains(url, "dangdang.com/")) {
			category = TrackCategoryEnum.DANGDANG;
		}
		
		if (StringUtil.contains(url, "mbaobao.com/")) {
			category = TrackCategoryEnum.MBAOBAO;
		}
		
		if (StringUtil.contains(url, "m18.com/")) {
			category = TrackCategoryEnum.M18;
		}
		
		if (StringUtil.contains(url, "vipshop.com/")) {
			category = TrackCategoryEnum.M18;
		}
		
		if (StringUtil.contains(url, "okbuy.com/")) {
			category = TrackCategoryEnum.M18;
		}
		
		return category;
	}
	
}
