package com.huiji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiji.dao.DepartmentMapper;
import com.huiji.po.Department;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	public List<Department> getDept(){
		return departmentMapper.selectByExample(null);
	}

}
