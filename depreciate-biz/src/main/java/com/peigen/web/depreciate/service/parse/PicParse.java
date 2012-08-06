/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.parse;

import java.util.ArrayList;
import java.util.List;

import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.info.ProductPicInfo;

/**
 *                       
 * @Filename PicParse.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-29</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PicParse {
	
	public static ProductPicInfo parse(String imgUrl) {
		ProductPicInfo productPicInfo = new ProductPicInfo();
		
		// 默认图片质量高
		productPicInfo.setPicSourceUrl(imgUrl);
		productPicInfo.setPicName(parsePicName(imgUrl));
		
		return productPicInfo;
	}
	
	public static List<ProductPicInfo> parse(List<String> imgUrls) {
		List<ProductPicInfo> picInfos = new ArrayList<ProductPicInfo>();
		
		for (String _imgUrl : imgUrls) {
			ProductPicInfo productPicInfo = parse(_imgUrl);
			
			picInfos.add(productPicInfo);
		}
		
		return picInfos;
	}
	
	// 内部方法
	
	/**
	 * 解析图片名称
	 * @param picSourceUrl
	 * @return
	 */
	private static String parsePicName(String picSourceUrl) {
		
		String[] ss = StringUtil.split(picSourceUrl, DepreciateConstants.SEPARATOR_CHAR_SLASH);
		
		return ss[ss.length - 1];
	}
}
