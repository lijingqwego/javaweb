package com.imooc.utils;

import java.util.UUID;

/**
 * Éú³ÉËæ»ú×Ö·û´®
 * @author Administrator
 *
 */
public class UUIUtils {
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
