/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.UserAttentionInfo;

/**
 *                       
 * @Filename UserAttentionResult.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-23</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserAttentionResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 4855182627604749628L;
	
	UserAttentionInfo			userAttentionInfo	= new UserAttentionInfo();
	
	/**
	 * 构建一个<code>UserAttentionResult.java</code>
	 */
	public UserAttentionResult() {
		super();
	}
	
	/**
	 * 构建一个<code>UserAttentionResult.java</code>
	 * @param userAttentionInfo
	 */
	public UserAttentionResult(UserAttentionInfo userAttentionInfo) {
		super();
		this.userAttentionInfo = userAttentionInfo;
	}
	
	/**
	 * @return Returns the userAttentionInfo
	 */
	public UserAttentionInfo getUserAttentionInfo() {
		return userAttentionInfo;
	}
	
	/**
	 * @param userAttentionInfo
	 * The userAttentionInfo to set.
	 */
	public void setUserAttentionInfo(UserAttentionInfo userAttentionInfo) {
		this.userAttentionInfo = userAttentionInfo;
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
