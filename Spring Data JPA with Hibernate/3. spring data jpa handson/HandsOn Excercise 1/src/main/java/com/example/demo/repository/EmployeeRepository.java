package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> findEmployeesWithSalaryGreaterThan(double salary);

    @Query(value = "SELECT * FROM Employee WHERE department = ?1", nativeQuery = true)
    List<Employee> findEmployeesByDepartmentNative(String department);
}