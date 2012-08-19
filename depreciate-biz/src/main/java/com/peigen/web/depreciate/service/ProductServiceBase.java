/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.order.Order;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename ProductServiceBase.java
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
 *<li>Date: 2011-11-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductServiceBase extends DepreciateServiceBase {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ProductResult addProduct(final Order order, final InvokeService invoke,
									final InvokeRepositService invokeReposit) {
		
		long serviceStart = System.currentTimeMillis();
		
		ProductResult result = new ProductResult();
		
		try {
			result = (ProductResult) transactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus status) {
					
					ProductResult result = new ProductResult();
					
					ProductInfo productInfo = null;
					
					try {
						//===================================================> 
						// step1:单据检查
						//===================================================>
						checkOrder(order);
						
						//===================================================> 
						// step2:业务处理
						//===================================================>
						productInfo = invoke.invoke(order, productInfo);
						
						//===================================================> 
						// step3:持久化
						//===================================================>
						
						// 商品
						productRepository.store(productInfo);
						
						invokeReposit.store(productInfo);
						
						//===================================================> 
						// step4:打印摘要日志
						//===================================================>
						printDigest(productInfo);
						
						//===================================================> 
						// step5:结果处理
						//===================================================>
						result.setSuccess(true);
						result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
						result.setProductInfo(productInfo);
						
					} catch (DepreciateException e) {
						logger.error("处理异常[order=" + order + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(e.getCode());
					} catch (Exception e) {
						logger.error("处理异常[order=" + order + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(DepreciateResultEnum.UN_KNOWN_EXCEPTION);
					}
					
					return result;
					
				}
				
			});
		} catch (Exception exception) {
			
		} finally {
			
			//清空上下文
			
		}
		
		long serviceEnd = System.currentTimeMillis();
		PrintLogTool.info("本次服务调用耗时：" + (serviceEnd - serviceStart) + "ms", logger);
		return result;
	}
}
