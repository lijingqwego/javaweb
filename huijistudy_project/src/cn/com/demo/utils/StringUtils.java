package cn.com.demo.utils;

public class StringUtils {
	
	public static String appendStr(String[] strArr){
		String str="";
		if(strArr!=null){
			for(String s:strArr){
				str=str+s+",";
			}
			str=str.substring(0, str.length()-1);
		}
		return str;
	}
}
