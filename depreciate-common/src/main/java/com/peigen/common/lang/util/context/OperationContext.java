/**
 * www.yuitat.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.common.lang.util.context;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *                       
 * @Filename OperationContext.java
 *
 * @Description 操作上下文
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-12-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationContext implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -6484414253206152036L;
	
	/**
	 * 操作类型
	 */
	public enum OperationTypeEnum {
		// 测试数据
		test,
		
		// 后台操作
		bops,
		
		// 会员操作
		member;
		
	}
	
	/** 操作员ID */
	private String				operationId;
	
	/** 操作员姓名 */
	private String				operationName;
	
	/** 操作员IP */
	private String				operationIp;
	
	/** 操作类型 */
	private OperationTypeEnum	operationType;
	
	/**
	 * 构建一个<code>OperationContext.java</code>
	 */
	public OperationContext() {
		super();
	}
	
	/**
	 * 构建一个<code>OperationContext.java</code>
	 * @param operationId
	 * @param operationName
	 * @param operationIp
	 * @param operationType
	 */
	public OperationContext(String operationId, String operationName, String operationIp,
							OperationTypeEnum operationType) {
		super();
		this.operationId = operationId;
		this.operationName = operationName;
		this.operationIp = operationIp;
		this.operationType = operationType;
	}
	
	/**
	 * @return Returns the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	
	/**
	 * @param operationId
	 * The operationId to set.
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	/**
	 * @return Returns the operationName
	 */
	public String getOperationName() {
		return operationName;
	}
	
	/**
	 * @param operationName
	 * The operationName to set.
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	/**
	 * @return Returns the operationIp
	 */
	public String getOperationIp() {
		return operationIp;
	}
	
	/**
	 * @param operationIp
	 * The operationIp to set.
	 */
	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}
	
	/**
	 * @return Returns the operationType
	 */
	public OperationTypeEnum getOperationType() {
		return operationType;
	}
	
	/**
	 * @param operationType
	 * The operationType to set.
	 */
	public void setOperationType(OperationTypeEnum operationType) {
		this.operationType = operationType;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
			.format(
				"OperationContext [operationId=%s, operationName=%s, operationIp=%s, operationType=%s]",
				operationId, operationName, operationIp, operationType);
	}
	
}
