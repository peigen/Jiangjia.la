/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.order;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

/**
 *                       
 * @Filename UserSignInOrder.java
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
public class UserSignInOrder implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 7741995543795482671L;
	
	private String				userEmail;
	
	private String				userPasswd;
	
	private String				verificationCode;
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.order.Order#check()
	 */
	public void check() {
		
		Assert.hasText(userEmail);
		Assert.hasText(userPasswd);
		
		String regex = "(^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)";
		Pattern p = Pattern.compile(regex);
		p = Pattern.compile(regex);
		Matcher m = p.matcher(userEmail);
		Assert.isTrue(m.matches(), "邮箱格式不正确！");
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 */
	public UserSignInOrder() {
		super();
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 * @param userPasswd
	 * @param userEmail
	 */
	public UserSignInOrder(String userPasswd, String userEmail) {
		super();
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
	}
	
	public String getUserPasswd() {
		return userPasswd;
	}
	
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getVerificationCode() {
		return verificationCode;
	}
	
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("UserSignInOrder [userPasswd=%s, userEmail=%s, verificationCode=%s]",
			userPasswd, userEmail, verificationCode);
	}
}
