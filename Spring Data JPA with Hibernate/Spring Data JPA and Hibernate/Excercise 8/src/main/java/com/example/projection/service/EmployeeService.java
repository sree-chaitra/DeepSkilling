package com.example.projection.service;

import com.example.projection.dto.EmployeeInfoDTO;
import com.example.projection.dto.EmployeeNameSalaryProjection;
import com.example.projection.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeNameSalaryProjection> getEmployeeNamesAndSalaries() {
        return employeeRepository.findBy();
    }

    public List<EmployeeInfoDTO> getEmployeeInfoDTOs() {
        return employeeRepository.fetchEmployeeInfo();
    }
}
