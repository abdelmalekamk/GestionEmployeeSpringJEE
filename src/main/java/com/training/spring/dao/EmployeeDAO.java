package com.training.spring.dao;

import java.util.List;

import com.training.spring.domain.Employee;

public interface EmployeeDAO {
    public List<Employee> list();
     
    public Employee get(int id);
     
    public void saveOrUpdate(Employee employee);
     
    public void delete(int id);
}
