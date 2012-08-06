package com.peigen.web.depreciate.service.misc.image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.peigen.common.lang.util.DepreciateConstants;

/**
 *                       
 * @Filename UpYun.java
 *
 * @Description 
 * 
 * 
 * API 接口地址：
 * http://v1.api.upyun.com (电信）
 * http://v2.api.upyun.com (联通网通)
 * http://v3.api.upyun.com (移动铁通)
 * http://v0.api.upyun.com (自动判断）
 *
 * @Version 1.0
 *
 * @Author yinsha
 *
 * @Email yinsha@mbaobao.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2011-11-26</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class UpYun {
	protected String	bucketName	= null;
	protected String	userName	= null;
	protected String	password	= null;
	protected int		timeout		= 10 * 1000;
	public boolean		debug		= false;
	
	protected String	apiDomain	= "v0.api.upyun.com";
	
	public UpYun(String bucketName, String userName, String password) {
		this.bucketName = bucketName;
		this.userName = userName;
		this.password = md5(password);
	}
	
	public void setApiDomain(String domain) {
		this.apiDomain = domain;
	}
	
	public String getGMTDate() {
		SimpleDateFormat formater = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'",
			Locale.US);
		formater.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formater.format(new Date());
	}
	
	public static String md5(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		md5.update(str.getBytes());
		byte[] encodedValue = md5.digest();
		int j = encodedValue.length;
		char finalValue[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte encoded = encodedValue[i];
			finalValue[k++] = hexDigits[encoded >> 4 & 0xf];
			finalValue[k++] = hexDigits[encoded & 0xf];
		}
		
		return new String(finalValue);
	}
	
	private static String getText(HttpURLConnection conn) throws IOException {
		String text = "";
		
		InputStream is = null;
		InputStreamReader sr = null;
		BufferedReader br = null;
		try {
			is = conn.getInputStream();
			sr = new InputStreamReader(is);
			br = new BufferedReader(sr);
			String line = br.readLine();
			while (line != null) {
				text += "\n" + line;
				line = br.readLine();
			}
		} finally {
			if (br != null) {
				br.close();
			}
			if (sr != null) {
				sr.close();
			}
			if (is != null) {
				is.close();
			}
		}
		
		return text;
	}
	
	private String sign(HttpURLConnection conn, String uri, long length) {
		String sign = conn.getRequestMethod() + "&" + uri + "&" + conn.getRequestProperty("Date")
						+ "&" + length + "&" + password;
		return "UpYun " + userName + ":" + md5(sign);
	}
	
	private String HttpAction(String method, String uri, byte[] datas) {
		String result = null;
		boolean is_folder = false;
		try {
			if (datas.length == 11 && (new String(datas, 0, 11, "GBK")).equals("folder:true")) {
				is_folder = true;
				datas = null;
			}
		} catch (Exception e) {
		}
		try {
			URL url = new URL("http://" + apiDomain + uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(timeout);
			conn.setRequestMethod(method);
			conn.setUseCaches(false);
			conn.setRequestProperty("Date", getGMTDate());
			if (is_folder) {
				conn.setRequestProperty("Folder", "true");
				conn.setDoOutput(true);
			}
			long length = 0;
			if (datas == null)
				conn.setRequestProperty("Content-Length", "0");
			else {
				length = datas.length;
				conn.setRequestProperty("Content-Length", String.valueOf(datas.length));
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("Authorization", sign(conn, uri, length));
			try {
				conn.connect();
				if (datas != null) {
					OutputStream os = conn.getOutputStream();
					try {
						os.write(datas);
						os.flush();
					} finally {
						if (os != null) {
							os.close();
						}
					}
				}
				if (is_folder) {
					OutputStream os = conn.getOutputStream();
					os.flush();
				}
				result = getText(conn);
			} finally {
				if (conn != null) {
					conn.disconnect();
					conn = null;
				}
			}
		} catch (IOException e) {
			if (debug)
				e.printStackTrace();
			return null;
		}
		return result;
	}
	
	private String HttpAction(String method, String uri) {
		return HttpAction(method, uri, null);
	}
	
	public long getFolderUsage(String path) throws Exception {
		String result = HttpAction("GET", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName
											+ path + "/?usage");
		try {
			return Long.parseLong(result.trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public long getBucketUsage() throws Exception {
		return getFolderUsage("");
	}
	
	public boolean writeFile(String file, byte[] datas) throws Exception {
		return HttpAction("PUT", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + file,
			datas) != null;
	}
	
	public boolean writeFile(String file, String datas) throws Exception {
		return HttpAction("PUT", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + file,
			datas.getBytes()) != null;
	}
	
	public boolean writeFile(String file, InputStream fis) throws Exception {
		try {
			URL url = new URL("http://" + apiDomain + DepreciateConstants.SEPARATOR_CHAR_SLASH
								+ bucketName + file);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(timeout);
			conn.setRequestMethod("PUT");
			conn.setUseCaches(false);
			conn.setRequestProperty("Date", getGMTDate());
			conn.setDoOutput(true);
			conn.setRequestProperty(
				"Authorization",
				sign(conn, DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + file,
					fis.available()));
			try {
				conn.connect();
				
				OutputStream os = conn.getOutputStream();
				byte[] data = new byte[4096];
				try {
					int temp = 0;
					while ((temp = fis.read(data)) != -1) {
						os.write(data, 0, temp);
					}
				} finally {
					os.flush();
					if (os != null) {
						os.close();
					}
				}
				
				getText(conn);
			} finally {
				if (conn != null) {
					conn.disconnect();
					conn = null;
				}
			}
			return true;
		} catch (IOException e) {
			if (debug)
				e.printStackTrace();
			return false;
		}
	}
	
	public String readFile(String file) throws Exception {
		return HttpAction("GET", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + file);
	}
	
	public boolean deleteFile(String file) throws Exception {
		return HttpAction("DELETE", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + file) != null;
	}
	
	public boolean delDir(String folder) throws Exception {
		return HttpAction("DELETE", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName + folder) != null;
	}
	
	public boolean mkDir(String folder) throws Exception {
		String a = "folder:true";
		return HttpAction("PUT", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName
									+ DepreciateConstants.SEPARATOR_CHAR_SLASH + folder,
			a.getBytes()) != null;
	}
	
	public List<FolderItem> readDir(String path) throws Exception {
		String result = HttpAction("GET", DepreciateConstants.SEPARATOR_CHAR_SLASH + bucketName
											+ path + DepreciateConstants.SEPARATOR_CHAR_SLASH);
		List<FolderItem> list = new LinkedList<FolderItem>();
		String[] datas = result.split("\n");
		for (int i = 0; i < datas.length; i++)
			list.add(new FolderItem(datas[i]));
		return list;
	}
	
	public class FolderItem {
		public String	name;
		public String	type;
		public long		size;
		public Date		date;
		
		public FolderItem(String data) {
			String[] a = data.split("\t");
			if (a.length == 4) {
				this.name = a[0];
				this.type = (a[1] == "N" ? "File" : "Folder");
				try {
					this.size = Long.parseLong(a[2].trim());
				} catch (NumberFormatException e) {
					this.size = -1;
				}
				long da = 0;
				try {
					da = Long.parseLong(a[3].trim());
				} catch (NumberFormatException e) {
				}
				this.date = new Date(da * 1000);
			}
		}
	}
}
