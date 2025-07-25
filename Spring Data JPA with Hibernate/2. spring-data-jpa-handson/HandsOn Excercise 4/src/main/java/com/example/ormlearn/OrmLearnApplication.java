
package com.example.ormlearn;

import com.example.ormlearn.model.Department;
import com.example.ormlearn.model.Employee;
import com.example.ormlearn.service.DepartmentService;
import com.example.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        testAddEmployee();
        testGetEmployee();
        testUpdateEmployee();
    }

    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");
        Department dept = departmentService.get(1);

        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setSalary(75000);
        emp.setPermanent(true);
        emp.setDateOfBirth(Date.valueOf("1993-03-15"));
        emp.setDepartment(dept);

        employeeService.save(emp);
        LOGGER.debug("Saved Employee: {}", emp);
        LOGGER.info("End testAddEmployee");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        Employee emp = employeeService.get(1);
        LOGGER.debug("Employee: {}", emp);
        LOGGER.debug("Department: {}", emp.getDepartment());
        LOGGER.info("End testGetEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");
        Employee emp = employeeService.get(1);
        Department newDept = departmentService.get(2);
        emp.setDepartment(newDept);
        employeeService.save(emp);
        LOGGER.debug("Updated Employee: {}", emp);
        LOGGER.info("End testUpdateEmployee");
    }
}
