package cn.com.demo.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.po.User;

public class UserServiceTest {
	private BeanFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/application-dao.xml","classpath:spring/application-service.xml");
	}

	@Test
	public void testFindUserList() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserId() {
		UserService service = factory.getBean(UserService.class);
		String userid = service.getUserId();
		System.out.println(userid+"=============================");
	}
	
	@Test
	public void testLoginUser() {
		UserService service = factory.getBean(UserService.class);
		User user = service.loginUser("Àî¾§", "21232f297a57a5a743894a0e4a801fc3");
		System.out.println("loginUser===>"+user);
	}
	
	@Test
	public void testFindUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		UserService service = factory.getBean(UserService.class);
		User user = new User();
		user.setLoginid("3");
		user.setUsername("lj");
		user.setPassword("123");
		service.addUser(user);
	}

	@Test
	public void testFindUserListByPage() {
		UserService service = factory.getBean(UserService.class);
		
		User u = service.findUserById("20122056");
		System.out.println(u);
		
//		PageBeanVO vo2 = new PageBeanVO();
//		PageBeanVO vo = service.findUserListByPage(2,"","");
//		System.out.println(list.size());
	}

}
