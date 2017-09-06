package cn.com.demo.po;

import java.util.Date;

public class Student {
	private String sno;
	private String sname;
	private int age;
	private char sex;
	private Date birth;
	
	public Student(String sno, String sname, int age, char sex, Date birth) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	
	
}
