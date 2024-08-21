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
	
	
	// api for posting the data to database
//	@PostMapping("/saved")
//	public String postData(@RequestParam String fullName,@RequestParam String departmentName,@RequestParam
//			String employeeType,@RequestParam String emailId,@RequestParam String phoneNo,@RequestParam String countryName) {
//		EmployeeInformation e = new EmployeeInformation();
//		e.setFullName(fullName);
//		e.setDepartmentName(departmentName);
//		e.setEmployeeType(employeeType);
//		e.setEmailId(emailId);
//		e.setPhoneNo(phoneNo);
//		e.setCountry(countryName);
//		
//		employeeRepo.save(e);
//		
//		return "Success!";
//	}
	// api for posting the data to database
	@PostMapping("/saved")
	public String postData(@RequestBody EmployeeInformation employee) {
	    employeeRepo.save(employee);
	    return "Success!";
	}
	// api for getting all details of all employees
	@GetMapping("/employees")
	public List<EmployeeInformation> getAllEmp(){
		List<EmployeeInformation> employeeDetails = employeeRepo.getAllEmployees();
		return employeeDetails;
		}
	//api for getting employee information from employee id 
	 @GetMapping("/employees/{id}")
	    public EmployeeInformation getEmployeeById(@PathVariable("id") Integer id) {
	        return employeeRepo.getEmployeeById(id);
	    }
	//api for deleting employee by employee id
//	 @DeleteMapping("/deleteEmployeeById")
//	 public String deleteEmployeeById(@RequestParam Integer id) {
//		 employeeRepo.deleteById(id);
//		 return "Successfully deleted employee!!";
//	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String deleteEmployee(@PathVariable("id") Integer id) {
	     employeeRepo.deleteById(id);
	     return "Employee deleted successfully";
	 }
	 // api for update the employee data
	 @PutMapping("/updateEmployee")
	    public String updateEmployee(@RequestParam Integer id,
	                                 @RequestParam String fullName,
	                                 @RequestParam String departmentName,
	                                 @RequestParam String employeeType,
	                                 @RequestParam String emailId,
	                                 @RequestParam String phoneNo,
	                                 @RequestParam String country) {

	        int updatedRows = employeeRepo.updateEmployeeInformation(id, fullName, departmentName, employeeType, emailId, phoneNo, country);

	        if (updatedRows > 0) {
	            return "Employee updated successfully!";
	        } else {
	            return "Employee not found!";
	        }
	    }
	
	

}
