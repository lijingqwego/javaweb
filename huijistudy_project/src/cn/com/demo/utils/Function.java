package cn.com.demo.utils;
/**
 * ����һ��ö�����ͣ����ڱ���FunctionName��Ҳ����Ȩ�޵Ĺ��ܣ�
 * ʹ��key,value����ʽ��key����functioncode,value����functionname
 * @author Administrator
 *
 */
public enum Function {
	
	ADD("1","����"),DEL("2","ɾ��"),UPD("3","�޸�"),QUERY("4","�鿴"),AUTH("5","��Ȩ");
	
	private String key;
	private String value;
	
	Function(String key,String value){
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
