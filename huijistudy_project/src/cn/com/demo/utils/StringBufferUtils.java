package cn.com.demo.utils;

public class StringBufferUtils {
	/**
	 * ƴ���ַ���
	 * @param suffixOverrides �м�ָ���
	 * @param suffix ĩβ�ָ���
	 * @param res ƴ�ӵ��ַ���
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
