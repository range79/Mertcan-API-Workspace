package com.server.controller;

import java.util.List;
import com.server.model.Employee;
import com.server.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id" , required = true) String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-param")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstname",required = false) String firstname,
                                                @RequestParam(name = "lastname",required = false) String lastname){
        return employeeService.getEmployeeWithParams(firstname,lastname);
    }

    @PostMapping(path = "/post")
    public void postEmployee(@RequestParam(name = "firstname") String firstname,
                             @RequestParam(name = "lastname") String lastname){
        employeeService.postEmployee(firstname, lastname);
    }
}
