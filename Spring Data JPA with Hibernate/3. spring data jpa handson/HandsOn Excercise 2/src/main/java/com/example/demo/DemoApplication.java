package com.example.demo;

import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
    }

    private void testGetAllPermanentEmployees() {
        System.out.println("Start");
        employeeService.getAllPermanentEmployees()
                .forEach(e -> {
                    System.out.println("Employee: " + e.getName() + ", Department: " + e.getDepartment().getName());
                    System.out.println("Skills: " + e.getSkillList());
                });
        System.out.println("End");
    }
}