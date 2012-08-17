/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.common.lang.util;

import com.peigen.common.lang.util.money.Money;

/**
 *                       
 * @Filename MoneyUtil.java
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
public class MoneyUtil {
	
	public static final Money	ZERO	= new Money(0);
	
	/**
	 * @param amount
	 * @return
	 */
	public static Money genMoney(long amount) {
		// 数据库中的数据是[分]为单位，要转为[圆]为单位
		Money purchase = new Money();
		purchase.setCent(Long.valueOf(amount));
		return purchase;
	}
	
	/**
	 * @param amount
	 * @return
	 */
	public static boolean isGreaterThanNotZero(Money amount) {
		
		if (amount.greaterThan(ZERO)) {
			return true;
		}
		
		return false;
	}
}
