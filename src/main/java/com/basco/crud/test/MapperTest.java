package com.basco.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.basco.crud.bean.Department;
import com.basco.crud.bean.Employee;
import com.basco.crud.dao.DepartmentMapper;
import com.basco.crud.dao.EmployeeMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlsession;
	@Test
	public void testCRUD() {
		System.out.println(departmentMapper);
		System.out.println(employeeMapper);
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null, "�_�l��"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
//		employeeMapper.insertSelective(new Employee(null, "basco", "m", "623826716@qq.com", 1));
		
		EmployeeMapper mapper = sqlsession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 1));
		}
		System.out.println("�������");
	}

}
