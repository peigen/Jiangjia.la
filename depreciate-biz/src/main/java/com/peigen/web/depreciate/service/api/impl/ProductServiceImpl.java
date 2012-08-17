/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api.impl;

import java.util.Date;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.util.Assert;

import com.peigen.common.lang.util.MoneyUtil;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.money.Money;
import com.peigen.web.depreciate.service.InvokeRepositService;
import com.peigen.web.depreciate.service.InvokeService;
import com.peigen.web.depreciate.service.ProductServiceBase;
import com.peigen.web.depreciate.service.api.ProductService;
import com.peigen.web.depreciate.service.enums.AttentionStatusEnum;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.enums.ProductStatusEnum;
import com.peigen.web.depreciate.service.enums.TableSeqNameEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.UserAttentionInfo;
import com.peigen.web.depreciate.service.order.Order;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.ProductParaOrder;
import com.peigen.web.depreciate.service.parse.PicParse;
import com.peigen.web.depreciate.service.result.ProductResult;

/**
 *                       
 * @Filename ProductServiceImpl.java
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
public class ProductServiceImpl extends ProductServiceBase implements ProductService {
	
	/**
	 * @param productOrder
	 * @return
	 * @see com.peigen.web.depreciate.service.api.ProductService#addProduct(com.peigen.web.depreciate.service.order.ProductOrder)
	 */
	@Override
	public ProductResult addProduct(final ProductOrder productOrder) {
		PrintLogTool.info("添加商品[productOrder=" + productOrder + "]", logger);
		
		ProductResult result = addProduct(productOrder, new InvokeService() {
			
			@Override
			public ProductInfo invoke(Order order, ProductInfo productInfo) {
				Date now = getSysdate();
				
				// 解析url
				productInfo = parseService.parse(productOrder.getUrl());
				productInfo.setStatus(ProductStatusEnum.ENABLE);
				productInfo.setId(getDBKey(TableSeqNameEnum.SEQ_DEPRECIATE_PRODUCT));
				productInfo.setRawAddTime(now);
				
				return productInfo;
			}
		},
		
		new InvokeRepositService() {
			
			@Override
			public void store(ProductInfo productInfo) {
				// 构建会员关注商品对象
				
				UserAttentionInfo userAttentionInfo = new UserAttentionInfo();
				userAttentionInfo.setRawAddTime(getSysdate());
				userAttentionInfo.setStatus(AttentionStatusEnum.FOLLOW);
				userAttentionInfo.setProductInfo(productInfo);
				userAttentionInfo.setUserId(productOrder.getUserId());
				
				// 用户关注商品
				userAttentionRepository.store(userAttentionInfo);
				
			}
		});
		
		if (result.isSuccess()) {
			PrintLogTool.info("添加商品成功[product=" + result.getProductInfo() + "]", logger);
		} else {
			
			PrintLogTool.info("添加商品失败[order=" + productOrder + "]", logger);
			
		}
		
		return result;
	}
	
	/**
	 * @param productOrder
	 * @return
	 * @see com.peigen.web.depreciate.service.api.ProductService#addProduct(com.peigen.web.depreciate.service.order.ProductParaOrder)
	 */
	@Override
	public ProductResult addProduct(final ProductParaOrder productOrder) {
		PrintLogTool.info("添加商品[productOrder=" + productOrder + "]", logger);
		
		ProductResult result = addProduct(productOrder, new InvokeService() {
			
			@Override
			public ProductInfo invoke(Order order, ProductInfo productInfo) {
				Date now = getSysdate();
				
				// 解析url
				productInfo.setCategory(parseService.parseCategory(productOrder.getUrl()));
				productInfo.setProductUrl(productOrder.getUrl());
				productInfo.setProductSerialNo(productOrder.getSerialNo());
				productInfo.setStatus(ProductStatusEnum.ENABLE);
				productInfo.setRawAddTime(now);
				productInfo.setId(getDBKey(TableSeqNameEnum.SEQ_DEPRECIATE_PRODUCT));
				productInfo.setProductCurrentPrice(productOrder.getPrice());
				productInfo.setProductName(productOrder.getProductName());
				
				// 图片
				productInfo.setProductPicInfos(PicParse.parse(productOrder.getImages()));
				
				return productInfo;
			}
		},
		
		new InvokeRepositService() {
			
			@Override
			public void store(ProductInfo productInfo) {
				// 构建会员关注商品对象
				
				UserAttentionInfo userAttentionInfo = new UserAttentionInfo();
				userAttentionInfo.setRawAddTime(getSysdate());
				userAttentionInfo.setStatus(AttentionStatusEnum.FOLLOW);
				userAttentionInfo.setProductInfo(productInfo);
				userAttentionInfo.setUserId(productOrder.getUserId());
				
				// 用户关注商品
				userAttentionRepository.store(userAttentionInfo);
				
			}
		});
		
		if (result.isSuccess()) {
			PrintLogTool.info("添加商品成功[product=" + result.getProductInfo() + "]", logger);
		} else {
			
			PrintLogTool.info("添加商品失败[order=" + productOrder + "]", logger);
			
		}
		
		return result;
	}
	
	/**
	 * @param productId
	 * @param changePrice
	 * @return
	 * @see com.peigen.web.depreciate.service.api.ProductService#changeProductPrice(java.lang.String, com.peigen.common.lang.util.money.Money)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ProductResult changeProductPrice(final String productId, final Money changePrice) {
		
		PrintLogTool.info("改变商品单价[productId=" + productId + ",productChangePrice=" + changePrice
							+ "]", logger);
		
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
						Assert.hasText(productId);
						Assert.isTrue(MoneyUtil.isGreaterThanNotZero(changePrice));
						
						//===================================================> 
						// step2:业务处理
						//===================================================>
						
						productInfo = productRepository.active(productId);
						productInfo.setProductCurrentPrice(changePrice);
						
						//===================================================> 
						// step3:持久化
						//===================================================>
						productRepository.reStore(productInfo);
						
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
						logger.error("处理异常[productId=" + productId + ",changePrice=" + changePrice
										+ "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(e.getCode());
					} catch (Exception e) {
						logger.error("处理异常[productId=" + productId + ",changePrice=" + changePrice
										+ "]：", e);
						
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
		
		if (result.isSuccess()) {
			PrintLogTool.info("改变商品单价成功[productId=" + productId + ",changePrice=" + changePrice
								+ "]", logger);
		} else {
			
			PrintLogTool.info("改变商品单价失败[productId=" + productId + ",changePrice=" + changePrice
								+ "]", logger);
		}
		
		long serviceEnd = System.currentTimeMillis();
		PrintLogTool.info("本次服务调用耗时：" + (serviceEnd - serviceStart) + "ms", logger);
		
		return result;
	}
	
	/**
	 * @param productId
	 * @param url
	 * @param productName
	 * @return
	 * @see com.peigen.web.depreciate.service.api.ProductService#editProduct(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ProductResult editProduct(String productId, String url, String productName) {
		return null;
	}
	
}
