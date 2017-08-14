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
		System.out.println("正在调用服务端方法getStudentList：");
		List<Student> studentList=new ArrayList<>();
		Student s1=new Student();
		s1.setUserid(1001);
		s1.setUsername("学生一");
		
		Student s2=new Student();
		s2.setUserid(1002);
		s2.setUsername("学生二");
		
		Student s3=new Student();
		s3.setUserid(1003);
		s3.setUsername("学生三");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		return studentList;
	}

}
