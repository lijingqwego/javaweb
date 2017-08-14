package ws.cxf.hj.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ws.cxf.hj.po.Student;
import ws.cxf.hj.service.StudentService;

public class StudentServiceTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:client-beans.xml");
		StudentService service = (StudentService) context.getBean("studentService");
		List<Student> studentlist=service.getStudentList();
	    System.out.println("¿Í»§¶ËÊä³östudentlist:"+studentlist);
	}
}
