/**
 * mbaobao.com Inc.
 * Copyright (c) 2004-2010 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *                       
 * @Filename SmockClassFinder.java
 *
 * @Description 冒烟测试查找工具类
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
public class SmockClassFinder {
	/**
	 * 根据包名查询所有类，不作包的递归查找。
	 * @param pack
	 * @return
	 */
	public static Set<Class<?>> getClasses(String pack) {
		
		// 第一个class类的集合   
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		// 是否循环迭代   
		boolean recursive = true;
		// 获取包的名字 并进行替换   
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things   
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			// 循环迭代下去   
			while (dirs.hasMoreElements()) {
				// 获取下一个元素   
				URL url = dirs.nextElement();
				// 得到协议的名称   
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上   
				if ("file".equals(protocol)) {
					// 获取包的物理路径   
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中   
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return classes;
	}
	
	/**  
	 * 以文件的形式来获取包下的所有Class  
	 *   
	 * @param packageName  
	 * @param packagePath  
	 * @param recursive  
	 * @param classes  
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath,
														final boolean recursive,
														Set<Class<?>> classes) {
		// 获取此包的目录 建立一个File   
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回   
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("会员定义包名 " + packageName + " 下没有任何文件");   
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录   
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)   
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件   
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描   
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(),
					file.getAbsolutePath(), recursive, classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名   
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					if (className.toLowerCase().contains("test")) {
						Class<?> clazz = Class.forName(packageName + '.' + className);
						if (DepreciateTestBase.class.isAssignableFrom(clazz)
							&& DepreciateTestBase.class != clazz) {
							classes.add(clazz);
						}
					}
				} catch (ClassNotFoundException e) {
					// log.error("添加会员自定义视图类错误 找不到此类的.class文件");   
					e.printStackTrace();
				}
			}
		}
	}
	
}