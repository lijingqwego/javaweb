package com.huiji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiji.po.Department;
import com.huiji.po.Employee;
import com.huiji.po.Msg;
import com.huiji.service.DepartmentService;
import com.huiji.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * ��Ҫ����jackson��
	 * @param pn
	 * @return
	 */
	@RequestMapping("/empsToJson")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		//�ڲ�ѯ֮ǰ��Ҫ����ҳ�룬ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		//startpage�����һ����ҳ��ѯ
		List<Employee> emps=employeeService.getAll();
		//ʹ��PageInfo��װ��ѯ���
		//����������ʾ��ҳ�� 5ҳ
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(emps,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * ʹ��pagehelper���з�ҳ
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//�ڲ�ѯ֮ǰ��Ҫ����ҳ�룬ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		//startpage�����һ����ҳ��ѯ
		List<Employee> emps=employeeService.getAll();
		//ʹ��PageInfo��װ��ѯ�����ֻ��Ҫ��PageInfo����ҳ��
		//����������ʾ��ҳ�� 5ҳ
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(emps,5);
		//��PageInfo�����ҳ��
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}
	
	
	@RequestMapping("/add")
	public String addEmp(Model model){
		List<Department> depts = departmentService.getDept();
		model.addAttribute("depts", depts);
		return "add";
	}
	
	@RequestMapping("/comAdd")
	public String comAddEmp(Employee emp){
		employeeService.addEmp(emp);
		return "redirect:/emps";
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public Msg delEmp(@RequestParam(value="empId")Long empId){
		employeeService.delEmp(empId);
		return Msg.success();
	}
}
