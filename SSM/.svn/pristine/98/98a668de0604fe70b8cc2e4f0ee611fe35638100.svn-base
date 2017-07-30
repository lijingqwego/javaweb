package com.huiji.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huiji.po.Items;

public class ItemsServiceTest {
	
	private BeanFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-dao.xml","classpath:spring/ApplicationContext-service.xml");
	}

	@Test
	public void testFindItemsById() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		Items items = is.findItemsById(1000L);
		System.out.println(items);
	}

	@Test
	public void testFindItemsList() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		Items items = new Items();
		
		List<Items> list = is.findItemsList(items);
		for(Items i:list){
			System.out.println(i);
		}
	}
	
	@Test
	public void testFindItemsListAll() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		
		List<Items> list = is.findItemsListAll();
		for(Items i:list){
			System.out.println(i);
		}
	}
	
	@Test
	public void testUpdItemsById() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		Items items = new Items();
		items.setId(1000L);
		items.setName("ºÇºÇ");
		items.setPrice(360.0);
		items.setDetail("ºÈ¶àºÇºÇ");
		is.updItemsById(items);
		
	}
	
	@Test
	public void testAddItems() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		Items items = new Items();
		items.setName("ºÇºÇ");
		items.setPrice(360.0);
		items.setDetail("ºÈ¶àºÇºÇ");
		is.addItems(items);
	}
	
	@Test
	public void testDelItems() {
		ItemsService is=(ItemsService) factory.getBean("itemsService");
		is.delItems(1005L);
	}

}
