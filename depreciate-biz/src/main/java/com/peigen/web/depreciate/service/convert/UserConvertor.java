/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.service.convert;

import java.util.List;

import com.peigen.web.depreciate.depreciate.dal.dataobject.DepreciateUserDO;
import com.peigen.web.depreciate.service.enums.UserStatusEnum;
import com.peigen.web.depreciate.service.info.UserInfo;

/**
 *                       
 * @Filename UserConvertor.java
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
 *<li>Date: 2011-11-12</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UserConvertor {
	
	public static void convert(UserInfo userInfo, DepreciateUserDO user) {
		
		userInfo.setId(user.getId());
		userInfo.setRawAddTime(user.getRawAddTime());
		userInfo.setRawUpdateTime(userInfo.getRawUpdateTime());
		userInfo.setStatus(UserStatusEnum.getByCode(user.getStatus()));
		userInfo.setUserName(user.getUserName());
		userInfo.setUserPasswd(user.getUserPasswd());
		userInfo.setEmail(user.getUserEmail());
		
	}
	
	public static void convert(DepreciateUserDO user, UserInfo userInfo) {
		user.setId(userInfo.getId());
		user.setRawAddTime(userInfo.getRawAddTime());
		user.setRawUpdateTime(user.getRawUpdateTime());
		user.setStatus(userInfo.getStatus().code());
		user.setUserName(userInfo.getUserName());
		user.setUserPasswd(userInfo.getUserPasswd());
		user.setUserEmail(userInfo.getEmail());
	}
	
	public static void convert(List<UserInfo> userInfos, List<DepreciateUserDO> users) {
		for (DepreciateUserDO _user : users) {
			UserInfo userInfo = new UserInfo();
			convert(userInfo, _user);
			userInfos.add(userInfo);
		}
	}
}
