/**
 * www.peigen.info Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.misc.image;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.web.depreciate.service.enums.DepreciateResultEnum;
import com.peigen.web.depreciate.service.enums.ProductPicQualityEnum;
import com.peigen.web.depreciate.service.exception.DepreciateException;
import com.peigen.web.depreciate.service.info.PicBucketInfo;

/**
 *                       
 * @Filename PicBucketServiceImpl.java
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
 *<li>Date: 2011-11-26</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PicBucketServiceImpl implements PicBucketService {
	
	protected final Logger	logger	= LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UpYun			lowPicBucket;
	
	@Autowired
	private UpYun			midPicBucket;
	
	@Autowired
	private UpYun			highPicBucket;
	
	/**
	 * @param bucket
	 * @see com.peigen.web.depreciate.service.misc.image.PicBucketService#addPic(com.peigen.web.depreciate.service.info.PicBucketInfo)
	 */
	@Override
	public void addPic(PicBucketInfo bucket) {
		
		InputStream is = null;
		try {
			URL url = new URL(bucket.getPicSourceUrl());
			is = url.openStream();
			byte[] imageBytes = IOUtils.toByteArray(is);
			
			for (ProductPicQualityEnum _quality : ProductPicQualityEnum.values()) {
				selectPicBucket(_quality).writeFile(genPicName(bucket), imageBytes);
			}
			
		} catch (Exception e) {
			logger.error("转换bytes出错[url=" + bucket.getPicSourceUrl() + "]", e);
			throw new DepreciateException(DepreciateResultEnum.ADD_PIC_EXCEPTION);
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		
		//		InputStream is = null;
		//		try {
		//			URL url = new URL(bucket.getPicSourceUrl());
		//			is = url.openStream();
		//			byte[] imageBytes = IOUtils.toByteArray(is);
		//			selectPicBucket(bucket.getQuality()).mkDir("/" + bucket.getCategory().code());
		//			selectPicBucket(bucket.getQuality()).writeFile(genPicName(bucket), imageBytes);
		//			is.close();
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		
	}
	
	/**
	 * @param bucket
	 * @see com.peigen.web.depreciate.service.misc.image.PicBucketService#del(com.peigen.web.depreciate.service.info.PicBucketInfo)
	 */
	@Override
	public void del(PicBucketInfo bucket) {
	}
	
	/**
	 * @param bucket
	 * @see com.peigen.web.depreciate.service.misc.image.PicBucketService#find(com.peigen.web.depreciate.service.info.PicBucketInfo)
	 */
	@Override
	public void find(PicBucketInfo bucket) {
	}
	
	/**
	 * @param quality
	 * @param dirPath
	 * @see com.peigen.web.depreciate.service.misc.image.PicBucketService#mkdir(com.peigen.web.depreciate.service.enums.ProductPicQualityEnum, java.lang.String)
	 */
	@Override
	public void mkdir(ProductPicQualityEnum quality, String dirPath) {
		try {
			selectPicBucket(quality).mkDir(dirPath);
		} catch (Exception e) {
			logger.error("", e);
			throw new DepreciateException(DepreciateResultEnum.MKDIR_EXCEPTION);
		}
	}
	
	// 内部方法
	private UpYun selectPicBucket(ProductPicQualityEnum quality) {
		if (quality == ProductPicQualityEnum.LOW) {
			return lowPicBucket;
		}
		
		if (quality == ProductPicQualityEnum.MID) {
			return midPicBucket;
		}
		
		if (quality == ProductPicQualityEnum.HIGH) {
			return highPicBucket;
		}
		
		return highPicBucket;
	}
	
	private String genPicName(PicBucketInfo bucket) {
		
		String picName = DepreciateConstants.SEPARATOR_CHAR_SLASH + bucket.getCategory().code()
							+ DepreciateConstants.SEPARATOR_CHAR_SLASH + bucket.getPicName();
		
		return picName;
	}
	
}
