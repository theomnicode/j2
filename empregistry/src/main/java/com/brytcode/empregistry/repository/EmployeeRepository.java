package com.brytcode.empregistry.repository;

import com.brytcode.empregistry.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository {
    Employee getEmployee(int empNo);
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployees(int deptNo);
    boolean createEmployee(Employee emp);
    boolean updateSalary(int empNo, float salary);
}
