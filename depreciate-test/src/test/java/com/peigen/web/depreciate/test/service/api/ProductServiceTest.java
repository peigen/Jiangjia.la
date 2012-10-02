/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.api;

import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.result.ProductResult;
import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename ProductServiceTest.java
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
 *<li>Date: 2011-11-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductServiceTest extends DepreciateServiceTestBase {
	
	private String	m18_test_url	= "http://product.m18.com/p-7112705.htm";
	
	@SuppressWarnings("unused")
	private String	dang_test_url	= "http://product.dangdang.com/Product.aspx?product_id=1260888102#ref=www-0-D";
	
	private String	mbb_test_url	= "http://www.mbaobao.com/item/1305000502";
	
	@DepreciateTestAnnotated(description = "添加商品测试用例---成功用例")
	public void testAddProduct() {
		
		cleanProduct();
		
		// 麦包包
		mbb();
		// 麦考林
		//		m18();
		//		// 当当
		//		dangdang();
	}
	
	private void mbb() {
		ProductOrder mbaobaoOrder = genProductOrder();
		mbaobaoOrder.setUrl(mbb_test_url);
		ProductResult result = productService.addProduct(mbaobaoOrder);
		
		assertResult(result);
	}
	
	private void m18() {
		ProductOrder m18Order = genProductOrder();
		m18Order.setUrl(m18_test_url);
		ProductResult result = productService.addProduct(m18Order);
		
		assertResult(result);
	}
	
	private void dangdang() {
		ProductOrder dangdangOrder = genProductOrder();
		dangdangOrder.setUrl(dang_test_url);
		ProductResult result = productService.addProduct(dangdangOrder);
		assertResult(result);
		
	}
}
