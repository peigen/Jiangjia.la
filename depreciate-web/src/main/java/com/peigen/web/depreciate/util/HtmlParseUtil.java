/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.util;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *                       
 * @Filename HtmlParseUtil.java
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
 *<li>Date: 2011-11-9</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class HtmlParseUtil {
	
	public static void main(String[] args) throws IOException {
		
		mbbPage();
		
		ddPage();
		
		m18Page();
	}
	
	public static void mbbPage() throws IOException {
		
		String mbaobaoURL = "http://item.mbaobao.com/pshow-1108000903.html?l=hc-r";
		Document mbbDoc = Jsoup.parse(new URL(mbaobaoURL), 20000);
		
		Elements elements = mbbDoc.select("li.goods-number").select("div");
		
		for (Element element : elements) {
			System.out.println("麦包包商品编号：" + element.childNode(0));
		}
		
		elements = mbbDoc.select("li.goods-mb-price").select("span.g-p-n");
		
		for (Element element : elements) {
			System.out.println("麦包包当前价格：" + element.childNode(1));
		}
		
	}
	
	public static void ddPage() throws IOException {
		
		//		String ddURL = "http://product.dangdang.com/product.aspx?product_id=20754996";
		String ddURL = "http://product.dangdang.com/product.aspx?product_id=20754996";
		
		Document ddDoc = Jsoup.parse(new URL(ddURL), 20000);
		
		Elements elements = ddDoc.select("#sumpriceDiv");
		for (Element element : elements) {
			System.out.println("当当网当前价格：" + element.childNode(0));
		}
	}
	
	public static void m18Page() throws IOException {
		
		String m18URL = "http://product.m18.com/p-F118420.htm";
		Document m18Doc = Jsoup.parse(new URL(m18URL), 20000);
		
		Elements elements = m18Doc.select("#styleId");
		
		for (Element element : elements) {
			System.out.println("麦考林商品编号：" + element.childNode(0));
		}
		
		elements = m18Doc.select("#stylePrice");
		for (Element element : elements) {
			System.out.println("麦考林当前价格：" + element.childNode(0));
		}
	}
}
