package com.training.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.spring.dao.EmployeeDAO;
import com.training.spring.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	@Override
	public List<Employee> list() {
		return employeeDAO.list();
	}
	@Override 
	public Employee get(int id) {
		return employeeDAO.get(id);
	}
	@Override
	public void saveOrUpdate(Employee employee) {
		employeeDAO.saveOrUpdate(employee);

	}
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);

	}
}
