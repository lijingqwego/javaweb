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
 * 使用spring测试模块的测试请求的功能
 * @author Administrator
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:ApplicationContext.xml","classpath:springmvc.xml"})
public class MvcTest {
	//传入springmvc的ioc
	@Autowired
	WebApplicationContext context;
	//虚拟MVC请求，获取到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		//模拟请求，拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		//获取请求
		MockHttpServletRequest request = result.getRequest();
		
		@SuppressWarnings("unchecked")
		PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("pageInfo");
		
		int pageNum = pageInfo.getPageNum();
		int pages = pageInfo.getPages();
		long total = pageInfo.getTotal();
		int[] nums = pageInfo.getNavigatepageNums();
		System.out.println("当前页："+pageNum);
		System.out.println("总页数："+pages);
		System.out.println("总记录数："+total);
		System.out.println("在页面上连续显示的页码：");
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
		//模拟请求，拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/add")).andReturn();
		//获取请求
		MockHttpServletRequest request = result.getRequest();
		
		@SuppressWarnings("unchecked")
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		
		System.out.println(depts.get(0).getDeptName()+"==========>"+depts.get(0).getDeptId());
	}
}
