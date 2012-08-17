/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.security;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename: OperationRoleEnum.java
 *
 * @Description: 
 *
 * @Version: 1.0
 *
 * @Author: peigen
 *
 * @Email: peigen123@gmail.com
 *
 *       
 * @History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2011-7-28</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum OperationRoleEnum {

    /** 前台用户角色 */
    ROLE_USER("ROLE_USER", "未知异常"),

    /** 后台操作人员角色 */
    ROLE_OPERATOR("ROLE_OPERATOR", "执行成功"),

    /** 系统角色 */
    ROLE_SYSTEM("ROLE_SYSTEM", "未知异常"),

    /** 系统管理员 */
    ROLE_ADMIN("ROLE_ADMIN", "未知异常"),

    /** 未登陆用户 */
    ROLE_LOGIN_ANONYMOUS("ROLE_LOGIN_ANONYMOUS", "未知异常"),

    /** 正常登陆用户 */
    ROLE_LOGIN_NORMAL("ROLE_LOGIN_NORMAL", "正常登陆用户"),

    /** 支付宝登录用户 */
    ROLE_LOGIN_ALIPAY("ROLE_LOGIN_ALIPAY", "支付宝登录用户");

    /** 枚举值 */
    private final String code;

    /** 枚举描述 */
    private final String message;

    /**
     * 构造一个<code>MemberRoleEnum</code>枚举对象
     *
     * @param code
     * @param message
     */
    private OperationRoleEnum(String code, String message) {
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
     * @return MemberRoleEnum
     */
    public static OperationRoleEnum getByCode(String code) {
        for (OperationRoleEnum cacheCode : values()) {
            if (cacheCode.getCode().equals(code)) {
                return cacheCode;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     * 
     * @return List<MemberRoleEnum>
     */
    public List<OperationRoleEnum> getAllEnum() {
        List<OperationRoleEnum> list = new ArrayList<OperationRoleEnum>();
        for (OperationRoleEnum cache : values()) {
            list.add(cache);
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
        for (OperationRoleEnum cache : values()) {
            list.add(cache.code());
        }
        return list;
    }
}
