package com.example.projection;

import com.example.projection.dto.EmployeeInfoDTO;
import com.example.projection.dto.EmployeeNameSalaryProjection;
import com.example.projection.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectionApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Interface-based Projection:");
        for (EmployeeNameSalaryProjection e : employeeService.getEmployeeNamesAndSalaries()) {
            System.out.println(e.getName() + " - " + e.getSalary());
        }

        System.out.println("Class-based Projection:");
        for (EmployeeInfoDTO dto : employeeService.getEmployeeInfoDTOs()) {
            System.out.println(dto.getName() + " - " + dto.getDeptName());
        }
    }
}
