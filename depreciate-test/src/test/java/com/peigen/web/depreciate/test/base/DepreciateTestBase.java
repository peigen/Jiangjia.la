/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.peigen.common.lang.util.DateUtil;
import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.common.lang.util.PrintLogTool;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.depreciate.dal.daointerface.ExtraDAO;
import com.peigen.web.depreciate.service.result.Result;
import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;

/**
 *                       
 * @Filename DepreciateTestBase.java
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
 *<li>Date: 2011-11-11</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-test.xml" })
public abstract class DepreciateTestBase extends AbstractJUnit38SpringContextTests {
	
	protected final Logger	logger					= LoggerFactory.getLogger(getClass());
	
	protected final String	TEST_NAME				= "peigen测试用例专用";
	
	protected final String	TEST_USER_NAME			= "peigen";
	protected final String	TEST_USER_PASSWD		= "peigen";
	
	protected final String	TEST_URL_MBAOBAO		= "http://item.mbaobao.com/pshow-1011600203.html?l=hc-r";
	protected final String	TEST_URL_M18			= "http://product.m18.com/p-SU113967.htm";
	protected final String	TEST_URL_DANGDANG		= "http://product.dangdang.com/Product.aspx?product_id=1263678801#ref=www-0-H";
	
	protected final String	TEST_CATEGORY_MBAOBAO	= "1011600203";
	
	// DAO
	@Autowired
	protected ExtraDAO		extraDAO;
	
	@Override
	protected void runTest() throws Throwable {
		// Some VMs crash when calling getMethod(null,null);
		assertNotNull(getName());
		
		Method runMethod = null;
		try {
			// use getMethod to get all public inherited
			// methods. getDeclaredMethods returns all
			// methods of this class but excludes the
			// inherited ones.
			runMethod = getClass().getMethod(getName(), (Class[]) null);
			
		} catch (NoSuchMethodException e) {
			fail("Method \"" + getName() + "\" not found");
		}
		if (!Modifier.isPublic(runMethod.getModifiers())) {
			fail("Method \"" + getName() + "\" should be public");
		}
		
		try {
			
			//取得注解
			DepreciateTestAnnotated test = runMethod.getAnnotation(DepreciateTestAnnotated.class);
			
			if (test != null && StringUtil.isNotBlank(test.description())) {
				
				PrintLogTool.info("=====================================", logger);
				
				PrintLogTool.info("|" + test.description() + " start:", logger);
				
				PrintLogTool.info("|-" + "[" + getClass().getSimpleName() + "." + getName() + "]",
					logger);
				
				PrintLogTool.info("=====================================\n", logger);
			}
			
			runMethod.invoke(this, (Object[]) new Class[0]);
			
			if (test != null && StringUtil.isNotBlank(test.description())) {
				PrintLogTool.info("=====================================", logger);
				
				PrintLogTool.info("|" + test.description() + " end.", logger);
				
				PrintLogTool.info("|-" + "[" + getClass().getSimpleName() + "." + getName() + "]",
					logger);
				
				PrintLogTool.info("=====================================\n", logger);
			}
			
		} catch (InvocationTargetException e) {
			e.fillInStackTrace();
			throw e.getTargetException();
		} catch (IllegalAccessException e) {
			e.fillInStackTrace();
			throw e;
		}
	}
	
	// 内部方法
	
	/**
	 * @param result
	 */
	protected void assertResult(Result result) {
		print(result);
		assertTrue(result.isExecuted());
		assertTrue(result.isSuccess());
	}
	
	/**
	 * 打印输出
	 * 
	 * @param object
	 */
	protected void print(Object object) {
		String str = "";
		if (object == null) {
			
			str = "null";
		} else {
			str = object.toString();
		}
		
		logger.info("=====================================");
		logger.info(str);
		logger.info("=====================================");
	}
	
	protected Date getSysDate() {
		return extraDAO.getSysdate();
	}
	
	protected Date now() {
		return DateUtil.now();
	}
	
	protected Date tomorrow() {
		return DateUtil.tomorrow();
	}
	
	protected String genId() {
		return String.valueOf(System.currentTimeMillis());
	}
	
	/**
	 * 操作系统环境判断。
	 * 
	 * @return
	 */
	protected static boolean isUnix() {
		boolean isLinux = false;
		URL resource = DepreciateTestBase.class.getResource("DepreciateTestBase.class");
		String classPath = resource.getPath();
		String className = DepreciateTestBase.class.getName().replace('.', '/') + ".class";
		String classesPath = classPath.substring(0, classPath.indexOf(className));
		if (System.getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1
			&& classesPath.startsWith(DepreciateConstants.SEPARATOR_CHAR_SLASH)) {
			classesPath = classesPath.substring(1);
			isLinux = false;
		} else {
			isLinux = true;
		}
		return isLinux;
	}
	
	/**
	 * 序列化对象。
	 * 
	 * @param object
	 */
	protected void writeObject(Object object) {
		
		if (isUnix()) {
			writeObject(object, "/tmp/tmp.txt");
		} else {
			writeObject(object, "C:\\tmp.txt");
		}
	}
	
	/**
	 * 反序列化。
	 * 
	 * @return
	 */
	protected Object readObject() {
		
		if (isUnix()) {
			return readObject("/tmp/tmp.txt");
		} else {
			return readObject("C:\\tmp.txt");
		}
	}
	
	/**
	 * 删除序列化对象文件。
	 * 
	 */
	protected void deleteObject() {
		if (isUnix()) {
			deleteObject("/tmp/tmp.txt");
		} else {
			deleteObject("C:\\tmp.txt");
		}
	}
	
	/**
	 * 序列化对象。
	 * 
	 * @param object
	 * @param file
	 */
	protected void writeObject(Object object, String file) {
		
		try {
			// 先确保删除文件
			File f = new File(file);
			
			f.createNewFile();
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(object);
			out.close();
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	/**
	 * 反序列化。
	 * 
	 * @return
	 */
	protected Object readObject(String file) {
		Object object = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			
			object = (Object) in.readObject();
			in.close();
		} catch (Exception e) {
			logger.error("", e);
		}
		return object;
	}
	
	/**
	 * 删除序列化对象文件。
	 * 
	 * @param object
	 * @param file
	 */
	protected void deleteObject(String file) {
		
		try {
			File f = new File(file);
			
			f.deleteOnExit();
			
		} catch (Exception e) {
			
			if (logger.isWarnEnabled())
				logger.warn("删除序列化对象出错：", e);
		}
	}
	
}
