package cn.com.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthorityServiceTest {

	private BeanFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/application-dao.xml","classpath:spring/application-service.xml");
	}

	@Test
	public void test() {
		factory.getBean(PaperService.class).addExamInfoNo("20170904000001", 5);
	}

}
