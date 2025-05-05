package com.server.services;

import com.server.model.Employee;
import com.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstname, String lastname){
        return employeeRepository.getEmployeeWithParams(firstname,lastname);
    }

    public void postEmployee(String firstname, String lastname){
        String id = String.valueOf(employeeRepository.getAllEmployeeList().toArray().length+1);
        employeeRepository.postEmployee(id,firstname,lastname);
    }
}
