package com.cn.business.comm;

import java.io.File;
import java.net.URISyntaxException;


/**
 * <p>
 * Title: Tools
 * Description: 字符串处理公共组件
 * Copyright: Copyright (c) 2007
 * Company: huawei technology Co. Ltd
 * @author pyj
 * @version 1.0
 */

public class Tools {
	/**
	 * 判断字符串是否为空
	 * @param o
	 * @return boolean
	 */
	public static boolean isEmpty(Object str) {
		if (null == str || "".equals(str) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 空对象处理
	 */
	public static String checkNull(Object ob) {
		if ((null == ob) || ("null".equals(ob)) || ("".equals(ob))) {
			return "";
		} else {
			return ob.toString();
		}
	}
	
	public static void logToControl(String outMode, Object outInfo) {
		// 传入ERR则打印红色字体调试信息
		if ("err".equals(outMode)) {
			System.err.println(outInfo);
		} else {
			 System.out.println(outInfo);
		}
	}
	/*
	 * 得到工程路径：java工程路径
	 */
	public static String getClassPath() {
		String path = "";
		try {
			path = System.getProperty("user.dir");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return path;
	}
	

	
	 // 得到ClassPath的绝对路径:web 工程classes路径
    public static String getWebClassPath() {
        String result = null;
        try {
            File file = new File(Tools.class.getClassLoader().getResource("/").toURI());
            result = file.getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }


   
    
	
	/**
	 * 中文转换
	 * 
	 * @param tmpStr
	 *            string
	 * @return string
	 */
	public static String toChinese(String strvalue) {
		try {
			if (null == strvalue)
				return "";
			else {
				strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
				return strvalue;
			}
		} catch (Exception e) {
			return "";
		}

	}

	public static void main(String args[])
	{
		
		

		
		
	}
}
