/**
 * jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */

package com.peigen.common.lang.ip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.peigen.common.lang.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *                       
 * @Filename: AbstractIPRepository.java
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
public abstract class AbstractIPRepository implements IPRepository {

    private static final Logger        logger = LoggerFactory.getLogger(AbstractIPRepository.class);

    /**
     * IpInfo Map，key=startIP，value=ipINfo
     */
    protected static Map<Long, IPInfo> ipMap  = new LinkedHashMap<Long, IPInfo>(300000);

    /**
     * 存放startIP的List，以startIP从小到大的顺序排列
     */
    protected static List<Long>        starts = new ArrayList<Long>(300000);

    /**
     * @param ip
     * @return
     * @see com.peigen.common.lang.ip.IPRepository#getIPInfo(long)
     */
    public IPInfo getIPInfo(long ip) {
        long start = System.currentTimeMillis();

        IPInfo ipInfo = null;
        long ipStart = locatStartIP(ip);

        ipInfo = (IPInfo) ipMap.get(new Long(ipStart));

        long end = System.currentTimeMillis();

        if (logger.isDebugEnabled()) {
            logger.debug("查找IP" + IPUtil.long2IP(ip) + ", 用时" + (end - start) + "毫秒");
        }

        if (ipInfo.getIpEnd() < ip) {
            logger.warn("在IP库中找不到IP[" + IPUtil.long2IP(ip) + "]");
            return null;
        }

        return ipInfo;
    }

    /**
     * @param ip
     * @return
     * @see com.peigen.common.lang.ip.IPRepository#getIPInfo(java.lang.String)
     */
    public IPInfo getIPInfo(String ip) {
        if (StringUtil.trimToNull(ip) == null) {
            return null;
        }

        return getIPInfo(IPUtil.ip2Long(ip));
    }

    /**
     * @return
     * @see com.peigen.common.lang.ip.IPRepository#getIpMap()
     */
    public Map<Long, IPInfo> getIpMap() {
        return ipMap;
    }

    /**
     * 查找ip对应的开始IP地址。如果IP库中正好有以该ip开始的IP信息，那么就是返回这个ip。 如果没有，则应该是比这个ip小的最大的start
     * 
     * @param ip
     * @return
     */
    private long locatStartIP(long ip) {
        long centerIP = 0;

        int centerIndex = 0; // 当前指针位置
        int startIndex = 0; // 起始位置
        int endIndex = starts.size() - 1; // 结束位置
        int count = 0; // 循环次数
        while (true) {

            if (logger.isDebugEnabled()) {
                logger.debug(count++ + ". start = " + startIndex + ", end = " + endIndex);
            }

            // 中间位置
            centerIndex = (startIndex + endIndex) / 2;

            centerIP = starts.get(centerIndex).longValue();

            if (centerIP < ip) {
                // 如果中间位置的IP小于要查询的IP，那么下一次查找后半段
                startIndex = centerIndex;
            } else if (centerIP > ip) {
                // 如果中间位置的IP大于要查询的IP，那么下一次查找前半段
                endIndex = centerIndex;
            } else {
                // 如果相等，那么已经找到要查询的IP
                break;
            }

            if (startIndex + 1 == endIndex) {
                // 如果开始指针和结束指针相差只有1，那么说明IP库中没有正好以该ip开始的IP信息
                // 只能返回IP信息的start ip比这个ip小的最大的那条IP信息的start ip
                if (centerIP > ip) {
                    centerIP = starts.get(centerIndex - 1).longValue();
                }
                break;
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("对应的IP开始地址为: " + centerIP);
        }

        return centerIP;
    }
}
