package com.huiji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huiji.dao.EmployeeMapper;
import com.huiji.po.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 获取所用员工
	 * @param pn
	 * @return
	 */
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}

	public void addEmp(Employee emp) {
		Long empId = employeeMapper.selectEmpId();
		emp.setEmpId(empId);
		employeeMapper.insertSelective(emp);
	}

	public void delEmp(Long empId) {
		employeeMapper.deleteByPrimaryKey(empId);
	}
}
