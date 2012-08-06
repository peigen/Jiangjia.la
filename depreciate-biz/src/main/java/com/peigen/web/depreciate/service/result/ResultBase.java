/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;

/**
 *                       
 * @Filename DepreciateResultBase.java
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
public class ResultBase implements Result {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long		serialVersionUID	= 4165926587298446217L;
	
	/** 成功状态 */
	private boolean					success				= false;
	
	/** 辅助客户端翻译处理结果代码的描述，包括各层处理结果描述 */
	private String					message				= "";
	
	/** 处理结果代码 */
	private DepreciateResultEnum	resultCode			= DepreciateResultEnum.UN_KNOWN_EXCEPTION;
	
	/**
	 * 构建一个<code>DepreciateResultBase.java</code>
	 */
	public ResultBase() {
		super();
	}
	
	/**
	 * @return
	 * @see com.peigen.web.depreciate.service.result.Result#isSuccess()
	 */
	@Override
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * @return
	 * @see com.peigen.web.depreciate.service.result.Result#isExecuted()
	 */
	@Override
	public boolean isExecuted() {
		if (DepreciateResultEnum.EXECUTE_SUCCESS == resultCode) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return Returns the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message
	 * The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return Returns the resultCode
	 */
	public DepreciateResultEnum getResultCode() {
		return resultCode;
	}
	
	/**
	 * @param resultCode
	 * The resultCode to set.
	 */
	public void setResultCode(DepreciateResultEnum resultCode) {
		this.resultCode = resultCode;
	}
	
	/**
	 * @param success
	 * The success to set.
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("DepreciateResultBase [success=%s, message=%s, resultCode=%s]",
			success, message, resultCode);
	}
	
}
