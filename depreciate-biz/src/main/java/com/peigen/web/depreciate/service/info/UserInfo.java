/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.info;

import java.io.Serializable;
import java.util.Date;

import com.peigen.web.depreciate.service.enums.UserStatusEnum;

/**
 *                       
 * @Filename UserInfo.java
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
public class UserInfo implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -2621766587330439090L;
	
	private String				id;
	
	private String				userName;
	
	private String				userPasswd;
	
	private String				email;
	
	private UserStatusEnum		status;
	
	private Date				rawAddTime;
	
	private Date				rawUpdateTime;
	
	/**
	 * 构建一个<code>UserInfo.java</code>
	 */
	public UserInfo() {
		super();
	}
	
	/**
	 * @return Returns the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id
	 * The id to set.
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return Returns the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email
	 * The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return Returns the status
	 */
	public UserStatusEnum getStatus() {
		return status;
	}
	
	/**
	 * @param status
	 * The status to set.
	 */
	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}
	
	/**
	 * @return Returns the rawAddTime
	 */
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	/**
	 * @param rawAddTime
	 * The rawAddTime to set.
	 */
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	/**
	 * @return Returns the rawUpdateTime
	 */
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	/**
	 * @param rawUpdateTime
	 * The rawUpdateTime to set.
	 */
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
			.format(
				"UserInfo [id=%s, userName=%s, userPasswd=%s, email=%s, status=%s, rawAddTime=%s, rawUpdateTime=%s]",
				id, userName, userPasswd, email, status, rawAddTime, rawUpdateTime);
	}
	
}
