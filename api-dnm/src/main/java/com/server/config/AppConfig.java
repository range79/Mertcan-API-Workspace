package com.server.config;

import com.server.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig{

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Mertcan", "Gundogan"));
        employeeList.add(new Employee("2", "Volkan", "Tastemir"));
        employeeList.add(new Employee("3", "Enes", "Satici"));
        employeeList.add(new Employee("4", "Omer", "Ozay"));
        employeeList.add(new Employee("5", "Mertcan", "Gundogan"));
        return employeeList;
    }
}
