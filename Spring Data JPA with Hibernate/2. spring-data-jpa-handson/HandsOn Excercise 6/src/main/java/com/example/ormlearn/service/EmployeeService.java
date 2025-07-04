package com.example.ormlearn.service;

import com.example.ormlearn.model.Employee;
import com.example.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee get(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}