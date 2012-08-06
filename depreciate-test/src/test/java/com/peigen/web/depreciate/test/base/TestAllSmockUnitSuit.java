package com.peigen.web.depreciate.test.base;

import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *                       
 * @Filename TestAllSmockUnitSuit.java
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
 *<li>Date: 2011-11-19</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class TestAllSmockUnitSuit {
	
	private final static String[]	pkgs	= { "com.peigen.web.depreciate.test.dal",
			"com.peigen.web.depreciate.test.service.parse",
			"com.peigen.web.depreciate.test.service.api" };
	
	/**
	 * 运行包名下的所有单元测试
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for lottery");
		
		Set<Class<?>> smockClasses = new LinkedHashSet<Class<?>>();
		for (String pkg : pkgs) {
			smockClasses.addAll(SmockClassFinder.getClasses(pkg));
		}
		
		for (Class<?> clazz : smockClasses) {
			suite.addTestSuite((Class<? extends TestCase>) clazz);
		}
		
		return suite;
	}
	
}