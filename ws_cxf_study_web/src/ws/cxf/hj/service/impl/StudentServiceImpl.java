package ws.cxf.hj.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ws.cxf.hj.po.Student;
import ws.cxf.hj.service.StudentService;
//(endpointInterface="ws.cxf.hj.service.StudentService")
@WebService
public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> getStudentList() {
		System.out.println("���ڵ��÷���˷���getStudentList��");
		List<Student> studentList=new ArrayList<>();
		Student s1=new Student();
		s1.setUserid(1001);
		s1.setUsername("ѧ��һ");
		
		Student s2=new Student();
		s2.setUserid(1002);
		s2.setUsername("ѧ����");
		
		Student s3=new Student();
		s3.setUserid(1003);
		s3.setUsername("ѧ����");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		return studentList;
	}

}
