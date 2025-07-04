package com.example.ormlearnnative;

import com.example.ormlearnnative.entity.Employee;
import com.example.ormlearnnative.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnNativeApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnNativeApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("All Employees:");
        for (Employee emp : employeeService.getAllEmployees()) {
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
        }
    }
}
