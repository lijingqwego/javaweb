package com.huiji.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huiji.dao.DepartmentMapper;
import com.huiji.dao.EmployeeMapper;
import com.huiji.po.Employee;

/**
 * ����dao��
 * @author Administrator
 * ����ʹ��spring�ĵ�Ԫ���� spring Test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:ApplicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Test
	public void testCRUD(){
		//1.����spring IOC����
		//ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//2.�������л�ȡmapper
		//DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		//Department department = new Department(2L,"dd");
		//bean.insertSelective(department);
		//ioc.close();
		//System.out.println(bean);
		
		//System.out.println(departmentMapper);
		
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		
		for(long i=1;i<=30;i++){
			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insert(new Employee(i, uid, "��", uid+"@163.com",1L));
		}
		
		System.out.println("���������ɣ�");
	}

}
