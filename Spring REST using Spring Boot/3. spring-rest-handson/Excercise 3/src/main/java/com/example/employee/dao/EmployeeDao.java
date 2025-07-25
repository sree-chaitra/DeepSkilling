package com.example.employee.dao;

import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

public class EmployeeDao {
    public static ArrayList<Employee> EMPLOYEE_LIST;

    @Autowired
    public EmployeeDao(ArrayList<Employee> employees) {
        EMPLOYEE_LIST = employees;
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}