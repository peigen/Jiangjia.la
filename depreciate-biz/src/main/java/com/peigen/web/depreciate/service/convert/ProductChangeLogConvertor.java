/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.convert;

import java.util.List;

import com.peigen.common.lang.util.MoneyUtil;
import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateProductChangeLogDO;
import com.peigen.web.depreciate.service.info.ProductChangeLogInfo;

/**
 *                       
 * @Filename ProductChangeLogConvertor.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ProductChangeLogConvertor {
	
	public static void convert(ProductChangeLogInfo changeLogInfo,
								DepreciateProductChangeLogDO changeLog) {
		
		changeLogInfo.setId(changeLog.getId());
		changeLogInfo.setProductChangePrice(MoneyUtil.genMoney(changeLog.getProductChangePrice()));
		changeLogInfo
			.setProductCurrentPrice(MoneyUtil.genMoney(changeLog.getProductCurrentPrice()));
		changeLogInfo.setProductId(changeLog.getProductId());
		changeLogInfo.setRawAddTime(changeLog.getRawAddTime());
	}
	
	public static void convert(DepreciateProductChangeLogDO changeLog,
								ProductChangeLogInfo changeLogInfo) {
		changeLog.setId(changeLogInfo.getId());
		changeLog.setProductChangePrice(changeLogInfo.getProductChangePrice().getCent());
		changeLog.setProductCurrentPrice(changeLogInfo.getProductCurrentPrice().getCent());
		changeLog.setProductId(changeLogInfo.getProductId());
		changeLog.setRawAddTime(changeLogInfo.getRawAddTime());
	}
	
	public static void convertInfos(List<ProductChangeLogInfo> changeLogInfos,
									List<DepreciateProductChangeLogDO> changeLogs) {
		for (DepreciateProductChangeLogDO _changeLog : changeLogs) {
			ProductChangeLogInfo changeLogInfo = new ProductChangeLogInfo();
			convert(changeLogInfo, _changeLog);
			changeLogInfos.add(changeLogInfo);
		}
		
	}
	
	public static void convertDOs(List<DepreciateProductChangeLogDO> changeLogs,
									List<ProductChangeLogInfo> changeLogInfos) {
		
		for (ProductChangeLogInfo _changeLogInfo : changeLogInfos) {
			DepreciateProductChangeLogDO changeLog = new DepreciateProductChangeLogDO();
			convert(changeLog, _changeLogInfo);
			changeLogs.add(changeLog);
		}
	}
}
