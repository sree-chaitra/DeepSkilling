package com.example.employee.service;

import com.example.employee.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

@Service
public class EmployeeService {
    private List<Employee> employeeList;

    @PostConstruct
    public void loadEmployees() throws Exception {
        InputStream is = getClass().getResourceAsStream("/employees.xml");
        JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        EmployeeList wrapper = (EmployeeList) unmarshaller.unmarshal(is);
        employeeList = wrapper.getEmployees();
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @jakarta.xml.bind.annotation.XmlRootElement(name = "employees")
    public static class EmployeeList {
        private List<Employee> employees;

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }
    }
}