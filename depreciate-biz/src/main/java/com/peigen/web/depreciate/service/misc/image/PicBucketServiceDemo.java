package com.peigen.web.depreciate.service.misc.image;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.peigen.common.lang.util.DepreciateConstants;

/**
 *                       
 * @Filename PicBucketServiceDemo.java
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
 *<li>Date: 2011-11-26</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PicBucketServiceDemo {
	public static void main(String[] args) throws Exception {
		/// 初始化空间
		UpYun yCloud = new UpYun("pic_high", "jiangjiala_auto", "peigen*8");
		
		/// 设置是否打印调试信息
		//a.debug = true;
		
		/// 获取空间占用大小
		long x = yCloud.getBucketUsage();
		System.out.println("获取空间占用大小" + x);
		
		/// 获取某个目录的空间占用大小
		//		long x = a.getFolderUsage("/aa1");
		
		/// 读取文件
		//		String datas = yCloud.readFile("/屏幕快照 2011-11-21 上午9.26.02.png");
		
		//		 读取目录
		List<UpYun.FolderItem> items = yCloud.readDir(DepreciateConstants.SEPARATOR_CHAR_SLASH);
		for (int i = 0; i < items.size(); i++) {
			System.out.println("删除文件：" + items.get(i).name);
			yCloud.deleteFile(items.get(i).name);
		}
		
		/// 删除目录
		yCloud.delDir("/test");
		
		/// 创建目录
		yCloud.mkDir("/test");
		
		/// 上传文件
		//		File file = new File("/Users/peigen/Pictures/snapshot/屏幕快照 2011-11-21 上午9.26.02.png");
		//		FileInputStream is = new FileInputStream(file);
		
		// 上传模式 1
		//		byte[] data = new byte[(int) file.length()];
		//		is.read(data, 0, (int) file.length());
		//		is.close();
		//		System.out.println(a.writeFile("/屏幕快照 2011-11-21 上午9.26.02.png", data));
		
		// 上传模式 2
		//		System.out.println(yCloud.writeFile("/test/屏幕快照 2011-11-21 上午9.26.02.png", is));
		
		URL url = new URL("http://img.m18.com/GOODS/LARGE/N10100/GZ1B0475B33012.JPG");
		
		InputStream is = null;
		try {
			is = url.openStream();
			byte[] imageBytes = IOUtils.toByteArray(is);
			yCloud.writeFile("/GZ1B0475B33012.JPG", imageBytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
		}
		
	}
}