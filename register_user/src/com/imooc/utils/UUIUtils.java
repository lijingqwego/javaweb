package com.imooc.utils;

import java.util.UUID;

/**
 * ��������ַ���
 * @author Administrator
 *
 */
public class UUIUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
