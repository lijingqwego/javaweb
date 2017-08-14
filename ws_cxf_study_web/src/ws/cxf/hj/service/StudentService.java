package ws.cxf.hj.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import ws.cxf.hj.po.Student;

@WebService
public interface StudentService {
	@WebMethod
	@WebResult List<Student> getStudentList();
}
