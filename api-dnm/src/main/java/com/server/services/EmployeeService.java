package com.server.services;

import com.server.dto.EmployeeDto;
import com.server.model.Employee;
import com.server.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(EmployeeDto employeeDto){
        return employeeRepository.getEmployeeWithParams(employeeDto.getFirstname(),employeeDto.getLastname());
    }

    public Employee saveEmployee(Employee newEmployee){

        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployee(String id){

        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, EmployeeDto request){
        return employeeRepository.updateEmployee(id,request);
    }
}
