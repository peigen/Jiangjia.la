/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.order;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.Assert;

/**
 *                       
 * @Filename UserSignUpOrder.java
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
public class UserSignUpOrder implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 7741995543795482671L;
	
	private String				userPasswd;
	
	private String				userEmail;
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.order.Order#check()
	 */
	public void check() {
		
		Assert.hasText(userPasswd);
		Assert.hasText(userEmail);
		
		String regex = "(^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)";
		Pattern p = Pattern.compile(regex);
		p = Pattern.compile(regex);
		Matcher m = p.matcher(userEmail);
		Assert.isTrue(m.matches(), "邮箱格式不正确！");
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 */
	public UserSignUpOrder() {
		super();
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 * @param userPasswd
	 * @param userEmail
	 */
	public UserSignUpOrder(String userPasswd, String userEmail) {
		super();
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
	}
	
	/**
	 * @return Returns the userPasswd
	 */
	public String getUserPasswd() {
		return userPasswd;
	}
	
	/**
	 * @param userPasswd
	 * The userPasswd to set.
	 */
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	
	/**
	 * @return Returns the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * @param userEmail
	 * The userEmail to set.
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
