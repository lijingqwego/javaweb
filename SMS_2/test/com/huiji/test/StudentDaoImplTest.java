package com.huiji.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.huiji.dao.StudentDao;
import com.huiji.daoimpl.StudentDaoImpl;
import com.huiji.po.Student;

public class StudentDaoImplTest {

	private StudentDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new StudentDaoImpl();
	}

	@Test
	public void testAddStudent() {
		Student stu = new Student(1035,"sunbin",23,"2016-08-12","jiangsu","13275239515","qert");
		try {
			int row = dao.addStudent(stu);
			System.out.println(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelStudent() {
		try {
			int row=dao.delStudent(1033);
			System.out.println(row);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdStudent() {
		Student stu = new Student(1033,"liyanhong",50,"2017-07-11","shenzheng","13077916560","tenxun");
		try {
			int row=dao.updStudent(stu);
			System.out.println(row);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryStudent() {
		try {
			List<Student> list = dao.queryStudent(-1);
			System.out.println(list.get(0).getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
