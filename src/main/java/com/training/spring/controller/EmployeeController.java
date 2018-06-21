package com.training.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.spring.domain.Employee;
import com.training.spring.service.EmployeeService;

/**
 * Handles requests for the application home page.
 * The methods return ModelAndView object
 */
@Controller
public class EmployeeController {

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
	public ModelAndView handleRequest() throws Exception {
		List<Employee> listEmployees = employeeService.list();
		ModelAndView model = new ModelAndView("employeeList");
		model.addObject("employeeList", listEmployees);
		return model;
	}
/**
	 * Load add new employee form
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView createEmployee() {
		ModelAndView model = new ModelAndView("employeeForm");
		model.addObject("employee", new Employee());
		return model;
	}
	/**
	 * display edit user form
	 * 
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id") Integer employeeId) {
		Employee employee = employeeService.get(employeeId);
		ModelAndView model = new ModelAndView("employeeForm");
		model.addObject("employee", employee);
		return model;
	}

/**
	 * delete user and redirect to main page
	 * 
	 * @param employeeId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteEmployee(@RequestParam("id") Integer employeeId) {
		employeeService.delete(employeeId);
		return new ModelAndView("redirect:/");
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
	public ModelAndView saveEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("employeeForm");
			return model;
		}
		employeeService.saveOrUpdate(employee);
		return new ModelAndView("redirect:/");
	}
}
