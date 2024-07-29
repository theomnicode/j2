package com.brytcode.projectsservice.jms;

import com.brytcode.projectsservice.entity.Project;
import com.brytcode.projectsservice.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmpListerner {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private JmsTemplate jmsTemplate;

    ObjectMapper objMapper = new ObjectMapper();
    @JmsListener(destination = "EMP_PROJ_QUEUE")
    public void empReqListener(String content) throws JsonProcessingException {
        //"GET:EMP:empId"
        int empId = Integer.parseInt(content.split(":")[2]);
        Project project = projectService.getProjectByEmployees(empId);
        String projectStr = objMapper.writeValueAsString(project);
        jmsTemplate.convertAndSend("PROJ_EMP_QUEUE",projectStr);
    }
}
