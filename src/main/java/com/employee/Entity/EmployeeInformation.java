package com.employee.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  // Auto-generated ID

    private String fullName;
    private String departmentName;
    private String employeeType;
    private String emailId;
    private String phoneNo;
    private String country;

    // Default constructor
    public EmployeeInformation() {}

    // Constructor with all fields (except ID)
    public EmployeeInformation(String fullName, String departmentName, String employeeType,
                               String emailId, String phoneNo, String country) {
        this.fullName = fullName;
        this.departmentName = departmentName;
        this.employeeType = employeeType;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "EmployeeInformation{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

