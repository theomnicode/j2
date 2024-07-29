package com.brytcode.empregistry.repository;

import com.brytcode.empregistry.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Autowired
    private NamedParameterJdbcOperations operations;
    @Override
    public Employee getEmployee(int empNo) {
        SqlParameterSource params =new MapSqlParameterSource().addValue("empNo",empNo);
        Employee emp = operations.queryForObject("SELECT * FROM EMPLOYEE WHERE EMPNO=:empNo", params, new BeanPropertyRowMapper<>(Employee.class));
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emp = operations.query("SELECT * FROM EMPLOYEE", new BeanPropertyRowMapper<>(Employee.class));
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees(int deptNo) {
        SqlParameterSource params =new MapSqlParameterSource().addValue("deptNo", deptNo);
        List<Employee> emps = operations.query("SELECT * FROM EMPLOYEE WHERE DEPTNO=:deptNo", params, new BeanPropertyRowMapper<>(Employee.class));
        return emps;
    }

    @Override
    public boolean createEmployee(Employee emp) {

        SqlParameterSource params =new MapSqlParameterSource()
                .addValue("empno", emp.getEmpNo())
                .addValue("ename", emp.getEname())
                .addValue("salary", emp.getSalary())
                .addValue("deptno", emp.getDeptno());

        return operations.update("INSERT INTO EMPLOYEE VALUES(:empno, :ename, :salary, :deptno)", params)>0?true:false;
    }

    @Override
    public boolean updateSalary(int empNo, float salary) {
        SqlParameterSource params =new MapSqlParameterSource()
                .addValue("empno", empNo)
                .addValue("salary", salary);

        return operations.update("UPDATE EMPLOYEE SET SALARY = :salary WHERE EMPNO=:empno", params)>0?true:false;
    }
}
