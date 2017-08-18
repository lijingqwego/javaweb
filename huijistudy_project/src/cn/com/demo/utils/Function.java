package cn.com.demo.utils;
/**
 * 定义一个枚举类型，用于保存FunctionName，也就是权限的功能，
 * 使用key,value的形式，key代表functioncode,value代表functionname
 * @author Administrator
 *
 */
public enum Function {
	
	ADD("1","增加"),DEL("2","删除"),UPD("3","修改"),QUERY("4","查看"),AUTH("5","授权");
	
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
