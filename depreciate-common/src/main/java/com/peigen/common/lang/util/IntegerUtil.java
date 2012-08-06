package com.peigen.common.lang.util;

/**
 *                       
 * @Filename: IntegerUtil.java
 *
 * @Description: 
 *
 * @Version: 1.0
 *
 * @Author: peigen
 *
 * @Email: peigen123@gmail.com
 *
 *       
 * @History:<br>
 *<li>Author: peigen</li>
 *<li>Date: 2011-8-2</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class IntegerUtil {

    /**
     * String to Int 空字符串返回0
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        return StringUtil.isNotBlank(str) ? Integer.valueOf(str) : 0;
    }
}
