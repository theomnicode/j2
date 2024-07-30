package com.brytcode.projectsservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Employee {
    @Id
    @Column(name="EMPNO")
    private Integer empNo;
    @Column(name="ENAME")
    private String empName;
    private BigDecimal salary;
    @Column(name="DEPTNO")
    private Integer deptNo;
    @ManyToOne
    @JoinColumn(name="projectId")
    @JsonBackReference
    private Project project;

    public Employee() {
    }

    public Employee(int empNo, String empName, BigDecimal salary, int deptNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.salary = salary;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", deptNo=" + deptNo +
                ", project=" + project +
                '}';
    }
}
