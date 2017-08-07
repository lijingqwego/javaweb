package cn.com.demo.spring;

/**
 * Bean 工厂 专门负责产生对象
 * @author Administrator
 *
 */
public interface BeanFactory {
	//根据key来取对应的对象
	public Object getBean(String key) ;
}
