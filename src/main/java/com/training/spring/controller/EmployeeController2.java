package com.training.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.spring.domain.Employee;
import com.training.spring.service.EmployeeService;

/**
 * Handles requests for the application home page V2. The entry point to the
 * controller is /employee The methods return directly view name
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController2 {

	@Autowired
	private EmployeeService employeeService;
	/**
	 * list all employees
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/")
	public String handleRequest(Model model) throws Exception {
		List<Employee> listEmployees = employeeService.list();
		model.addAttribute("employeeList", listEmployees);
		return "employee/employeeList";
	}

	/**
	 * display new user form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/employeeForm";
	}
	/**
	 * display edit user form
	 * 
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editEmployee(@RequestParam("id") Integer employeeId, Model model) {
		Employee employee = employeeService.get(employeeId);
		model.addAttribute("employee", employee);
		return "employee/employeeForm";
	}

	/**
	 * delete user and redirect to main page
	 * 
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteEmployee(@RequestParam("id") Integer employeeId) {
		employeeService.delete(employeeId);
		return "redirect:/employee/";
	}


	/**
	 * save user (add new or save edited one)
	 * 
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "employee/employeeForm";
		}
		employeeService.saveOrUpdate(employee);
		return "redirect:/employee/";
	}
}
