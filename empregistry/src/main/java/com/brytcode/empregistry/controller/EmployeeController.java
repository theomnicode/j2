package com.brytcode.empregistry.controller;

import com.brytcode.empregistry.model.Employee;
import com.brytcode.empregistry.model.EmployeeVO;
import com.brytcode.empregistry.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees/{empno}")
    String getEmployee(@PathVariable("empno")  int empNo){
        return employeeService.getEmployee(empNo);
    }
    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        System.out.println("requested received for /employees");
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/deptno/{deptno}")
    List<Employee> getAllEmployees(@PathVariable("deptno")  int deptNo){
        return employeeService.getAllEmployees(deptNo);
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp)?"SUCCESS":"FAILED";
    }
    @PatchMapping("/employees/{empno}/salary/{salary}")
    public String updateEmployee(@PathVariable("empno") int empno, @PathVariable("salary") float salary){
        return employeeService.updateEmployee(empno, salary)?"SUCCESS":"FAILED";
    }
}
