/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.result;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.peigen.web.depreciate.service.info.UserAttentionInfo;

/**
 *                       
 * @Filename BatchUserAttentionResult.java
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
public class BatchUserAttentionResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -8838568614268287536L;
	
	List<UserAttentionInfo>		userAttentions		= new ArrayList<UserAttentionInfo>();
	
	/**
	 * 构建一个<code>BatchUserAttentionResult.java</code>
	 */
	public BatchUserAttentionResult() {
		super();
	}
	
	/**
	 * 构建一个<code>BatchUserAttentionResult.java</code>
	 * @param userAttentions
	 */
	public BatchUserAttentionResult(List<UserAttentionInfo> userAttentions) {
		super();
		this.userAttentions = userAttentions;
	}
	
	/**
	 * @return Returns the userAttentions
	 */
	public List<UserAttentionInfo> getUserAttentions() {
		return userAttentions;
	}
	
	/**
	 * @param userAttentions
	 * The userAttentions to set.
	 */
	public void setUserAttentions(List<UserAttentionInfo> userAttentions) {
		this.userAttentions = userAttentions;
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
