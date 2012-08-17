/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.api.impl;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.peigen.common.lang.util.MD5Util;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.DepreciateServiceBase;
import com.peigen.web.depreciate.service.api.UserService;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.enums.TableSeqNameEnum;
import com.peigen.web.depreciate.service.enums.UserStatusEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.UserInfo;
import com.peigen.web.depreciate.service.order.ProductOrder;
import com.peigen.web.depreciate.service.order.UserSignUpOrder;
import com.peigen.web.depreciate.service.result.UserResult;

/**
 *                       
 * @Filename UserServiceImpl.java
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
public class UserServiceImpl extends DepreciateServiceBase implements UserService {
	
	/**
	 * @param userId
	 * @param productOrder
	 * @return
	 * @see com.peigen.web.depreciate.service.api.UserService#attentionProduct(java.lang.String, com.peigen.web.depreciate.service.order.ProductOrder)
	 */
	@Override
	public UserResult attentionProduct(String userId, ProductOrder productOrder) {
		return null;
	}
	
	/**
	 * @param userId
	 * @param productId
	 * @return
	 * @see com.peigen.web.depreciate.service.api.UserService#ignoreProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public UserResult ignoreProduct(String userId, String productId) {
		return null;
	}
	
	/**
	 * @param signUpOrder
	 * @return
	 * @see com.peigen.web.depreciate.service.api.UserService#signUp(com.peigen.web.depreciate.service.order.UserSignUpOrder)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public UserResult signUp(final UserSignUpOrder signUpOrder) {
		
		PrintLogTool.info("用户注册[signUpOrder=" + signUpOrder + "]", logger);
		
		UserResult result = new UserResult();
		
		try {
			result = ((UserResult) transactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus status) {
					
					UserResult result = new UserResult();
					
					UserInfo userInfo = new UserInfo();
					
					try {
						//===================================================> 
						// step1:单据检查
						//===================================================>
						checkOrder(signUpOrder);
						
						//===================================================> 
						// step2:业务处理
						//===================================================>
						userInfo.setStatus(UserStatusEnum.INIT);
						userInfo.setUserPasswd(MD5Util.MD5Encode(signUpOrder.getUserPasswd()));
						userInfo.setRawAddTime(getSysdate());
						userInfo.setId(getDBKey(TableSeqNameEnum.SEQ_DEPRECIATE_USER));
						userInfo.setEmail(signUpOrder.getUserEmail());
						
						//===================================================> 
						// step3:持久化
						//===================================================>
						userRepository.store(userInfo);
						
						//===================================================> 
						// step4:打印摘要日志
						//===================================================>
						printDigest(userInfo);
						
						//===================================================> 
						// step5:结果处理
						//===================================================>
						result.setSuccess(true);
						result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
						result.setUserInfo(userInfo);
						
					} catch (DepreciateException e) {
						logger.error("处理异常[order=" + signUpOrder + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(e.getCode());
					} catch (Exception e) {
						logger.error("处理异常[order=" + signUpOrder + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(DepreciateResultEnum.UN_KNOWN_EXCEPTION);
					}
					
					return result;
					
				}
				
			}));
		} catch (Exception exception) {
			
		} finally {
			
			//清空上下文
			
		}
		
		if (result.isSuccess()) {
			PrintLogTool.info("用户注册成功[user=" + result.getUserInfo() + "]", logger);
		} else {
			
			PrintLogTool.info("用户注册失败[email=" + signUpOrder.getUserEmail() + ",userPasswd="
								+ signUpOrder.getUserPasswd() + "]", logger);
			
		}
		
		return result;
	}
	
	/**
	 * @param email
	 * @return
	 * @see com.peigen.web.depreciate.service.api.UserService#signUpByEmail(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public UserResult signUpByEmail(final String email) {
		PrintLogTool.info("通过email注册用户[email=" + email + "]", logger);
		
		UserResult result = new UserResult();
		
		try {
			result = ((UserResult) transactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus status) {
					
					UserResult result = new UserResult();
					
					UserInfo user = new UserInfo();
					
					try {
						//===================================================> 
						// step1:单据检查
						//===================================================>
						//===================================================> 
						// step2:业务处理
						//===================================================>
						user.setStatus(UserStatusEnum.INIT);
						user.setId(getDBKey(TableSeqNameEnum.SEQ_DEPRECIATE_USER));
						user.setUserName("降价啦第" + parseUserSeq(user.getId()) + "号用户");
						user.setUserPasswd(MD5Util.MD5Encode(genPasswd()));
						user.setEmail(email);
						user.setRawAddTime(getSysdate());
						
						//===================================================> 
						// step3:持久化
						//===================================================>
						userRepository.store(user);
						
						//===================================================> 
						// step4:打印摘要日志
						//===================================================>
						printDigest(user);
						
						//===================================================> 
						// step5:结果处理
						//===================================================>
						result.setSuccess(true);
						result.setResultCode(DepreciateResultEnum.EXECUTE_SUCCESS);
						result.setUserInfo(user);
						
					} catch (DepreciateException e) {
						logger.error("处理异常[email=" + email + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(e.getCode());
					} catch (Exception e) {
						logger.error("处理异常[email=" + email + "]：", e);
						
						status.setRollbackOnly();
						
						result.setSuccess(false);
						result.setResultCode(DepreciateResultEnum.UN_KNOWN_EXCEPTION);
					}
					
					return result;
					
				}
				
			}));
		} catch (Exception exception) {
			
		}
		
		if (result.isSuccess()) {
			PrintLogTool.info("通过email注册用户成功[user=" + result.getUserInfo() + "]", logger);
		} else {
			
			PrintLogTool.info("通过email注册用户失败[email=" + email + "]", logger);
			
		}
		
		return result;
	}
	
	/**
	 * @param userName
	 * @param userPasswd
	 * @param verificationCode
	 * @return
	 * @see com.peigen.web.depreciate.service.api.UserService#signIn(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public UserResult signIn(String userName, String userPasswd, String verificationCode) {
		return null;
	}
	
	// 内部方法
	
	private String parseUserSeq(String userId) {
		String userSeq = StringUtil.right(userId, 8);
		return Integer.valueOf(userSeq).toString();
	}
	
	/**
	 * @return
	 */
	private String genPasswd() {
		final String passwdRangeStr = "2345679ACDEFHJKLMNPRSTUVWXYZ";
		final int figures = 6;
		
		StringBuffer buffer = new StringBuffer();
		for (int l = 0; l < figures; l++) {
			buffer.append(passwdRangeStr.charAt(RandomUtils.nextInt(passwdRangeStr.length())));
		}
		
		//查询passwd是否唯一
		UserInfo userInfo = userLocalCache.getUserByPasswd(buffer.toString());
		if (userInfo != null) {
			return genPasswd();
		}
		return buffer.toString();
	}
	
}
