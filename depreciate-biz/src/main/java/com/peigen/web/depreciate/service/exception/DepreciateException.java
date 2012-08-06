package com.peigen.web.depreciate.service.exception;

import com.peigen.common.lang.util.StringUtil;

import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;

/**
 *                       
 * @Filename DepreciateException.java
 *
 * @Description 异常基类
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
public class DepreciateException extends RuntimeException {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long		serialVersionUID	= 1542334090237648137L;
	
	/** 异常代码 */
	private DepreciateResultEnum	code				= DepreciateResultEnum.UN_KNOWN_EXCEPTION;
	
	/**
	 * 构建一个<code>LotteryException.java</code>
	 */
	public DepreciateException() {
		super();
	}
	
	/**
	 * 构建一个<code>LotteryException.java</code>
	 * @param message
	 * @param cause
	 */
	public DepreciateException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * 构建一个<code>LotteryException.java</code>
	 * @param message
	 */
	public DepreciateException(String message) {
		super(message);
	}
	
	/**
	 * 构建一个<code>LotteryException.java</code>
	 * @param cause
	 */
	public DepreciateException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * 构建一个<code>LotteryException.java</code>
	 * @param code
	 */
	public DepreciateException(DepreciateResultEnum code) {
		super();
		this.code = code;
	}
	
	/**
	 * @return Returns the code
	 */
	public DepreciateResultEnum getCode() {
		return code;
	}
	
	/**
	 * @param code
	 * The code to set.
	 */
	public void setCode(DepreciateResultEnum code) {
		this.code = code;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = getClass().getName();
		String message = getLocalizedMessage();
		return (StringUtil.isNotBlank(message)) ? (s + ": " + message)
			: (s + ": " + code.getCode() + "[" + code.getMessage() + "]。");
	}
	
}
