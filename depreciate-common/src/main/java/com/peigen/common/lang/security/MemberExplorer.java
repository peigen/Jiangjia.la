/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.security;

import java.io.Serializable;

/**
 *                       
 * @Filename: MemberExplorer.java
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
public class MemberExplorer implements Serializable {

    /** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = 3544811222769090466L;

    //浏览器类型
    private ExplorerType      explorerType;

    //浏览器版本
    private String            explorerVersion;

    //主要指User-Agent获取相关信息
    private String            explorerInfo;

    /**
     * @return Returns the explorerType
     */
    public ExplorerType getExplorerType() {
        return explorerType;
    }

    /**
     * @param explorerType
     * The explorerType to set.
     */
    public void setExplorerType(ExplorerType explorerType) {
        this.explorerType = explorerType;
    }

    /**
     * @return Returns the explorerVersion
     */
    public String getExplorerVersion() {
        return explorerVersion;
    }

    /**
     * @param explorerVersion
     * The explorerVersion to set.
     */
    public void setExplorerVersion(String explorerVersion) {
        this.explorerVersion = explorerVersion;
    }

    /**
     * @return Returns the explorerInfo
     */
    public String getExplorerInfo() {
        return explorerInfo;
    }

    /**
     * @param explorerInfo
     * The explorerInfo to set.
     */
    public void setExplorerInfo(String explorerInfo) {
        this.explorerInfo = explorerInfo;
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
            "MemberExplorer [explorerType=%s, explorerVersion=%s, explorerInfo=%s]", explorerType,
            explorerVersion, explorerInfo);
    }

}
