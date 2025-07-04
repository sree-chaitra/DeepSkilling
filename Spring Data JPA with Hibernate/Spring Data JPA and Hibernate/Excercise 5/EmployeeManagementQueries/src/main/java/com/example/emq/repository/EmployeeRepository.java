package com.example.emq.repository;

import com.example.emq.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query
    List<Employee> findByNameContaining(String keyword);

    // JPQL with @Query
    @Query("SELECT e FROM Employee e WHERE e.role = :role")
    List<Employee> findByRole(@Param("role") String role);

    // Native SQL example
    @Query(value = "SELECT * FROM Employee WHERE name LIKE %:name%", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("name") String name);
}
