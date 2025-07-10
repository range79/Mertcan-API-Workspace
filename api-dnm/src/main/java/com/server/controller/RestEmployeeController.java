package com.server.controller;

import com.server.dto.EmployeeDto;
import com.server.model.Employee;
import com.server.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/employee")
public class RestEmployeeController {


    private final EmployeeService employeeService;
    public RestEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-param")
    public List<Employee> getEmployeeWithParams(@RequestBody(required = false) EmployeeDto e){
        return employeeService.getEmployeeWithParams(e);
    }

    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") String id,@RequestBody EmployeeDto request){
        return employeeService.updateEmployee(id,request);
    }
}
