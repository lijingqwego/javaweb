package cn.com.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PUmUserRoleServiceTest {
	private BeanFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/application-dao.xml","classpath:spring/application-service.xml");
	}

	@Test
	public void testFindUserOfRoleListByUserId() {
		UserRoleService service = factory.getBean(UserRoleService.class);
		service.findUserOfRoleListByUserId("1");
		
	}

}
