package com.huiji.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huiji.po.PageBean;
import com.huiji.po.User;
import com.huiji.po.UserinfoPage;

public class UserServiceTest {
	private BeanFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-dao.xml","classpath:spring/ApplicationContext-service.xml");
	}

	@Test
	public void testFindUserListByPage() {
		UserService us=factory.getBean(UserService.class);
		UserinfoPage up=new UserinfoPage();
		up.setStart(1);
		up.setEnd(3);
		List<User> list = us.findUserListByPage(up);
		for(User u:list){
			System.out.println(u);
		}
		
	}
	
	@Test
	public void testFindUserList() {
		UserService us=factory.getBean(UserService.class);
		PageBean page=new PageBean();
		page.setCurrPage(1);
		page.setPageSize(3);
		List<User> list = us.findUserList(page);
		for(User u:list){
			System.out.println(u);
		}
		
	}
	
	@Test
	public void testGetUserCount() {
		UserService us=factory.getBean(UserService.class);
		int userCount = us.getUserCount();
		System.out.println(userCount);
	}
	
	@Test
	public void testLogin() {
		UserService us=factory.getBean(UserService.class);
		User user = new User();
		user.setUsername("����");
		user.setPassword("admin");
		User login = us.login(user);
		System.out.println(login);
	}

}
