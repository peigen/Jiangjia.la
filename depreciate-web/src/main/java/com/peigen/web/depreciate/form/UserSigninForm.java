/**
 * www.yiji.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.form;

import java.io.Serializable;

/**
 *                       
 * @Filename UserSigninForm.java
 *
 * @Description 登录Form
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen@yiji.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2012-8-16</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserSigninForm implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 4567914478154151895L;
	
	private String				email;
	
	private String				password;
	
	private String				verificationCode;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
		return String.format("UserSigninForm [email=%s, password=%s, verificationCode=%s]", email,
			password, verificationCode);
	}
	
}
