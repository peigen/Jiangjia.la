/**
 * jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.bootstrap;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peigen.common.lang.util.DepreciateConstants;
import com.peigen.common.lang.util.PrintLogTool;

/**
 * 
 * @Filename DepreciateJettyBootStrap.java
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
 *<li>Date: 2011-8-3</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DepreciateJettyBootStrap {
	
	private static final String					PROJECT_NAME	= "depreciate-assemble";
	
	private static final String					WEB_SRC			= PROJECT_NAME + "/src/main/webapp";
	
	private static Logger						logger			= LoggerFactory
																	.getLogger(DepreciateJettyBootStrap.class);
	
	private static String						WEBAPP_PATH		= getWebPath();
	
	private final static int					port			= 8888;
	
	//使用者
	private final static Map<String, String>	hostNameMapping	= new HashMap<String, String>();
	
	public DepreciateJettyBootStrap() {
		hostNameMapping.put("WEBAPP_PATH", WEBAPP_PATH);
		//		hostNameMapping.put("nuomi-PC", NUOMI_WEBAPP_PATH);
	}
	
	public static void main(String[] args) throws Exception {
		new DepreciateJettyBootStrap();
		Server server = new Server();
		QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMaxThreads(100);
		server.setThreadPool(threadPool);
		Connector connector = new SelectChannelConnector();
		connector.setPort(port); //端口
		server.addConnector(connector);
		WebAppContext context = new WebAppContext(WEBAPP_PATH,
			DepreciateConstants.SEPARATOR_CHAR_SLASH);
		
		HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
		server.setHandler(handlers);
		
		server.setStopAtShutdown(true);
		server.setSendServerVersion(true);
		server.start();
		PrintLogTool.info("启动完毕", logger);
		server.join();
		
	}
	
	/**
	 * 
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String loadHostName() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String hostname = addr.getHostName().toString();// 获得本机名称
			PrintLogTool.info(hostname, logger);
			return hostNameMapping.get(hostname);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getWebPath() {
		String currentClassPath = DepreciateJettyBootStrap.class.getResource(
			DepreciateConstants.SEPARATOR_CHAR_SLASH).getPath();
		
		String webPath = currentClassPath.substring(0, currentClassPath.indexOf(PROJECT_NAME))
							+ WEB_SRC;
		return webPath;
	}
}
