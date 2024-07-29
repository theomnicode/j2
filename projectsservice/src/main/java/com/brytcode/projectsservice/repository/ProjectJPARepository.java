package com.brytcode.projectsservice.repository;

import com.brytcode.projectsservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectJPARepository extends JpaRepository<Project, Integer> {
}
