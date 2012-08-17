/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.peigen.common.lang.util.HttpRequestParser;

/**
 *                       
 * @Filename HtmlParse.java
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
public class HtmlParse {
	public static void main(String[] args) throws IOException {
		
		mbbPage();
		
		System.out.println("\n");
		ddPage();
		
		System.out.println("\n");
		m18Page();
	}
	
	public static void mbbPage() throws IOException {
		
		String mbaobaoURL = "http://item.mbaobao.com/pshow-1108000903.html?l=hc-r";
		Document mbbDoc = Jsoup.parse(new URL(mbaobaoURL), 20000);
		
		Elements elements = mbbDoc.select("li.goods-number").select("div");
		
		System.out.println("麦包包商品编号：[" + elements.get(0).childNode(0) + "]");
		
		elements = mbbDoc.select("li.goods-mb-price").select("span.g-p-n");
		
		System.out.println("麦包包当前价格：[" + elements.get(0).childNode(1) + "]");
		
	}
	
	public static void ddPage() throws IOException {
		
		//		String ddURL = "http://product.dangdang.com/product.aspx?product_id=20754996";
		String ddURL = "http://product.dangdang.com/product.aspx?product_id=1262418002#ref=www-0-H";
		
		Document ddDoc = Jsoup.parse(new URL(ddURL), 20000);
		
		Elements elements = ddDoc.select("#salePriceTag");
		for (Element element : elements) {
			System.out.println("当当网当前价格：[" + element.childNode(0) + "]");
		}
		
		System.out.println("///////////////////////");
		HttpServletRequest request = HttpRequestParser.parse(ddURL);
		
		System.out.println("full URL:     " + ddURL);
		System.out.println("request URL:  " + request.getRequestURL());
		System.out.println("id:           " + request.getParameter("product_id"));
	}
	
	public static void m18Page() throws IOException {
		
		String m18URL = "http://product.m18.com/p-F118420.htm";
		Document m18Doc = Jsoup.parse(new URL(m18URL), 20000);
		
		Elements elements = m18Doc.select("#styleId");
		
		for (Element element : elements) {
			System.out.println("麦考林商品编号：[" + element.childNode(0) + "]");
		}
		
		elements = m18Doc.select("#stylePrice");
		for (Element element : elements) {
			System.out.println("麦考林当前价格：[" + element.childNode(0) + "]");
		}
	}
}
