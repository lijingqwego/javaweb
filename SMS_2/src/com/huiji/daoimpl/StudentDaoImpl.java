package com.huiji.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.huiji.dao.StudentDao;
import com.huiji.db.DBHelper;
import com.huiji.po.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public int addStudent(Student stu)throws Exception {
		
		String sql="insert into student(id,name,age,birth,address,tel,des) values(?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		
		return DBHelper.update(sql, stu.getId(),stu.getName(),stu.getAge(),stu.getBirthday(),stu.getAddress(),stu.getTel(),stu.getDes());
	}

	@Override
	public int delStudent(int id)throws Exception {
		String sql="delete from student where id=?";
		return DBHelper.update(sql, id);
	}

	@Override
	public int updStudent(Student stu)throws Exception {
		String sql="update student set name=?,age=?,birth=to_date(?,'yyyy-mm-dd'),address=?,tel=?,des=? where id=?";
		return DBHelper.update(sql, stu.getName(),stu.getAge(),stu.getBirthday(),stu.getAddress(),stu.getTel(),stu.getDes(),stu.getId());
	}

	@Override
	public List<Student> queryStudent(int id)throws Exception {
		String sql="select * from student ";
		ResultSet rs=null;
		List<Student> list=new ArrayList<Student>();
		if(id>0){
			sql+="where id=?";
			rs=DBHelper.query(sql, id);
		}else{
			rs=DBHelper.query(sql);
		}
		while(rs.next()){
			int sid=rs.getInt("id");
			String name = rs.getString("name");		
			int age = rs.getInt("age");
			String birthday = rs.getString("birth");
			String birth=birthday.substring(0, 10);
			String address = rs.getString("address");
			String tel = rs.getString("tel");
			String des = rs.getString("des");
			Student stu = new Student(sid,name,age,birth,address,tel,des);
			list.add(stu);
		}
		return list;
	}

}
