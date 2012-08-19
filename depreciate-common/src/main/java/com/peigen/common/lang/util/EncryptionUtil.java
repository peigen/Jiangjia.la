/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 *                       
 * @Filename EncryptionUtil.java
 *
 * @Description 摘要密文工具
 *
 * @Version 1.0
 *
 * @Author karott
 *
 * @Email chenlin@yiji.com
 *       
 * @History
 *<li>Author: karott</li>
 *<li>Date: 2012-7-13</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class EncryptionUtil {
	
	public enum DigestALGEnum {
		SHA, MD5;
	}
	
	public static byte[] digestData(String data, DigestALGEnum alg) {
		
		byte[] cData = new byte[] {};
		try {
			MessageDigest digest = MessageDigest.getInstance(alg.toString());
			
			String firstLetter = data.substring(0, 1);
			String lastLetter = data.substring(data.length() - 1);
			String tmpData = firstLetter + "<|" + data + "|>" + lastLetter;
			
			tmpData = data + tmpData + data;
			digest.update(tmpData.getBytes("UTF8"));
			
			cData = digest.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cData;
	}
	
	public static String digestDataStr(String data, DigestALGEnum alg) {
		return new String(digestData(data, alg));
	}
	
	public static char[] encodeWithHex(byte[] data) {
		return Hex.encodeHex(data);
	}
	
	public static String encodeWithHexStr(String data, DigestALGEnum alg) {
		return new String(encodeWithHex(digestData(data, alg)));
	}
	
	public static String encodeWithHexStrNoDigest(String data) {
		byte[] pData = new byte[] {};
		try {
			pData = data.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(Hex.encodeHex(pData));
	}
	
	public static String decodeWithHexStrNoDigest(String data) {
		char[] cData = new char[] {};
		byte[] pData = new byte[] {};
		try {
			cData = data.toCharArray();
			pData = Hex.decodeHex(cData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(pData);
	}
	
	public static void main(String[] args) {
		//- for tmp
		System.out.println(encodeWithHexStrNoDigest("root86815300"));
		System.err.println(decodeWithHexStrNoDigest(encodeWithHexStrNoDigest("root86815300")));
	}
	
}
