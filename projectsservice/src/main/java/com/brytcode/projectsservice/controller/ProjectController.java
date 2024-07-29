package com.brytcode.projectsservice.controller;

import com.brytcode.projectsservice.entity.Project;
import com.brytcode.projectsservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @GetMapping("/projects/{projectId}")
    public Project getProject(@PathVariable("projectId") int projectId){
        return projectService.getProject(projectId);
    }

    @GetMapping("/projects/emp/{empNo}")
    public Project getProjectByEmp(@PathVariable("empNo") int empNo){
        return projectService.getProjectByEmployees(empNo);
    }

}
