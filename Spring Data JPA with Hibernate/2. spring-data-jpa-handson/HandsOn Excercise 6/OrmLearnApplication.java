package com.example.ormlearn;

import com.example.ormlearn.model.Employee;
import com.example.ormlearn.model.Skill;
import com.example.ormlearn.service.EmployeeService;
import com.example.ormlearn.service.SkillService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        SkillService skillService = context.getBean(SkillService.class);

        // testGetEmployee(employeeService);
        testAddSkillToEmployee(employeeService, skillService);
    }

    private static void testGetEmployee(EmployeeService employeeService) {
        Employee employee = employeeService.get(1);
        System.out.println("Employee: " + employee);
        System.out.println("Skills: " + employee.getSkillList());
    }

    private static void testAddSkillToEmployee(EmployeeService employeeService, SkillService skillService) {
        Employee employee = employeeService.get(1);
        Skill skill = skillService.get(2);

        Set<Skill> skills = employee.getSkillList();
        skills.add(skill);
        employee.setSkillList(skills);
        employeeService.save(employee);

        System.out.println("Updated Employee with new skill: " + employee);
    }
}