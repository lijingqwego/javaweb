package cn.com.demo.utils;

public class StringBufferUtils {
	/**
	 * Æ´½Ó×Ö·û´®
	 * @param suffixOverrides ÖÐ¼ä·Ö¸ô·û
	 * @param suffix Ä©Î²·Ö¸ô·û
	 * @param res Æ´½ÓµÄ×Ö·û´®
	 * @return
	 */
	public static String appendToChars(String suffixOverrides,String suffix,String...res){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < res.length; i++) {
			if(i==res.length-1){
				sb.append(res[i]+suffix);
			}else{
				sb.append(res[i]+suffixOverrides);
			}
		}
		return sb.toString();
	}
}
