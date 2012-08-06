/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.parse;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.parse.DangdangParse;
import com.peigen.web.depreciate.service.parse.M18Parse;
import com.peigen.web.depreciate.service.parse.MbaobaoParse;
import com.peigen.web.depreciate.service.parse.OkbuyParse;
import com.peigen.web.depreciate.service.parse.RedbabyParse;
import com.peigen.web.depreciate.service.parse.VipshopParse;

/**
 *                       
 * @Filename MbaobaoParseTest.java
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
public class ParseTest extends TestCase {
	
	private Logger	logger		= LoggerFactory.getLogger(getClass());
	
	private String	mbaobaoURL	= "http://item.mbaobao.com/pshow-1108000903.html?l=hc-r";
	private String	m18URl		= "http://product.m18.com/p-QD190037.htm";
	private String	dangdangURL	= "http://product.dangdang.com/product.aspx?product_id=60111695&ref=cms";
	private String	okbuyUrl	= "http://www.okbuy.com/product/detail/16943132.html";
	private String	vipshopUrl	= "http://www.vipshop.com/detail-1222410-0-0.html";
	private String	redBabyUrl	= "http://www.redbaby.com.cn/wanju/10403041216825.html";
	
	public void testMbaobaoParse() {
		ProductInfo product = MbaobaoParse.parse(mbaobaoURL);
		PrintLogTool.info(product.toString(), logger);
	}
	
	public void testM18Parse() {
		ProductInfo product = M18Parse.parse(m18URl);
		PrintLogTool.info(product.toString(), logger);
	}
	
	public void testDangdangParse() {
		ProductInfo product = DangdangParse.parse(dangdangURL);
		PrintLogTool.info(product.toString(), logger);
	}
	
	public void testOkbuyParse() {
		ProductInfo product = OkbuyParse.parse(okbuyUrl);
		PrintLogTool.info(product.toString(), logger);
	}
	
	public void testVipshopParse() {
		ProductInfo product = VipshopParse.parse(vipshopUrl);
		PrintLogTool.info(product.toString(), logger);
	}
	
	public void testRedbabyParse() {
		ProductInfo product = RedbabyParse.parse(redBabyUrl);
		PrintLogTool.info(product.toString(), logger);
	}
}
