package cn.com.demo.utils;

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
		if(strArr!=null){
			for(String s:strArr){
				if(s.equals("1")){
					str=str+"增加"+",";
				}
				if(s.equals("2")){
					str=str+"删除"+",";
				}
				if(s.equals("3")){
					str=str+"修改"+",";
				}
				if(s.equals("4")){
					str=str+"查看"+",";
				}
				if(s.equals("5")){
					str=str+"授权"+",";
				}
			}
			str=str.substring(0, str.length()-1);
		}
		return str;
	}
	
}
