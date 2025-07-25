package com.example.emq.controller;

import com.example.emq.model.Employee;
import com.example.emq.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/by-role/{role}")
    public List<Employee> getByRole(@PathVariable String role) {
        return employeeRepository.findByRole(role);
    }

    @GetMapping("/by-name/{keyword}")
    public List<Employee> searchByName(@PathVariable String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }

    @GetMapping("/named-role/{role}")
    public List<Employee> namedQueryRole(@PathVariable String role) {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByRole", Employee.class);
        query.setParameter("role", role);
        return query.getResultList();
    }
}
