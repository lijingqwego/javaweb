package com.huiji.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.huiji.po.Department;
import com.huiji.po.Employee;

/**
 * ʹ��spring����ģ��Ĳ�������Ĺ���
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:ApplicationContext.xml","classpath:springmvc.xml"})
public class MvcTest {
	//����springmvc��ioc
	@Autowired
	WebApplicationContext context;
	//����MVC���󣬻�ȡ��������
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		//��ȡ����
		MockHttpServletRequest request = result.getRequest();
		
		@SuppressWarnings("unchecked")
		PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("pageInfo");
		
		int pageNum = pageInfo.getPageNum();
		int pages = pageInfo.getPages();
		long total = pageInfo.getTotal();
		int[] nums = pageInfo.getNavigatepageNums();
		System.out.println("��ǰҳ��"+pageNum);
		System.out.println("��ҳ����"+pages);
		System.out.println("�ܼ�¼����"+total);
		System.out.println("��ҳ����������ʾ��ҳ�룺");
		for(int n:nums){
			System.out.print(n+" ");
		}
		System.out.println();
		
		List<Employee> list = pageInfo.getList();
		for(Employee emp:list){
			System.out.println(emp.getEmpId()+"========>"+emp.getEmpName());
		}
	}
	
	@Test
	public void testAdd() throws Exception{
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/add")).andReturn();
		//��ȡ����
		MockHttpServletRequest request = result.getRequest();
		
		@SuppressWarnings("unchecked")
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		
		System.out.println(depts.get(0).getDeptName()+"==========>"+depts.get(0).getDeptId());
	}
}
