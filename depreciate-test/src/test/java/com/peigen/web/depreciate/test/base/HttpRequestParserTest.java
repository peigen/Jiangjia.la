/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.base;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.peigen.common.lang.util.HttpRequestParser;

/**
 *                       
 * @Filename HttpRequestParserTest.java
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
 *<li>Date: 2011-11-18</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class HttpRequestParserTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String href = "http://127.0.0.1/xxx/yyy.do?id=A00509062015035396&chinese=%E4%B8%AD%E6%96%87%E5%8F%82%E6%95%B0OK"
						+ "&hobby=A&hobby=B&hobby=C"
						+ "&backUrl=http%3A%2F%2F127.0.0.1%2Fxxx%2Flist.do%3Fsearch_name%3D%25E5%258F%25B6%25E6%25B0%25B8%26page%3D4%26order%3Dusername%2Basc";
		
		HttpServletRequest request = HttpRequestParser.parse(href);
		System.out.println(request);
		System.out.println("full URL:     " + href);
		System.out.println("request URL:  " + request.getRequestURL());
		System.out.println("id:           " + request.getParameter("id"));
		System.out.println("chinese:      " + request.getParameter("chinese"));
		System.out.println("hobbies:      " + Arrays.toString(request.getParameterValues("hobby")));
		System.out.println("backUrl:      " + request.getParameter("backUrl"));
		
		System.out.println();
		String backUrl = request.getParameter("backUrl");
		request = HttpRequestParser.parse(backUrl);
		System.out.println(request);
		System.out.println("full URL:     " + backUrl);
		System.out.println("request URL:  " + request.getRequestURL());
		System.out.println("search name:  " + request.getParameter("search_name"));
		System.out.println("page:         " + request.getParameter("page"));
		System.out.println("order:        " + request.getParameter("order"));
		System.out.println("Server name   " + request.getServerName());
		
	}
}
//  输出结果:  显示比较乱..一行显示字数太少造成
// 
//  {
//    url = http://127.0.0.1/xxx/yyy.do
//    paramsMap = {chinese=[中文参数OK],hobby=[A, B, C],backUrl=[http://127.0.0.1/xxx/list.do?search_name=%E5%8F%B6%E6%B0%B8&page=4&order=username+asc],id=[A00509062015035396]}
//  }
//  full URL:     http://127.0.0.1/xxx/yyy.do?id=A00509062015035396&chinese=%E4%B8%AD%E6%96%87%E5%8F%82%E6%95%B0OK&hobby=A&hobby=B&hobby=C&backUrl=http%3A%2F%2F127.0.0.1%2Fxxx%2Flist.do%3Fsearch_name%3D%25E5%258F%25B6%25E6%25B0%25B8%26page%3D4%26order%3Dusername%2Basc
//  request URL:  http://127.0.0.1/xxx/yyy.do
//  id:           A00509062015035396
//  chinese:      中文参数OK
//  hobbies:      [A, B, C]
//  backUrl:      http://127.0.0.1/xxx/list.do?search_name=%E5%8F%B6%E6%B0%B8&page=4&order=username+asc
//
//  {
//    url = http://127.0.0.1/xxx/list.do
//    paramsMap = {page=[4],search_name=[叶永],order=[username asc]}
//  }
//  full URL:     http://127.0.0.1/xxx/list.do?search_name=%E5%8F%B6%E6%B0%B8&page=4&order=username+asc
//  request URL:  http://127.0.0.1/xxx/list.do
//  search name:  叶永
//  page:         4
//  order:        username asc

