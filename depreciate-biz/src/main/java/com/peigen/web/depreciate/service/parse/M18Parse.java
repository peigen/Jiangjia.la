/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.parse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename M18Parse.java
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
 *<li>Date: 2011-11-12</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class M18Parse extends ParseBase {
	
	private static Document					doc			= null;
	private final static TrackCategoryEnum	category	= TrackCategoryEnum.M18;
	
	/**
	 * @param url
	 * @return
	 */
	public static ProductInfo parse(String url) {
		ProductInfo productInfo = new ProductInfo();
		
		PrintLogTool.info("开始解析" + category.message() + "[URL=" + url + "]", logger);
		
		// 商品类型
		productInfo.setCategory(category);
		
		try {
			doc = Jsoup.parse(new URL(url), 20000);
		} catch (MalformedURLException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		// 商品编号
		setSerialNo(productInfo);
		
		// 当前价格
		setCurrentPrice(productInfo);
		
		// 商品名称
		setProductName(productInfo);
		
		// 商品图片
		setProductPic(productInfo);
		
		return productInfo;
	}
	
	// 内部方法
	private static void setSerialNo(ProductInfo productInfo) {
		
		Elements elements = doc.select("#styleId");
		
		String productSerialNo = elements.get(0).childNode(0).toString();
		
		productInfo.setProductSerialNo(productSerialNo);
		
		PrintLogTool.info(category.message() + "商品编号：[" + productSerialNo + "]", logger);
	}
	
	private static void setCurrentPrice(ProductInfo productInfo) {
		
		Elements elements = doc.select("#stylePrice");
		
		Money productCurrentPrice = new Money(elements.get(0).childNode(0).toString());
		
		productInfo.setProductCurrentPrice(productCurrentPrice);
		
		PrintLogTool.info(category.message() + "当前价格：[" + productCurrentPrice + "]", logger);
	}
	
	private static void setProductName(ProductInfo productInfo) {
		String productName = doc.title();
		productInfo.setProductName(productName);
		PrintLogTool.info(category.message() + "商品名称：[" + productName + "]", logger);
	}
	
	private static void setProductPic(ProductInfo productInfo) {
		
		List<ProductPicInfo> productPicInfos = new ArrayList<ProductPicInfo>();
		
		Elements elements = doc.select("ul.thumbpic > li");
		
		for (Element _element : elements) {
			String url = _element.select("a").attr("href").toString();
			
			ProductPicInfo productPicInfo = PicParse.parse(url);
			
			productPicInfos.add(productPicInfo);
		}
		
		productInfo.setProductPicInfos(productPicInfos);
		
		PrintLogTool.info(category.message() + "图片地址：[" + productPicInfos + "]", logger);
	}
}
