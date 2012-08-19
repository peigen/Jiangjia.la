/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.misc.image;

import com.peigen.web.depreciate.service.enums.ProductPicQualityEnum;
import com.peigen.web.depreciate.service.info.PicBucketInfo;

/**
 *                       
 * @Filename PicBucketService.java
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
 *<li>Date: 2011-11-26</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface PicBucketService {
	
	public void addPic(PicBucketInfo bucket);
	
	public void del(PicBucketInfo bucket);
	
	public void find(PicBucketInfo bucket);
	
	/**
	 * 例如：
	 * String dirPath = "M18";
	 * 
	 * @param quality
	 * @param dirPath
	 */
	public void mkdir(ProductPicQualityEnum quality, String dirPath);
}
