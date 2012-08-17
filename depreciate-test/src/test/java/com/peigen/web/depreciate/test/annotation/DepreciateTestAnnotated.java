/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *                       
 * @Filename DepreciateTestAnnotated.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-8-1</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DepreciateTestAnnotated {
	
	/** 测试方法描述 */
	String description() default "";
}
