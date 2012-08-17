/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */

package com.peigen.common.lang.ip;

import com.peigen.common.lang.util.StringUtil;

/**
 *                       
 * @Filename: IPUtil.java
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
public class IPUtil {

    /**
     * 将IP地址(61.172.201.235)转变成Long，如果ip格式非法，那么返回0
     * 
     * @param ip
     * @return
     */
    public static long ip2Long(String ip) {
        if (!isIP(ip)) {
            return 0;
        }

        long iplong = 0;
        String[] segs = StringUtil.split(ip, ".");

        for (int i = 0; i < segs.length; i++) {
            long seg = Long.parseLong(segs[i]);
            iplong += seg << ((3 - i) * 8);
        }

        return iplong;
    }

    /**
     * 将数据库中表示IP的Long型，转变成标准形式（61.172.201.235）
     * 
     * @param ipLong
     * @return
     */
    public static String long2IP(long ipLong) {

        StringBuffer ip = new StringBuffer(String.valueOf(ipLong >> 24) + ".");

        ip.append(String.valueOf((ipLong & 16711680) >> 16) + ".");
        ip.append(String.valueOf((ipLong & 65280) >> 8) + ".");
        ip.append(String.valueOf(ipLong & 255));

        return ip.toString();
    }

    /**
     * 判断字符是否是一个表示IP的字符
     * 
     * @param str
     * @return
     */
    public static boolean isIP(String str) {
        String[] tokens = StringUtil.split(str, ".");
        if (tokens.length != 4) {
            return false;
        }

        for (int i = 0; i < tokens.length; i++) {
            if (Integer.parseInt(tokens[i]) > 255 || Integer.parseInt(tokens[i]) < 0) {
                return false;
            }
        }

        return true;
    }
}
