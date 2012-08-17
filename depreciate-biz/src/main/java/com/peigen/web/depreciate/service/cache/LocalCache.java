/**
 * www.peigen.info Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.cache;

/**
 *                       
 * @Filename LocalCache.java
 *
 * @Description 本地缓存必须实现的接口,提供刷新机制；减少大量的远程访问开销
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-25</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public interface LocalCache {
	
	public static final String	SEPARATOR	= "-----------------------";
	
	public static final String	ENTERSTR	= "\n";
	
	/**
	 * 初始化本地缓存
	 */
	void initLocalCache();
	
	/**
	 * 刷新本地缓存信息
	 */
	void refreshLocalCache();
	
	/**
	 * 获取本地缓存的名称
	 * @return
	 */
	String getLocalCacheName();
	
	/**
	 * 打印缓存信息
	 * @return
	 */
	void dump();
}
