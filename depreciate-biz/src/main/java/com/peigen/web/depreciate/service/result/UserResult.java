/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename DepreciateUserResult.java
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
public class UserResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 9029311613605308177L;
	
	private UserInfo			userInfo;
	
	/**
	 * 构建一个<code>DepreciateUserResult.java</code>
	 */
	public UserResult() {
		super();
	}
	
	/**
	 * @return Returns the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	/**
	 * @param userInfo
	 * The userInfo to set.
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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
