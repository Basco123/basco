	package com.basco.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basco.crud.bean.Employee;
import com.basco.crud.bean.EmployeeExample;
import com.basco.crud.bean.EmployeeExample.Criteria;
import com.basco.crud.dao.EmployeeMapper;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> getAll() {
		/*
		 * 
		 * ��ѯ����Ա��
		 */
		
		return employeeMapper.selectByExampleWithDept(null);
	}
	
	/*
	 * 员工保存
	 */
	
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
		
	}
	/*
	 * 检验用户名是否可用
	 */
	public boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/*
	 * 按照员工id查询员工
	 */
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
	
	/*
	 * 员工更新
	 */		
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);	
	}

	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		// TODO 自动生成的方法存根
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}

}
