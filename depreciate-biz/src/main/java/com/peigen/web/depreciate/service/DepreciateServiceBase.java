/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateProductPicDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserAttentionDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.DepreciateUserDAO;
import com.peigen.web.depreciate.depreciate.dal.daointerface.ExtraDAO;
import com.peigen.web.depreciate.service.api.ParseService;
import com.peigen.web.depreciate.service.cache.UserLocalCache;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.enums.TableSeqNameEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.ProductInfo;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.order.Order;
import com.peigen.web.depreciate.service.repository.ProductChangeLogRepository;
import com.peigen.web.depreciate.service.repository.ProductRepository;
import com.peigen.web.depreciate.service.repository.UserAttentionRepository;
import com.peigen.web.depreciate.service.repository.UserRepository;
import com.peigen.web.depreciate.service.result.ProductResult;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename DepreciateServiceBase.java
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
public class DepreciateServiceBase {
	
	protected final Logger					logger	= LoggerFactory.getLogger(getClass());
	
	/** 事务模板 */
	@Autowired
	protected TransactionTemplate			transactionTemplate;
	
	/** repository */
	@Autowired
	protected ProductRepository				productRepository;
	
	@Autowired
	protected UserRepository				userRepository;
	
	@Autowired
	protected ProductChangeLogRepository	productChangeLogRepository;
	
	@Autowired
	protected UserAttentionRepository		userAttentionRepository;
	
	/** Service */
	@Autowired
	protected ParseService					parseService;
	
	/** Cache */
	@Autowired
	protected UserLocalCache				userLocalCache;
	
	/** DAO */
	@Autowired
	protected ExtraDAO						extraDAO;
	
	@Autowired
	protected DepreciateUserAttentionDAO	depreciateUserAttentionDAO;
	
	@Autowired
	protected DepreciateProductDAO			depreciateProductDAO;
	
	@Autowired
	protected DepreciateProductPicDAO		depreciateProductPicDAO;
	
	@Autowired
	protected DepreciateUserDAO				depreciateUserDAO;
	
	protected void checkOrder(Order order) {
		try {
			order.check();
		} catch (DepreciateException e) {
			throw new DepreciateException(e.getCode());
		} catch (Exception e) {
			throw new DepreciateException(DepreciateResultEnum.INCOMPLETE_REQ_PARAM);
		}
	}
	
	/**
	 * 打印摘要日志
	 * 
	 * @param object
	 */
	protected void printDigest(Object object) {
		
	}
	
	protected Date getSysdate() {
		Date sysDate = extraDAO.getSysdate();
		PrintLogTool.info("系统时间：sysDate=" + sysDate, logger);
		return sysDate;
	}
	
	protected String getDBKey(TableSeqNameEnum tableSeqName) {
		//前8位yyyyMMdd格式
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String today = dateFormat.format(getSysdate());
		
		return today + genSeq(tableSeqName) + genProductCode("0000");
		
	}
	
	private String genSeq(TableSeqNameEnum tableSeqName) {
		String seq = String.valueOf(extraDAO.getNextSeq(tableSeqName.code()));
		
		String src = "0000000" + seq;
		src = src.substring(src.length() - 8);
		return src;
	}
	
	private String genProductCode(String businessCode) {
		return businessCode;
	}
	
	protected void setSuccessUserResult(UserResult result, UserInfo userInfo) {
		result.setSuccess(true);
		result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
		result.setUserInfo(userInfo);
	}
	
	protected void setSuccessProductResult(ProductResult result, ProductInfo productInfo) {
		result.setSuccess(true);
		result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
		result.setProductInfo(productInfo);
	}
}
