package com.huiji.po;

import java.io.Serializable;

public class Student implements Comparable<Student>,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	private String address;
	private String tel;
	private String des;
	private String birthday;
	
	public Student(){
		
	}
	
	public Student(int id, String name, int age,String birthday, String address, String tel, String des) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday=birthday;
		this.address = address;
		this.tel = tel;
		this.des = des;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public int compareTo(Student student) {
		
		return this.id-student.id;
	}
}
