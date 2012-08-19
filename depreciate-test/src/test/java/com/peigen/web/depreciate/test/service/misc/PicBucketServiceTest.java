/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.misc;

import org.springframework.beans.factory.annotation.Autowired;

import com.peigen.web.depreciate.service.enums.ProductPicQualityEnum;
import com.peigen.web.depreciate.service.enums.TrackCategoryEnum;
import com.peigen.web.depreciate.service.info.PicBucketInfo;
import com.peigen.web.depreciate.service.misc.image.UpYun;
import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename PicBucketServiceTest.java
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
public class PicBucketServiceTest extends DepreciateServiceTestBase {
	
	@Autowired
	private UpYun	lowPicBucket;
	
	@Autowired
	private UpYun	midPicBucket;
	
	@Autowired
	private UpYun	highPicBucket;
	
	@DepreciateTestAnnotated(description = "Yupoo云存储测试用例---成功用例")
	public void testAddPic() {
		
		initDir();
		String picName = "GZ1B0475B33012.JPG";
		String picSourceUrl = "http://img.m18.com/GOODS/LARGE/N10100/GZ1B0475B33012.JPG";
		
		PicBucketInfo bucket = new PicBucketInfo(picName, ProductPicQualityEnum.HIGH,
			TrackCategoryEnum.M18, "test_product", picSourceUrl);
		
		picBucketService.addPic(bucket);
		
	}
	
	private void initDir() {
		try {
			for (TrackCategoryEnum _category : TrackCategoryEnum.values()) {
				
				lowPicBucket.mkDir(_category.code());
				midPicBucket.mkDir(_category.code());
				highPicBucket.mkDir(_category.code());
			}
		} catch (Exception e) {
			logger.error("", e);
		}
	}
}
