package com.training.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.domain.Employee;

@Repository
@Transactional(value = "transactionManager")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
 
    public EmployeeDAOImpl() {
         
    }
 
    @Override
    public List<Employee> list() {
        @SuppressWarnings("unchecked")       
        List<Employee> listUser = (List<Employee>) this.entityManager.createQuery("SELECT user FROM Employee user").getResultList();
 
        return listUser;
    }
    @Override
    public void saveOrUpdate(Employee employee) {
    	employee = this.entityManager.merge(employee);
    }
 
    @Override
    public void delete(int id) {    	
       	Employee employee = this.entityManager.getReference(Employee.class, new Integer(id));
    	this.entityManager.remove(employee);
    }
 
    @Override
    public Employee get(int id) {
    	Employee employee = this.entityManager.find(Employee.class, new Integer(id));
    	
    	return employee;
    	
    }
}
