package com.brytcode.projectsservice.repository;

import com.brytcode.projectsservice.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
    @Autowired
    private NamedParameterJdbcOperations operations;

    @Override
    public List<Project> getProjects() {
        List<Project> project = operations.query("SELECT * FROM PROJECT", new BeanPropertyRowMapper<>(Project.class));
        return project;
    }

    @Override
    public Project getProject(int projectId) {
        SqlParameterSource params =new MapSqlParameterSource().addValue("projectId",projectId);
        Project project = operations.queryForObject("SELECT * FROM PROJECT WHERE PROJECT_ID=:projectId", params, new BeanPropertyRowMapper<>(Project.class));
        return project;
    }

    @Override
    public Project getProjectByEmployees(int empNo) {
        SqlParameterSource params =new MapSqlParameterSource().addValue("empNo",empNo);
        Project project = operations.queryForObject("SELECT * FROM PROJECT WHERE PROJECT_ID = (SELECT PROJECT_ID FROM EMPLOYEE WHERE EMPNO=:empNo)", params, new BeanPropertyRowMapper<>(Project.class));
        return project;
    }

}
