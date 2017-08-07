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
	 * �������ص�ʱ�򣬳�ʼ�������ļ��е�class ���뵽beans������
	 */
	Map<String, Object> beans  = new HashMap<String, Object>();
	
	
	/**
	 * �Ӽ�������ȡֵ
	 */
	@Override
	public Object getBean(String key) {
		return beans.get(key);
	}
	
	/**
	 * ����ʼ������  ����xml�ļ�  ��Ҫ���������� 
	 * jdom.jar   /    dom4j.jar
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public ClassPathXmlApplicationContext() throws Exception{
		//����xml�ļ��Ĺ�����
		SAXBuilder sx = new SAXBuilder();
		//����beans.xml�����ļ�
		Document document = sx.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		//��ȡ������
		Element element =  document.getRootElement() ;
		//��ȡ���ڵ��������е�bean��ǩ
		List<Element> list = element.getChildren("bean") ;
		//ѭ������list
		for(Element el : list){
			String id =  el.getAttributeValue("id") ;
			String clazz = el.getAttributeValue("class") ;
			//��Ҫ��clazz ����ʵ���� 
			Object obj =  Class.forName(clazz).newInstance()  ;
			
			//����Ӧ���뵽map������  beans 
			beans.put(id, obj);
			
			//------------------------\
			List<Element> li =  el.getChildren("property");
			for(Element ent : li){
				String name  = ent.getAttributeValue("name") ;  //userDAO
				String ref =ent.getAttributeValue("ref"); //userDAO
				Object beanObject = beans.get(ref);  //UserInfoDAOImpl  implements UserDAO;
				//����set���������������ע���ȥ
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				//��ȡ�������  ����ôһ�����ķ��������
				//  setUserDAO(UserDAO userDAO)
				Method  m =  obj.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0] );
				//���÷���
				m.invoke(obj, beanObject);
				
			}
		}		
		
	}
	
}
