package com.brytcode.projectsservice.service;

import com.brytcode.projectsservice.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProjects();
    Project getProject(int projectId);
    Project getProjectByEmployees(int empId);
}
