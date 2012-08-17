/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import java.security.MessageDigest;

/**
 *                       
 * @Filename MD5Util.java
 *
 * @Description 主要用于MD5算法的实现,使用java的MessageDigest<br/>
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
public class MD5Util {
	private final static String[]	hexDigits	= { "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "a", "b", "c", "d", "e", "f"	};
	
	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}
	
	public static void main(String[] args) {
		System.err.println(MD5Encode("peigen"));
		System.err.println("aebf1196ba695a49e5955c928a02628a".length());
	}
	
}
