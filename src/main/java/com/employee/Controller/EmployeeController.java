package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.EmployeeInformation;
import com.employee.Repository.EmployeeRepo;
@CrossOrigin(origins = "http://localhost:5173") 
@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//api for getting all employees information
	@GetMapping("/employees")
	public List<EmployeeInformation> getAllEmp() {
    	return employeeRepo.findAll();
	}
	
	//api for getting employee information from employee id 
	@GetMapping("/employees/{id}")
	public EmployeeInformation getEmployeeById(@PathVariable("id") Integer id) {
    	return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found!"));
	}

	
	// api for posting the employee information to database
	@PostMapping("/saved")
	public String postData(@RequestBody EmployeeInformation employee) {
	employeeRepo.save(employee);
	return "Success!";
	}

	// api for delete the employee data
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
    	if (employeeRepo.existsById(id)) {
        employeeRepo.deleteById(id);
        return "Employee deleted successfully";
    	} else {
        return "Employee not found!";
    	}
	}

	
	// api for update the employee data
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody EmployeeInformation employee) {
    	
    	employeeRepo.save(employee);
    	return "Employee updated successfully!";
	}
}
