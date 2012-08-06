/**
 * jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */

package com.peigen.common.lang.ip;

import java.util.Map;

/**
 *                       
 * @Filename: IPRepository.java
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
public interface IPRepository {
    /**
     * 获得ip所在地址段的信息
     * 
     * @param ip
     * @return
     */
    public IPInfo getIPInfo(long ip);

    /**
     * 获得ip所在地址段的信息
     * 
     * @param ip
     * @return
     */
    public IPInfo getIPInfo(String ip);

    /**
     * 获得所有ip信息
     * 
     * @return
     */
    public Map<Long, IPInfo> getIpMap();

    /**
     * 
     * 刷新IP库
     * @param path
     * @throws Exception
     */
    public void refreshData() throws Exception;
}
