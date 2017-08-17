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
	 * 需要导入jackson包
	 * @param pn
	 * @return
	 */
	@RequestMapping("/empsToJson")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		//在查询之前需要传入页码，每页的大小
		PageHelper.startPage(pn, 5);
		//startpage后面跟一个分页查询
		List<Employee> emps=employeeService.getAll();
		//使用PageInfo包装查询结果
		//传入连续显示的页数 5页
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(emps,5);
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	/**
	 * 使用pagehelper进行分页
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
		//在查询之前需要传入页码，每页的大小
		PageHelper.startPage(pn, 5);
		//startpage后面跟一个分页查询
		List<Employee> emps=employeeService.getAll();
		//使用PageInfo包装查询结果，只需要将PageInfo交给页面
		//传入连续显示的页数 5页
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(emps,5);
		//将PageInfo传入给页面
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
