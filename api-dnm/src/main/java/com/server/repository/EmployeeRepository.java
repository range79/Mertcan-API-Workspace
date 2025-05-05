package com.server.repository;

import com.server.config.AppConfig;
import com.server.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    public Employee getEmployeeById(String id){
        Employee finalEmployee = null;
        for(Employee employee :employeeList){
            if(id.equals(employee.getId())){
                finalEmployee = employee;
                break;
            }
        }
        return finalEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstname , String lastname){
        List<Employee> employeeListWithParams = new ArrayList<>();
        for(Employee employee:employeeList){
            if(firstname.equalsIgnoreCase(employee.getFirstname())&&lastname.equalsIgnoreCase(employee.getLastname())){
                employeeListWithParams.add(employee);
            }
        }
        return employeeListWithParams;
    }

    public void postEmployee(String id, String firstname, String lastname){
        employeeList.add(new Employee(id,firstname,lastname));
    }
}
