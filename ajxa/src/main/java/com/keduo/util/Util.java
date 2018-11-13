package com.keduo.util;


public class Util {

	/**
	 * 判断字符串（trim 去空格之后）是否为 空
	 * @param str
	 * @return ture 为空的，长度为0 的字符串，也是 空的 ； false 字符串不空，且长度不为0（trim 去空之后）
	 */
	public static boolean isNull(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}

