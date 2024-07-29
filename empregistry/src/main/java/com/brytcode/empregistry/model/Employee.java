package com.brytcode.empregistry.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private int empNo;
    private String ename;
    private BigDecimal salary;
    private String deptno;
    private int projectId;

    public Employee() {
    }

    public Employee(int empNo, String ename, BigDecimal salary, String deptno, int projectId) {
        this.empNo = empNo;
        this.ename = ename;
        this.salary = salary;
        this.deptno = deptno;
        this.projectId = projectId;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empNo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", deptno='" + deptno + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
