package com.brytcode.empregistry.service;

import com.brytcode.empregistry.ProjectClient;
import com.brytcode.empregistry.model.Employee;
import com.brytcode.empregistry.model.EmployeeVO;
import com.brytcode.empregistry.model.Project;
import com.brytcode.empregistry.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private ProjectClient projectClient;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Override
    public String getEmployee(int empNo) {
        Employee emp = empRepo.getEmployee(empNo);
        int projectId = emp.getProjectId();
    /*    RestTemplate restClient = new RestTemplate();
        ResponseEntity<Project> project = restClient.exchange("http://172.24.144.1:9090/projectservice/projects/"+emp.getProjectId(), HttpMethod.GET, null, Project.class );
        Project proj = project.getBody();*/
        jmsTemplate.convertAndSend("EMP_PROJ_QUEUE","GET:EMP:"+empNo);
        /*Project proj = projectClient.getProject(emp.getProjectId());
        EmployeeVO empVo = new EmployeeVO();
        BeanUtils.copyProperties(emp,empVo);
        empVo.setProject(proj);*/
        return "Your request is queued, you will be notified once the data is ready";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepo.getAllEmployees();
    }

    @Override
    public List<Employee> getAllEmployees(int deptNo) {
        return empRepo.getAllEmployees(deptNo);
    }

    @Override
    public boolean createEmployee(Employee emp) {
        return empRepo.createEmployee(emp);
    }

    @Override
    public boolean updateEmployee(int empNo, float salary) {
        return empRepo.updateSalary(empNo, salary);
    }
}
