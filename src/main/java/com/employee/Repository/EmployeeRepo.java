package com.employee.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.employee.Entity.EmployeeInformation;
//import com.first.Entity.Student;

import jakarta.transaction.Transactional;


public interface EmployeeRepo extends CrudRepository<EmployeeInformation, Integer>{
	
	@Query("Select e from EmployeeInformation e")
	public List<EmployeeInformation> getAllEmployees();
	
	@Query("SELECT e FROM EmployeeInformation e WHERE e.id = :id")
    EmployeeInformation getEmployeeById(@Param("id") Integer id);
	
	
	 @Modifying
	    @Transactional
	    @Query("UPDATE EmployeeInformation e SET e.fullName = :fullName, e.departmentName = :departmentName, " +
	           "e.employeeType = :employeeType, e.emailId = :emailId, e.phoneNo = :phoneNo, e.country = :country " +
	           "WHERE e.id = :id")
	    int updateEmployeeInformation(@Param("id") Integer id,
	                                  @Param("fullName") String fullName,
	                                  @Param("departmentName") String departmentName,
	                                  @Param("employeeType") String employeeType,
	                                  @Param("emailId") String emailId,
	                                  @Param("phoneNo") String phoneNo,
	                                  @Param("country") String country);
	}

