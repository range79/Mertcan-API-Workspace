package com.server.repository;

import com.server.config.AppConfig;
import com.server.model.Employee;
import com.server.model.UpdateEmployeeRequest;
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

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id){
        boolean flag = false;
        Employee deleteEmployee = null;
        for(Employee employee:employeeList){
            if(employee.getId().equalsIgnoreCase(id)){
                deleteEmployee = employee;
                flag = true;
            }
        }
        if(deleteEmployee!=null){
            employeeList.remove(deleteEmployee);
        }
        return flag;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request){
        Employee putEmployee = null;
        for(Employee employee : employeeList){
            if(employee.getId().equalsIgnoreCase(id)){
                putEmployee = employee;
                break;
            }
        }
        if(putEmployee!=null){
            deleteEmployee(id);
            putEmployee.setFirstname(request.getFirstname());
            putEmployee.setLastname(request.getLastname());
            saveEmployee(putEmployee);
        }

        return putEmployee;
    }
}
