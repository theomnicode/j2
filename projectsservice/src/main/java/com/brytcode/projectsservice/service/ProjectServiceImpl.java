package com.brytcode.projectsservice.service;

import com.brytcode.projectsservice.entity.Employee;
import com.brytcode.projectsservice.entity.Project;
import com.brytcode.projectsservice.repository.EmployeeJPARepository;
import com.brytcode.projectsservice.repository.ProjectJPARepository;
import com.brytcode.projectsservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectJPARepository projectRepository;
    @Autowired
    private EmployeeJPARepository employeeJPARepository;
    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(int projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public Project getProjectByEmployees(int empId) {
        return null;//projectRepository.getProjectByEmployees(empId);
    }

    @Override
    public Employee getEmployee(int empNo) {
        return employeeJPARepository.findById(empNo).orElse(null);
    }
}
