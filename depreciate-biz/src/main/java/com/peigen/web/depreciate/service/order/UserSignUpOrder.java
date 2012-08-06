/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.order;

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
	
	private String				userName;
	
	private String				userPasswd;
	
	private String				userEmail;
	
	/**
	 * 
	 * @see com.peigen.web.depreciate.service.order.Order#check()
	 */
	public void check() {
		
		Assert.hasText(userName);
		Assert.hasText(userPasswd);
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 */
	public UserSignUpOrder() {
		super();
	}
	
	/**
	 * 构建一个<code>UserSignUpOrder.java</code>
	 * @param userName
	 * @param userPasswd
	 * @param userEmail
	 */
	public UserSignUpOrder(String userName, String userPasswd, String userEmail) {
		super();
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
	}
	
	/**
	 * @return Returns the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName
	 * The userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
