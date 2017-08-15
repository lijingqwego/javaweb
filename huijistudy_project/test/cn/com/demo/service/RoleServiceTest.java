package cn.com.demo.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleServiceTest {

	private BeanFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/application-dao.xml","classpath:spring/application-service.xml");
	}


	@Test
	public void testFindRoleList() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelRoleById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoleById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoleListByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testRoleEnable() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetRoleId() {
		RoleService bs = factory.getBean(RoleService.class);
		
		String roleId = bs.getRoleId();
		
		System.out.println(roleId+"===========================");
	}

}
