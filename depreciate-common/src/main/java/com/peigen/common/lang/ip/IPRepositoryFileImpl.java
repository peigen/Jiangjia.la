/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */

package com.peigen.common.lang.ip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.peigen.common.lang.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *                       
 * @Filename: IPRepositoryFileImpl.java
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
public class IPRepositoryFileImpl extends AbstractIPRepository {
    /** */
    private static final Logger logger = LoggerFactory.getLogger(IPRepositoryFileImpl.class);

    private static final String ipFile = "/sharedata/ipData/ip.dat";

    /**
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        logger.info("开始载入IP库.........");
        long start = System.currentTimeMillis();
        String path = System.getProperty("user.home");

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path + ipFile)));

        } catch (Exception e) {

            logger.error("加载" + path + ipFile + "数据文件出错！", e);

        }

        if (reader == null) {

            logger.info("从jar包里获取ip数据文件！");

            reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(
                "ip.dat")));

        }

        int i = 0;
        while (true) {
            i++;
            String line = reader.readLine();

            if (line == null) {
                break;
            }

            if (StringUtil.isBlank(line)) {
                continue;
            }

            String[] tokens = StringUtil.split(line, ",", 6);
            if (tokens.length != 6) {
                System.out.println("第" + String.valueOf(i) + "行格式不正确: " + line);
                continue;
            }

            Long startIP = new Long(IPUtil.ip2Long(StringUtil.trim(tokens[0])));
            Long endIP = new Long(IPUtil.ip2Long(StringUtil.trim(tokens[1])));

            String country = StringUtil.trim(tokens[2]).equals("null") ? null : StringUtil
                .trim(tokens[2]);
            String province = StringUtil.trim(tokens[3]).equals("null") ? null : StringUtil
                .trim(tokens[3]);
            String city = StringUtil.trim(tokens[4]).equals("null") ? null : StringUtil
                .trim(tokens[4]);
            String address = StringUtil.trim(tokens[5]).equals("null") ? null : StringUtil
                .trim(tokens[5]);

            // 针对国家、省份、城市解析的统一判空修改
            // 首先对特殊值的解析
            String country2 = country;
            if (StringUtil.equals("IANA", country2)) {
                country = "IANA";
                province = "IANA";
                city = "IANA";
            }

            if (StringUtil.equals("局域网", country2)) {
                country = "局域网";
                province = "局域网";
                city = "局域网";
            }

            if (StringUtil.equals("国外", country2)) {
                country = "国外";
                province = "国外";
                city = "国外";
            }

            String province2 = province;
            String city2 = city;
            if (StringUtil.equals("中国", country2)
                && (StringUtil.equals("中国", province2) || StringUtil.equals("中国", city2))) {
                country = "中国";
                province = "中国";
                city = "中国";
            }

            // 对国家、省份、城市的统一判空
            if (StringUtil.isEmpty(country2) || StringUtil.equals("国家", country2)) {

                if (StringUtil.isEmpty(province2) || StringUtil.equals("省份、州", province2)
                    || StringUtil.equals("其他", province2)) {

                    if (StringUtil.isEmpty(city2) || StringUtil.equals("地级市、县", city2)
                        || StringUtil.equals("其他", city2)) {
                        country = "-";
                        province = "-";
                        city = "-";
                    } else {
                        country = city2;
                        province = city2;
                        city = city2;
                    }

                } else {
                    if (StringUtil.isEmpty(city2) || StringUtil.equals("地级市、县", city2)
                        || StringUtil.equals("其他", city2)) {
                        country = province2;
                        province = province2;
                        city = province2;
                    } else {
                        country = province2;
                        province = province2;
                        city = city2;
                    }
                }
            } else {
                if (StringUtil.isEmpty(province2) || StringUtil.equals("省份、州", province2)
                    || StringUtil.equals("其他", province2)) {

                    if (StringUtil.isEmpty(city2) || StringUtil.equals("地级市、县", city2)
                        || StringUtil.equals("其他", city2)) {
                        country = country2;
                        province = country2;
                        city = country2;
                    } else {
                        country = country2;
                        province = city2;
                        city = city2;
                    }

                } else {
                    if (StringUtil.isEmpty(city2) || StringUtil.equals("地级市、县", city2)
                        || StringUtil.equals("其他", city2)) {
                        country = country2;
                        province = province2;
                        city = province2;
                    } else {
                        country = country2;
                        province = province2;
                        city = city2;
                    }
                }
            }

            IPInfo ipInfo = new IPInfo();
            ipInfo.setIpStart(startIP.longValue());
            ipInfo.setIpEnd(endIP.longValue());
            ipInfo.setCountry(country2);
            ipInfo.setProvince(province2);
            ipInfo.setCity(city2);
            ipInfo.setAddress(address);

            ipMap.put(startIP, ipInfo);
            starts.add(startIP);
        }

        long end = System.currentTimeMillis();

        logger.info("完成IP库的载入. 共载入" + starts.size() + "条IP纪录, 用时：" + (end - start) / 1000 + "秒.");
    }

    /**
     * @throws Exception
     * @see com.peigen.common.lang.ip.IPRepository#refreshData()
     */
    public void refreshData() throws Exception {
        ipMap.clear();
        starts.clear();
        if (logger.isInfoEnabled()) {
            logger.info("手动更新IP库开始....");
        }
        afterPropertiesSet();
        if (logger.isInfoEnabled()) {
            logger.info("手动更新IP库完成");
        }
    }
}
