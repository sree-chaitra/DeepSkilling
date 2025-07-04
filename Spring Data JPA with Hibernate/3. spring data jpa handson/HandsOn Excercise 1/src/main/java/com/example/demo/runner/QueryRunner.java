package com.example.demo.runner;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryRunner implements CommandLineRunner {

    private final EmployeeRepository repository;

    public QueryRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("JPQL Query: Employees with salary > 30000");
        List<Employee> highSalaryEmployees = repository.findEmployeesWithSalaryGreaterThan(30000);
        highSalaryEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getSalary()));

        System.out.println("\nNative Query: Employees in IT department");
        List<Employee> itEmployees = repository.findEmployeesByDepartmentNative("IT");
        itEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getDepartment()));
    }
}