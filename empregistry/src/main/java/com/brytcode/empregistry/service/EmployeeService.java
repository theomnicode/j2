package com.brytcode.empregistry.service;

import com.brytcode.empregistry.model.Employee;
import com.brytcode.empregistry.model.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    String getEmployee(int empNo);
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployees(int deptNo);
    boolean createEmployee(Employee emp);
    boolean updateEmployee(int empNo, float salary);
}
