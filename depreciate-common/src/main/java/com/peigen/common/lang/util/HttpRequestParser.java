/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.peigen.common.lang.util.StringUtil;

/**
 *                       
 * @Filename HttpRequestParser.java
 *
 * @Description HttpRequestParser工具类
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen123@gmail.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-18</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@SuppressWarnings("rawtypes")
public class HttpRequestParser {
	/**
	 * 分析url字符串,采用utf-8解码
	 * @param urlString
	 * @return
	 */
	public static Request parse(String urlString) {
		return parse(urlString, "utf-8");
	}
	
	/**
	 * 分析url字符串,指定字符集进行解码
	 * @param urlString
	 * @param enc
	 * @return
	 */
	public static Request parse(String urlString, String enc) {
		if (urlString == null || urlString.length() == 0) {
			return new Request();
		}
		int questIndex = urlString.indexOf('?');
		if (questIndex == -1) {
			return new Request(urlString);
		}
		String url = urlString.substring(0, questIndex);
		String queryString = urlString.substring(questIndex + 1, urlString.length());
		return new Request(url, getParamsMap(queryString, enc));
	}
	
	private static Map<String, String[]> getParamsMap(String queryString, String enc) {
		Map<String, String[]> paramsMap = new HashMap<String, String[]>();
		if (queryString != null && queryString.length() > 0) {
			int ampersandIndex, lastAmpersandIndex = 0;
			String subStr, param, value;
			String[] paramPair, values, newValues;
			
			// 为了应对当当这变态的URL
			queryString = StringUtil.replace(queryString, "#", "&");
			do {
				ampersandIndex = queryString.indexOf('&', lastAmpersandIndex) + 1;
				if (ampersandIndex > 0) {
					subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);
					lastAmpersandIndex = ampersandIndex;
				} else {
					subStr = queryString.substring(lastAmpersandIndex);
				}
				paramPair = subStr.split("=");
				param = paramPair[0];
				value = paramPair.length == 1 ? "" : paramPair[1];
				try {
					value = URLDecoder.decode(value, enc);
				} catch (UnsupportedEncodingException ignored) {
				}
				if (paramsMap.containsKey(param)) {
					values = paramsMap.get(param);
					int len = values.length;
					newValues = new String[len + 1];
					System.arraycopy(values, 0, newValues, 0, len);
					newValues[len] = value;
				} else {
					newValues = new String[] { value };
				}
				paramsMap.put(param, newValues);
			} while (ampersandIndex > 0);
		}
		return paramsMap;
	}
	
	/**
	 * 请求对象
	 * @author yy
	 * @date Jun 21, 2009 2:17:31 PM
	 */
	public static class Request implements HttpServletRequest {
		private String					requestURI;
		private Map<String, String[]>	parameterMap;
		
		Request() {
			this("");
		}
		
		Request(String requestURI) {
			this.requestURI = requestURI;
			parameterMap = new HashMap<String, String[]>();
		}
		
		Request(String requestURI, Map<String, String[]> parameterMap) {
			this.requestURI = requestURI;
			this.parameterMap = parameterMap;
		}
		
		/**
		 * 获得指定名称的参数
		 * @param name
		 * @return
		 */
		public String getParameter(String name) {
			String[] values = parameterMap.get(name);
			if (values != null && values.length > 0) {
				return values[0];
			}
			return null;
		}
		
		/**
		 * 获得所有的参数名称
		 * @return
		 */
		public Enumeration<String> getParameterNames() {
			return Collections.enumeration(parameterMap.keySet());
		}
		
		/**
		 * 获得指定名称的参数值(多个)
		 * @param name
		 * @return
		 */
		public String[] getParameterValues(String name) {
			return parameterMap.get(name);
		}
		
		/**
		 * 获得请求的url地址
		 * @return
		 */
		public String getRequestURI() {
			return requestURI;
		}
		
		/**
		 * 获得 参数-值Map
		 * @return
		 */
		public Map<String, String[]> getParameterMap() {
			return parameterMap;
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("{");
			buf.append("\n  url = ").append(this.requestURI);
			buf.append("\n  paramsMap = {");
			if (this.parameterMap.size() > 0) {
				for (Map.Entry<String, String[]> e : this.parameterMap.entrySet()) {
					buf.append(e.getKey()).append("=").append(Arrays.toString(e.getValue()))
						.append(",");
				}
				buf.deleteCharAt(buf.length() - 1);
			}
			buf.append("}\n}");
			return buf.toString();
		}
		
		//  剩下的函数,自己根据需求实现了,一般返回0或者null即可
		//  这里就不贴了,HttpServletRequest的接口方法也太多了
		
		/**
		 * @param name
		 * @return
		 * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
		 */
		@Override
		public Object getAttribute(String name) {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getAttributeNames()
		 */
		@Override
		public Enumeration getAttributeNames() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getCharacterEncoding()
		 */
		@Override
		public String getCharacterEncoding() {
			return null;
		}
		
		/**
		 * @param env
		 * @throws UnsupportedEncodingException
		 * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
		 */
		@Override
		public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getContentLength()
		 */
		@Override
		public int getContentLength() {
			return 0;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getContentType()
		 */
		@Override
		public String getContentType() {
			return null;
		}
		
		/**
		 * @return
		 * @throws IOException
		 * @see javax.servlet.ServletRequest#getInputStream()
		 */
		@Override
		public ServletInputStream getInputStream() throws IOException {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getProtocol()
		 */
		@Override
		public String getProtocol() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getScheme()
		 */
		@Override
		public String getScheme() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getServerName()
		 */
		@Override
		public String getServerName() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getServerPort()
		 */
		@Override
		public int getServerPort() {
			return 0;
		}
		
		/**
		 * @return
		 * @throws IOException
		 * @see javax.servlet.ServletRequest#getReader()
		 */
		@Override
		public BufferedReader getReader() throws IOException {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getRemoteAddr()
		 */
		@Override
		public String getRemoteAddr() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getRemoteHost()
		 */
		@Override
		public String getRemoteHost() {
			return null;
		}
		
		/**
		 * @param name
		 * @param o
		 * @see javax.servlet.ServletRequest#setAttribute(java.lang.String, java.lang.Object)
		 */
		@Override
		public void setAttribute(String name, Object o) {
		}
		
		/**
		 * @param name
		 * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
		 */
		@Override
		public void removeAttribute(String name) {
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getLocale()
		 */
		@Override
		public Locale getLocale() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getLocales()
		 */
		@Override
		public Enumeration getLocales() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#isSecure()
		 */
		@Override
		public boolean isSecure() {
			return false;
		}
		
		/**
		 * @param path
		 * @return
		 * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
		 */
		@Override
		public RequestDispatcher getRequestDispatcher(String path) {
			return null;
		}
		
		/**
		 * @param path
		 * @return
		 * @deprecated
		 * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
		 */
		@Override
		public String getRealPath(String path) {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getRemotePort()
		 */
		@Override
		public int getRemotePort() {
			return 0;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getLocalName()
		 */
		@Override
		public String getLocalName() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getLocalAddr()
		 */
		@Override
		public String getLocalAddr() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.ServletRequest#getLocalPort()
		 */
		@Override
		public int getLocalPort() {
			return 0;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getAuthType()
		 */
		@Override
		public String getAuthType() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getCookies()
		 */
		@Override
		public Cookie[] getCookies() {
			return null;
		}
		
		/**
		 * @param name
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getDateHeader(java.lang.String)
		 */
		@Override
		public long getDateHeader(String name) {
			return 0;
		}
		
		/**
		 * @param name
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getHeader(java.lang.String)
		 */
		@Override
		public String getHeader(String name) {
			return null;
		}
		
		/**
		 * @param name
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getHeaders(java.lang.String)
		 */
		
		@Override
		public Enumeration getHeaders(String name) {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
		 */
		@Override
		public Enumeration getHeaderNames() {
			return null;
		}
		
		/**
		 * @param name
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getIntHeader(java.lang.String)
		 */
		@Override
		public int getIntHeader(String name) {
			return 0;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getMethod()
		 */
		@Override
		public String getMethod() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getPathInfo()
		 */
		@Override
		public String getPathInfo() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
		 */
		@Override
		public String getPathTranslated() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getContextPath()
		 */
		@Override
		public String getContextPath() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getQueryString()
		 */
		@Override
		public String getQueryString() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
		 */
		@Override
		public String getRemoteUser() {
			return null;
		}
		
		/**
		 * @param role
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#isUserInRole(java.lang.String)
		 */
		@Override
		public boolean isUserInRole(String role) {
			return false;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
		 */
		@Override
		public Principal getUserPrincipal() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
		 */
		@Override
		public String getRequestedSessionId() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getRequestURL()
		 */
		@Override
		public StringBuffer getRequestURL() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getServletPath()
		 */
		@Override
		public String getServletPath() {
			return null;
		}
		
		/**
		 * @param create
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
		 */
		@Override
		public HttpSession getSession(boolean create) {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#getSession()
		 */
		@Override
		public HttpSession getSession() {
			return null;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
		 */
		@Override
		public boolean isRequestedSessionIdValid() {
			return false;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
		 */
		@Override
		public boolean isRequestedSessionIdFromCookie() {
			return false;
		}
		
		/**
		 * @return
		 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
		 */
		@Override
		public boolean isRequestedSessionIdFromURL() {
			return false;
		}
		
		/**
		 * @return
		 * @deprecated
		 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
		 */
		@Override
		public boolean isRequestedSessionIdFromUrl() {
			return false;
		}
	}
}
