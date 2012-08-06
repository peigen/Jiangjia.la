/**
 * jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.util;

import org.slf4j.Logger;

/**
 *                       
 * @Filename PrintLogTool.java
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
 *<li>Date: 2011-10-29</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PrintLogTool {
	
	/**
	 * info日志
	 * @param logStr
	 * @param logger
	 */
	public static void info(String logStr, Logger logger) {
		if (logger.isInfoEnabled()) {
			logger.info(logStr);
		}
	}
	
	/**
	 * debug日志
	 * @param logStr
	 * @param logger
	 */
	public static void debug(String logStr, Logger logger) {
		if (logger.isDebugEnabled()) {
			logger.debug(logStr);
		}
	}
	
}
