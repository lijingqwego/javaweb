package cn.com.demo.spring;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import cn.com.demo.dao.UserDAO;

public class ClassPathXmlApplicationContext implements BeanFactory {

	/**
	 * 容器加载的时候，初始化配置文件中的class 放入到beans集合中
	 */
	Map<String, Object> beans  = new HashMap<String, Object>();
	
	
	/**
	 * 从集合中来取值
	 */
	@Override
	public Object getBean(String key) {
		return beans.get(key);
	}
	
	/**
	 * 做初始化动作  操作xml文件  需要借助工具类 
	 * jdom.jar   /    dom4j.jar
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public ClassPathXmlApplicationContext() throws Exception{
		//操作xml文件的工具类
		SAXBuilder sx = new SAXBuilder();
		//加载beans.xml配置文件
		Document document = sx.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		//获取根几点
		Element element =  document.getRootElement() ;
		//获取根节点下面所有的bean标签
		List<Element> list = element.getChildren("bean") ;
		//循环便利list
		for(Element el : list){
			String id =  el.getAttributeValue("id") ;
			String clazz = el.getAttributeValue("class") ;
			//需要将clazz 进行实例化 
			Object obj =  Class.forName(clazz).newInstance()  ;
			
			//将对应放入到map集合中  beans 
			beans.put(id, obj);
			
			//------------------------\
			List<Element> li =  el.getChildren("property");
			for(Element ent : li){
				String name  = ent.getAttributeValue("name") ;  //userDAO
				String ref =ent.getAttributeValue("ref"); //userDAO
				Object beanObject = beans.get(ref);  //UserInfoDAOImpl  implements UserDAO;
				//调用set方法，将这个对象注入进去
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				//获取这个方法  有那么一丢丢的反射的内容
				//  setUserDAO(UserDAO userDAO)
				Method  m =  obj.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0] );
				//调用方法
				m.invoke(obj, beanObject);
				
			}
		}		
		
	}
	
}
