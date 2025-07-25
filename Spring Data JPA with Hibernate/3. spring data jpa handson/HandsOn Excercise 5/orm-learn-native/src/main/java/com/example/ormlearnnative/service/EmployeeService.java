package com.example.ormlearnnative.service;

import com.example.ormlearnnative.entity.Employee;
import com.example.ormlearnnative.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployeesNative();
    }
}
