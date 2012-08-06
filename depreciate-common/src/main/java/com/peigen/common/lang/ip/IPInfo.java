/**
 * jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */

package com.peigen.common.lang.ip;

import java.io.Serializable;
import java.util.Date;

/**
 *                       
 * @Filename: IPInfo.java
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
public class IPInfo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7668102229027007634L;

    /**
     * IP段的起始值
     */
    private long              ipStart;

    /**
     * IP段的结束值
     */
    private long              ipEnd;

    /**
     * IP所在的国家
     */
    private String            country;

    /**
     * IP所在的省
     */
    private String            province;

    /**
     * IP所在的城市
     */
    private String            city;

    /**
     * IP所在的地区
     */
    private String            district;

    /**
     * IP所在的具体街道
     */
    private String            address;

    /**
     * IP信息来源
     */
    private String            origin;

    /**
     * IP信息创建时间
     */
    private Date              gmtCreate;

    /**
     * IP信息修改时间
     */
    private Date              gmtModify;

    /**
     * IP信息创建者
     */
    private String            operatorCreate;

    /**
     * IP信息修改者
     */
    private String            operatorModify;

    /**
     * 备注
     */
    private String            memo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(long ipEnd) {
        this.ipEnd = ipEnd;
    }

    public long getIpStart() {
        return ipStart;
    }

    public void setIpStart(long ipStart) {
        this.ipStart = ipStart;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperatorCreate() {
        return operatorCreate;
    }

    public void setOperatorCreate(String operatorCreate) {
        this.operatorCreate = operatorCreate;
    }

    public String getOperatorModify() {
        return operatorModify;
    }

    public void setOperatorModify(String operatorModify) {
        this.operatorModify = operatorModify;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return (country == null ? "" : country) + (province == null ? "" : province + "省")
               + (city == null ? "" : city + "市") + (district == null ? "" : district + "地区")
               + (address == null ? "" : address);
    }
}
