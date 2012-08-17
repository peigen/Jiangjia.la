package com.peigen.common.lang.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {
	
	public static void addCookies(HttpServletResponse response, Cookie cookie, 
									int time) {
		cookie.setMaxAge(time);
		response.addCookie(cookie);
	}
	
	public static void removeCookie(HttpServletResponse response, Cookie cookie,
									String key) {
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public static String getCookieByName(HttpServletRequest request, String name) {
		
		Map<String, Cookie> cookieMap = readCookieMap(request);
		
		if (cookieMap.containsKey(name)) {
			
			Cookie cookie = (Cookie) cookieMap.get(name);
			
			return null == cookie ? null : cookie.getValue();
		} else {
			return null;
		}
	}
	
	private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
}