package com.example.ormlearn;

import com.example.ormlearn.model.Department;
import com.example.ormlearn.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        DepartmentService departmentService = context.getBean(DepartmentService.class);
        testGetDepartment(departmentService);
    }

    private static void testGetDepartment(DepartmentService departmentService) {
        Department department = departmentService.get(1);
        System.out.println("Department: " + department);
        System.out.println("Employees: " + department.getEmployeeList());
    }
}