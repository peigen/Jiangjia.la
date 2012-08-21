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
import com.peigen.common.lang.util.StringUtil;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename MbaobaoParse.java
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
public class MbaobaoParse extends ParseBase {
	
	private static Document	doc	= null;
	
	/**
	 * @param url
	 * @return
	 */
	public static ProductInfo parse(String url) {
		ProductInfo productInfo = new ProductInfo();
		
		PrintLogTool.info("开始解析" + TrackCategoryEnum.MBAOBAO.message() + "[URL=" + url + "]",
			logger);
		
		try {
			doc = Jsoup.parse(new URL(url), 20000);
		} catch (MalformedURLException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		}
		
		// 商品编号
		setSerialNo(productInfo, doc);
		
		// 当前价格
		setCurrentPrice(productInfo, doc);
		
		// 商品名称
		setProductName(productInfo, doc);
		
		// 商品类型
		productInfo.setCategory(TrackCategoryEnum.MBAOBAO);
		
		// 商品图片
		setProductPic(productInfo);
		
		return productInfo;
	}
	
	// 内部方法
	private static void setSerialNo(ProductInfo product, Document mbbDoc) {
		Elements elements = mbbDoc.select("div.goods-number");
		
		String productSerialNo = elements.get(0).childNode(0).toString();
		
		productSerialNo = StringUtil.replace(productSerialNo, "：", ":");
		productSerialNo = StringUtil.split(productSerialNo, ":")[1];
		
		product.setProductSerialNo(productSerialNo);
		PrintLogTool.info(TrackCategoryEnum.MBAOBAO.message() + "商品编号：" + productSerialNo, logger);
	}
	
	private static void setCurrentPrice(ProductInfo product, Document mbbDoc) {
		
		Elements elements = mbbDoc.select("div.goods-price").select("span.price-num");
		
		Money productCurrentPrice = new Money(elements.get(0).childNode(0).toString());
		product.setProductCurrentPrice(productCurrentPrice);
		
		PrintLogTool.info(TrackCategoryEnum.MBAOBAO.message() + "当前价格：" + productCurrentPrice,
			logger);
	}
	
	private static void setProductName(ProductInfo product, Document mbbDoc) {
		String productName = doc.title();
		product.setProductName(productName);
		PrintLogTool.info(TrackCategoryEnum.MBAOBAO.message() + "商品名称：[" + productName + "]",
			logger);
	}
	
	private static void setProductPic(ProductInfo productInfo) {
		List<ProductPicInfo> productPicInfos = new ArrayList<ProductPicInfo>();
		
		Elements elements = doc.select("div.picture-small-list>ul>li");
		
		for (Element _element : elements) {
			String url = _element.select("a").attr("href").toString();
			
			ProductPicInfo productPicInfo = PicParse.parse(url);
			
			productPicInfos.add(productPicInfo);
		}
		
		productInfo.setProductPicInfos(productPicInfos);
		
		PrintLogTool.info(TrackCategoryEnum.MBAOBAO.message() + "图片地址：[" + productPicInfos + "]",
			logger);
	}
}
