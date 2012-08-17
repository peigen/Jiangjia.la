/**
 * www.jiangjia.la Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.peigen.web.depreciate.test.service.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peigen.common.lang.util.ArrayUtil;
import com.peigen.common.lang.util.StringUtil;
import com.peigen.web.depreciate.service.info.UserAttentionInfo;
import com.peigen.web.depreciate.service.misc.email.SendMail;
import com.peigen.web.depreciate.service.result.BatchUserAttentionResult;
import com.peigen.web.depreciate.test.annotation.DepreciateTestAnnotated;
import com.peigen.web.depreciate.test.base.DepreciateServiceTestBase;

/**
 *                       
 * @Filename SendMailTest.java
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
public class SendMailTest extends DepreciateServiceTestBase {
	private static Logger	logger	= LoggerFactory.getLogger(SendMail.class);
	
	@DepreciateTestAnnotated(description = "邮件发送测试")
	public void testMail() {
		
		// gmail
		String host = "smtp.gmail.com";
		String from = "jiangjia.la.vip@gmail.com";
		String username = "jiangjia.la.vip";
		String password = "peigen*8";
		
		String mailTo = "peigen123@gmail.com";
		String subject = "一封测试邮件";
		
		HtmlEmail email = new HtmlEmail();
		
		String htmlMsg = genMsgFromTemplate();
		
		try {
			fillInMail(email, host, subject, from, mailTo, username, password);
			
			sendHtmlMail(email, htmlMsg);
		} catch (Exception e) {
			logger.error("", e);
		}
		
	}
	
	public void sendHtmlMail(HtmlEmail email, String htmlMsg) throws EmailException,
																MalformedURLException {
		
		// set the html message
		email.setHtmlMsg(htmlMsg);
		
		// set the alternative message
		email.setTextMsg("看不到的是2B青年");
		
		// send the email
		email.send();
		
	}
	
	private void fillInMail(Email email, String host, String subject, String from, String mailTo,
							String username, String password) throws EmailException {
		email.setAuthentication(username, password);
		email.setHostName(host);
		email.addTo(mailTo, from);
		email.setFrom(from);
		email.setSubject(subject);
		
		// gmail ssl
		isGmail(email, host);
		
		//注意，发送内容时，后面这段会让中文正常显示，否则乱码
		email.setCharset("GBK");
	}
	
	/**
	 * @param email
	 * @param host
	 */
	private void isGmail(Email email, String host) {
		
		String[] hostArr = StringUtil.split(host, ".");
		if (ArrayUtil.contains(hostArr, "gmail")) {
			//			email.setSSL(true);
			email.setTLS(true);
			email.setSmtpPort(587);
			//			email.setDebug(true);
		}
	}
	
	private String genMsgFromTemplate() {
		String htmlMsg = "";
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(
				"/Users/peigen/Dropbox/project/降价啦/emailTemplate.html"));
			
			String str;
			while ((str = in.readLine()) != null) {
				htmlMsg += str;
			}
			in.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		Document doc = Jsoup.parse(htmlMsg);
		Element element = doc.select("#mailContent").first();
		fillElement(element);
		print(element);
		
		return doc.toString();
	}
	
	private void fillElement(Element element) {
		BatchUserAttentionResult result = userAttentionQueryService
			.loadUserAttentions("2011111800000001");
		for (UserAttentionInfo _userAttentionInfo : result.getUserAttentions()) {
			element.append(addElement(_userAttentionInfo));
		}
	}
	
	private String addElement(UserAttentionInfo userAttentionInfo) {
		String element = "<tr>";
		
		element += "<td>" + userAttentionInfo.getProductInfo().getProductName() + "</td>";
		element += "<td>|</td>";
		
		element += "<td>￥" + userAttentionInfo.getProductInfo().getProductCurrentPrice() + "</td>";
		element += "<td>|</td>";
		
		element += "<td>-5.00</td>";
		
		element += "</tr>";
		return element;
	}
	
}
