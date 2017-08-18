package cn.com.demo.utils;

import java.util.Arrays;
import java.util.List;

public class AuthorityFunctionUtils {
		
	public static String appendCode(String[] strArr){
		String str="";
		if(strArr!=null){
			for(String s:strArr){
				str=str+s+",";
			}
			str=str.substring(0, str.length()-1);
		}
		return str;
	}
	
	public static String appendName(String[] strArr){
		String str="";
		
		/*if(strArr!=null){
			for(int i=0;i<Function.values().length;i++){
				for(int j=0;j<strArr.length;j++){
					if(strArr[j].equals(String.valueOf(i+1))){
						str=str+Function.values()[i].getValue()+",";
					}
				}
			}
			str=str.substring(0, str.length()-1);
		}*/
		
		List<String> list = Arrays.asList(strArr);
		Function[] functions = Function.values();
		if(strArr!=null){
			for(int i=0;i<functions.length;i++){
				if(list.contains(functions[i].getKey())){
					str=str+functions[i].getValue()+",";
				}
			}
		}
		str=str.substring(0, str.length()-1);
		
		return str;
	}
	
	public static void main(String[] args) {
		String[] arr={"1","5","2"};
		String string = appendName(arr);
		System.out.println(string);
	}
	
}
