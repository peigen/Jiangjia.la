/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.parse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peigen.common.lang.util.HttpRequestParser;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename DangdangParse.java
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
 *<li>Date: 2011-11-18</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DangdangParse extends ParseBase {
	
	private static Document					doc			= null;
	private final static TrackCategoryEnum	category	= TrackCategoryEnum.DANGDANG;
	
	/**
	 * @param url
	 * @return
	 */
	public static ProductInfo parse(String url) {
		ProductInfo productInfo = new ProductInfo();
		
		PrintLogTool.info("开始解析" + category.message() + "[URL=" + url + "]", logger);
		
		try {
			doc = Jsoup.parse(new URL(url), 20000);
		} catch (MalformedURLException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		// 商品编号
		setSerialNo(productInfo, url);
		
		// 当前价格
		setCurrentPrice(productInfo);
		
		// 商品名称
		setProductName(productInfo);
		
		// 商品类型
		productInfo.setCategory(category);
		
		// 商品图片
		setProductPic(productInfo);
		
		return productInfo;
	}
	
	// 内部方法
	private static void setSerialNo(ProductInfo product, String url) {
		
		HttpServletRequest request = HttpRequestParser.parse(url);
		
		String productSerialNo = request.getParameter("product_id");
		
		product.setProductSerialNo(productSerialNo);
		
		PrintLogTool.info(category.message() + "商品编号：[" + productSerialNo + "]", logger);
	}
	
	private static void setCurrentPrice(ProductInfo product) {
		
		Elements elements = doc.select("#salePriceTag");
		
		String currentPriceStr = elements.get(0).childNode(0).toString();
		
		currentPriceStr = StringUtil.replaceOnce(currentPriceStr, "￥", "");
		
		Money productCurrentPrice = new Money(currentPriceStr);
		
		product.setProductCurrentPrice(productCurrentPrice);
		
		PrintLogTool.info(category.message() + "当前价格：[" + productCurrentPrice + "]", logger);
	}
	
	private static void setProductName(ProductInfo product) {
		
		String productName = doc.title();
		product.setProductName(productName);
		PrintLogTool.info(category.message() + "商品名称：[" + productName + "]", logger);
	}
	
	private static void setProductPic(ProductInfo productInfo) {
		List<ProductPicInfo> productPicInfos = new ArrayList<ProductPicInfo>();
		
		Elements elements = doc.select("#pic_carousel > ul > li");
		
		for (Element _element : elements) {
			String url = _element.select("a").attr("id").toString();
			
			ProductPicInfo productPicInfo = PicParse.parse(url);
			
			productPicInfos.add(productPicInfo);
		}
		
		productInfo.setProductPicInfos(productPicInfos);
		
		PrintLogTool.info(category.message() + "图片地址：[" + productPicInfos + "]", logger);
	}
}
