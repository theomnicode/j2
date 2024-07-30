package com.brytcode.projectsservice.repository;

import com.brytcode.projectsservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {
}
