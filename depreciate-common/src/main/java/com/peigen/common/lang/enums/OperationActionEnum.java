/**
 * www.yuitat.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.common.lang.enums;

import java.util.ArrayList;
import java.util.List;

import com.peigen.common.lang.util.StringUtil;

/**
 *                       
 * @Filename OperationActionEnum.java
 *
 * @Description 操作指令
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-12-29</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum OperationActionEnum {
	
	/********************************************
	 * 					 会员					*
	 *******************************************/
	/** 会员注册 */
	MEMBER_SIGNUP("MEMBER_REGISTER", "会员注册"),
	
	/** 修改会员 */
	MEMBER_EDIT("MEMBER_EDIT", "修改会员"),
	
	/** 会员登录 */
	MEMBER_SIGNIN("MEMBER_LOGIN", "会员登录"),
	
	/** 会员查询 */
	MEMBER_FIND("MEMBER_FIND", "会员查询"),
	
	/** 会员查询 */
	MEMBER_LOAD("MEMBER_LOAD", "会员查询"),
	
	/** 查询会员是否存在 */
	MEMBER_IS_EXIST("MEMBER_IS_EXIST", "查询会员是否存在"),
	
	/** 会员修改密码 */
	MEMBER_MODIFY_PWD("MEMBER_MODIFY_PWD", "会员修改密码"),
	
	/**	申请找回密码  */
	MEMBER_APPLY_RETRIEVE_PWD("MEMBER_APPLY_RETRIEVE_PWD", "申请找回密码"),
	
	/**	重置密码  */
	MEMBER_RESET_PWD("MEMBER_RESET_PWD", "重置密码"),
	
	/** 保存收货地址 */
	MEMBER_ADDRESS_SAVE("MEMBER_ADDRESS_SAVE", "保存收货地址"),
	
	/** 查询收货地址*/
	MEMBER_ADDRESS_QUERY("MEMBER_ADDRESS_QUERY", "查询收货地址"),
	
	/** 查询收货地址*/
	MEMBER_ADDRESS_FIND("MEMBER_ADDRESS_FIND", "查询收货地址"),
	
	/** 删除收货地址 */
	MEMBER_ADDRESS_DELETE("MEMBER_ADDRESS_DELETE", "删除收货地址"),
	
	/** 删除会员 */
	MEMBER_DELETE("MEMBER_DELETE", "删除会员"),
	
	/** 锁定会员 */
	MEMBER_LOCK("MEMBER_LOCK", "锁定会员"),
	
	/** 解锁会员 */
	MEMBER_UN_LOCK("MEMBER_UN_LOCK", "解锁会员"),
	
	/********************************************
	 * 					 退换					*
	 *******************************************/
	/** 退换查询 */
	RETURNED_FIND("RETURNED_FIND", "退换查询"),
	
	RETURNED_LOAD("RETURNED_LOAD", "退换查询"),
	
	/** 退换申请 */
	RETURNED_APPLY("RETURNED_APPLY", "退换申请"),
	
	/**	退换申请修改 */
	RETURNED_EDIT("RETURNED_EDIT", "退换申请修改"),
	
	/** 退换分配 */
	RETURNED_ASSIGN("RETURNED_ASSIGN", "退换分配"),
	
	/** 退换审核	*/
	RETURNED_VERIFY("RETURNED_VERIFY", "退换审核"),
	
	/** 退换物流准备完毕	*/
	RETURNED_LOGISTICS_READY("RETURNED_LOGISTICS_READY", "退换物流准备完毕"),
	
	/** 确认发货 */
	RETURNED_CONFIRM_DELIVERY("RETURNED_CONFIRM_DELIVERY", "确认发货"),
	
	/** 废弃 */
	RETURNED_DISCARD("RETURNED_DISCARD", "废弃"),
	
	/** 退换完成	*/
	RETURNED_COMPLETE("RETURNED_COMPLETE", "退换完成"),
	
	/********************************************
	 * 					 ADDRESS				*
	 *******************************************/
	ADDRESS_STORE("ADDRESS_STORE", "存储公共地址"),
	
	/********************************************
	 * 					 物流				*
	 *******************************************/
	
	/** 物流订单申请	*/
	LOGISTICS_CONTRACT_APPLY("LOGISTICS_CONTRACT_APPLY", "物流订单申请"),
	
	/** 物流订单确认	*/
	LOGISTICS_CONTRACT_AFFIRM("LOGISTICS_CONTRACT_AFFIRM", "物流订单确认"),
	
	/** 物流发货	*/
	LOGISTICS_CONTRACT_CONSIGNED("LOGISTICS_CONTRACT_CONSIGNED", "物流发货"),
	
	/** 物流签收	*/
	LOGISTICS_CONTRACT_RECEIVED("LOGISTICS_CONTRACT_RECEIVED", "物流签收"),
	
	/** 物流废弃 */
	LOGISTICS_CONTRACT_DISCARD("LOGISTICS_CONTRACT_DISCARD", "物流废弃"),
	
	/** 根据订单ID查询物流订单	*/
	LOGISTICS_CONTRACT_FIND_BY_CONTRACT_ID("LOGISTICS_CONTRACT_FIND_BY_CONTRACT_ID", "根据订单ID查询物流订单"),
	
	/** 根据物流订单ID查询物流订单	*/
	LOGISTICS_CONTRACT_FIND_BY_LOGISTICS_ID("LOGISTICS_CONTRACT_FIND_BY_LOGISTICS_ID",
											"根据物流订单ID查询物流订单"),
	
	/** 查询全部物流订单	*/
	LOGISTICS_CONTRACT_LOAD_ALL("LOGISTICS_CONTRACT_LOAD_ALL", "查询全部物流订单"),
	
	/** 根据发货人ID查询物流订单集合	*/
	LOGISTICS_CONTRACT_LOAD_BY_CONSIGNOR_ID("LOGISTICS_CONTRACT_LOAD_BY_CONSIGNOR_ID",
											"根据发货人ID查询物流订单集合"),
	
	/** 根据收货人ID查询物流订单集合	*/
	LOGISTICS_CONTRACT_LOAD_BY_CONSIGNEE_ID("LOGISTICS_CONTRACT_LOAD_BY_CONSIGNEE_ID",
											"根据收货人ID查询物流订单集合"),
	
	/** 新增物流公司	*/
	LOGISTICS_COMPANY_CREATE("LOGISTICS_COMPANY_CREATE", "新增物流公司"),
	
	/** 修改物流公司	*/
	LOGISTICS_COMPANY_EDIT("LOGISTICS_COMPANY_EDIT", "修改物流公司"),
	
	/** 新增物流公司联系人 */
	LOGISTICS_COMPANY_CONTACT_CREATE("LOGISTICS_COMPANY_CONTACT_CREATE", "新增物流公司联系人"),
	
	/** 修改物流公司联系人 */
	LOGISTICS_COMPANY_CONTACT_EDIT("LOGISTICS_COMPANY_CONTACT_EDIT", "修改物流公司联系人"),
	
	/** 删除物流公司联系人*/
	LOGISTICS_COMPANY_CONTACT_DELETE("LOGISTICS_COMPANY_CONTACT_DELETE", "删除物流公司联系人"),
	
	/** 根据ID查询物流公司信息 */
	LOGISTICS_QUERY_COMPANY_BY_COMPANY_ID("LOGISTICS_QUERY_COMPANY_BY_COMPANY_ID", "根据ID查询物流公司信息"),
	
	/** 查询所有物流公司信息 */
	LOGISTICS_QUERY_ALL_COMPANY("LOGISTICS_QUERY_ALL_COMPANY", "查询所有物流公司信息"),
	
	/** 根据ID查询物流公司联系人 */
	LOGISTICS_QUERY_COMPANY_CONTACT_BY_CONTACT_ID("LOGISTICS_QUERY_COMPANY_CONTACT_BY_CONTACT_ID",
													"根据ID查询物流公司联系人"),
	
	/** 根据公司ID查询物流公司联系人列表 */
	LOGISTICS_QUERY_COMPANY_CONTACT_BY_COMPANY_ID("LOGISTICS_QUERY_COMPANY_CONTACT_BY_COMPANY_ID",
													"根据公司ID查询物流公司联系人列表"),
	
	/** 查询所有物流联络单 */
	LOGISTICS_QUERY_ALL_CONTACT("LOGISTICS_QUERY_ALL_CONTACT", "查询所有物流联络单"),
	
	/** 根据状态查询物流联络单 */
	LOGISTICS_QUERY_CONTACT_BY_STATUS("LOGISTICS_QUERY_CONTACT_BY_STATUS", "根据状态查询物流联络单"),
	
	/** 查询待处理的物流订单 */
	LOGISTICS_QUERY_CONTACT_PENDS("LOGISTICS_QUERY_CONTACT_PENDS", "查询待处理的物流订单"),
	
	/** 统计待处理的物流订单 */
	LOGISTICS_QUERY_CONTACT_PENDS_FOR_COUNT("LOGISTICS_QUERY_CONTACT_PENDS_FOR_COUNT", "统计待处理的物流订单"),
	
	/*******************************************
	 *				联系人 
	 ******************************************/
	CONTACT_STORE("CONTACT_STORE", "存储联系人"),
	
	CONTACT_FIND("CONTACT_FIND", "查询联系人"),
	
	CONTACT_LOAD("CONTACT_LOAD", "查询联系人"),
	
	/*******************************************
	 *				供应商
	 ******************************************/
	/** 供应商注册*/
	SUPPLIER_REGISTER("SUPPLIER_REGISTER", "供应商注册"),
	
	/** 供应商登录*/
	SUPPLIER_LOGIN("SUPPLIER_LOGIN", "供应商登录"),
	
	/** 供应商认证*/
	SUPPLIER_CERTICIACION("SUPPLIER_CERTICIACION", "供应商认证"),
	
	/** 修改供应商信息*/
	SUPPLIER_MODIFY_INFO("SUPPLIER_MODIFY_INFO", "修改供应商信息"),
	
	/** 供应商查询*/
	SUPPLIER_FIND("SUPPLIER_FIND", "供应商查询"),
	
	/** 供应商等级查询*/
	SUPPLIER_LEVEL_FIND("SUPPLIER_LEVEL_FIND", "供应商等级查询"),
	
	/** 查询供应商是否存在*/
	SUPPLIER_IS_EXIST("SUPPLIER_IS_EXIST", "查询供应商是否存在"),
	
	/** 供应商查询*/
	SUPPLIER_LOAD("SUPPLIER_LOAD", "供应商查询"),
	
	/** 根据状态查询供应商*/
	SUPPLIER_LOAD_BY_STATUS("SUPPLIER_LOAD_BY_STATUS", "根据状态查询供应商"),
	
	/** 删除供应商*/
	SUPPLIER_DELETE("SUPPLIER_DELETE", "删除供应商"),
	
	/** 锁定供应商 */
	SUPPLIER_LOCK("SUPPLIER_LOCK", "锁定供应商"),
	
	/** 解锁供应商 */
	SUPPLIER_UN_LOCK("SUPPLIER_UN_LOCK", "解锁供应商"),
	
	SUPPLIER_PWD_MODIFY("SUPPLIER_PWD_MODIFY", "供应商密码修改"),
	
	/*******************************************
	 *				注册认证
	 ******************************************/
	/** 存储注册认证 */
	REG_CERTIFICATION_STORE("REG_CERTIFICATION_STORE", "存储注册认证"),
	
	/** 删除注册认证 */
	REG_CERTIFICATION_DELETE("REG_CERTIFICATION_DELETE", "删除注册认证"),
	
	REG_CERTIFICATION_VERIFY_APPROVE("REG_CERTIFICATION_VERIFY_APPROVE", "注册认证审核通过"),
	
	REG_CERTIFICATION_VERIFY_REFUSE("REG_CERTIFICATION_VERIFY_REFUSE", "注册认证审核拒绝"),
	
	REG_CERTIFICATION_FIND("REG_CERTIFICATION_FIND", "查询注册认证"),
	
	REG_CERTIFICATION_LOAD("REG_CERTIFICATION_LOAD", "查询注册认证"),
	
	/*******************************************
	 *				交易记录
	 ******************************************/
	/** 保存交易记录*/
	DEALS_RECORD_CREATE("DEALS_RECORD_CREATE", "保存交易记录"),
	
	/** 删除交易记录*/
	DEALS_RECORD_DELETE("DEALS_RECORD_DELETE", "删除交易记录"),
	
	DEALS_RECORD_FIND("DEALS_RECORD_FIND", "查询交易记录"),
	
	DEALS_RECORD_LOAD("DEALS_RECORD_LOAD", "查询交易记录"),
	
	DEALS_RECORD_VERTIFY_APPROVE("DEALS_RECORD_VERTIFY_APPROVE", "交易记录审核通过"),
	
	DEALS_RECORD_VERTIFY_REFUSE("DEALS_RECORD_VERTIFY_REFUSE", "交易记录审核拒绝"),
	
	/*******************************************
	 *				上传文件
	 ******************************************/
	UPLOAD("UPLOAD", "上传文件"),
	
	/*******************************************
	 *				系统配置
	 ******************************************/
	
	SYS_CONFIG_LOAD("SYS_CONFIG_LOAD", "查询系统配置"),
	
	/*******************************************
	 *				User
	 ******************************************/
	USER_FIND("USER_FIND", "查询用户信息"),
	
	/*******************************************
	 *				Level Point
	 ******************************************/
	LEVEL_POINT_INCREASE("LEVEL_POINT_INCREASE", "增加单位一分数"),
	
	LEVEL_POINT_REDUCE("LEVEL_POINT_REDUCE", "减少单位一分数"),
	
	LEVEL_POINT_TRANS("LEVEL_POINT_TRANS", "Level Point 转换"),
	
	LEVEL_POINT_FIND("LEVEL_POINT_FIND", "Level Point 查询");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>OperationTypeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private OperationActionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return OperationTypeEnum
	 */
	public static OperationActionEnum getByCode(String code) {
		for (OperationActionEnum _enum : values()) {
			if (StringUtil.equals(_enum.getCode(), code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<OperationTypeEnum>
	 */
	public List<OperationActionEnum> getAllEnum() {
		List<OperationActionEnum> list = new ArrayList<OperationActionEnum>();
		for (OperationActionEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (OperationActionEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
