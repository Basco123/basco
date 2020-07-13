package com.basco.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basco.crud.bean.Department;
import com.basco.crud.bean.Employee;
import com.basco.crud.bean.Msg;
import com.basco.crud.service.DepartmentService;
import com.basco.crud.service.EmployeeService;

/*
 * 处理和部门有关的请求
 */

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	

	/*
	 * 返回所有的信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts() {
		//查出所有的部门
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts",list);
	}
	
}
