package com.brytcode.empregistry;

import com.brytcode.empregistry.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("projectservice")
public interface ProjectClient {
    @GetMapping("/projects/emp/{empNo}")
    Project getProject(@PathVariable("empNo") int empNo);
}
