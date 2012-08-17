/**
 * mbaobao.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.depreciate.dal.dataobject;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// auto generated imports
import java.util.Date;

/**
 * A data object class directly models database table <tt>depreciate_user</tt>.
 *
 * This file is generated by <tt>depreciate-dalgen</tt>, a DAL (Data Access Layer)
 * code generation utility specially developed for <tt>paygw</tt> project.
 * 
 * PLEASE DO NOT MODIFY THIS FILE MANUALLY, or else your modification may
 * be OVERWRITTEN by someone else. To modify the file, you should go to 
 * directory <tt>(project-home)/biz/dal/src/conf/dalgen</tt>, and 
 * find the corresponding configuration file (<tt>tables/depreciate_user.xml</tt>). 
 * Modify the configuration file according to your needs, then run <tt>depreciate-dalgen</tt> 
 * to generate this file.
 *
 * @author peigen
 */
public class DepreciateUserDO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = -4282603875229233564L;

    //========== properties ==========

	/**
	 * This property corresponds to db column <tt>id</tt>.
	 */
	private String id;

	/**
	 * This property corresponds to db column <tt>user_name</tt>.
	 */
	private String userName;

	/**
	 * This property corresponds to db column <tt>user_passwd</tt>.
	 */
	private String userPasswd;

	/**
	 * This property corresponds to db column <tt>status</tt>.
	 */
	private String status;

	/**
	 * This property corresponds to db column <tt>user_email</tt>.
	 */
	private String userEmail;

	/**
	 * This property corresponds to db column <tt>raw_add_time</tt>.
	 */
	private Date rawAddTime;

	/**
	 * This property corresponds to db column <tt>raw_update_time</tt>.
	 */
	private Date rawUpdateTime;

    //========== getters and setters ==========

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
	public String getId() {
		return id;
	}
	
	/**
	 * Setter method for property <tt>id</tt>.
	 * 
	 * @param id value to be assigned to property id
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Setter method for property <tt>userName</tt>.
	 * 
	 * @param userName value to be assigned to property userName
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}

    /**
     * Getter method for property <tt>userPasswd</tt>.
     *
     * @return property value of userPasswd
     */
	public String getUserPasswd() {
		return userPasswd;
	}
	
	/**
	 * Setter method for property <tt>userPasswd</tt>.
	 * 
	 * @param userPasswd value to be assigned to property userPasswd
     */
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Setter method for property <tt>status</tt>.
	 * 
	 * @param status value to be assigned to property status
     */
	public void setStatus(String status) {
		this.status = status;
	}

    /**
     * Getter method for property <tt>userEmail</tt>.
     *
     * @return property value of userEmail
     */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * Setter method for property <tt>userEmail</tt>.
	 * 
	 * @param userEmail value to be assigned to property userEmail
     */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

    /**
     * Getter method for property <tt>rawAddTime</tt>.
     *
     * @return property value of rawAddTime
     */
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	/**
	 * Setter method for property <tt>rawAddTime</tt>.
	 * 
	 * @param rawAddTime value to be assigned to property rawAddTime
     */
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}

    /**
     * Getter method for property <tt>rawUpdateTime</tt>.
     *
     * @return property value of rawUpdateTime
     */
	public Date getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	/**
	 * Setter method for property <tt>rawUpdateTime</tt>.
	 * 
	 * @param rawUpdateTime value to be assigned to property rawUpdateTime
     */
	public void setRawUpdateTime(Date rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}


	/**
     * @return
     *
     * @see java.lang.Object#toString()
     */
	@Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
