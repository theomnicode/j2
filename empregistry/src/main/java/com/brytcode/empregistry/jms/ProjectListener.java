package com.brytcode.empregistry.jms;

import com.brytcode.empregistry.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectListener {
    @JmsListener(destination = "PROJ_EMP_QUEUE")
    public void empReqListener(String content){
        //"GET:EMP:empId"
        System.out.println(content + "Printed in EmpService");
    }
}
