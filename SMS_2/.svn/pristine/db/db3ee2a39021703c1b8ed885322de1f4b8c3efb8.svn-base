package com.huiji.service;

import java.util.List;

import com.huiji.daoimpl.StudentDaoImpl;
import com.huiji.po.Student;

public class StudentService {
	
	private StudentDaoImpl dao;

	public StudentService(){
		dao = new StudentDaoImpl();
	}
	
	public int addStudent(Student stu){
		int row=-1;
		try {
			row=dao.addStudent(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int delStudent(int id){
		int row=-1;
		try {
			row=dao.delStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int updStudent(Student stu){
		int row=-1;
		try {
			row=dao.updStudent(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public List<Student> queryStudent(int id){
		try {
			return dao.queryStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
