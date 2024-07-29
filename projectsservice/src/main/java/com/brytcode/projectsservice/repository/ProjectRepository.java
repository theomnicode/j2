package com.brytcode.projectsservice.repository;

import com.brytcode.projectsservice.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectRepository {
    List<Project> getProjects();
    Project getProject(int projectId);
    Project getProjectByEmployees(int empId);
}
