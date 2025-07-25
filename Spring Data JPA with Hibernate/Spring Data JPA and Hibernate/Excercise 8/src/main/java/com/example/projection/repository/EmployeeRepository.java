package com.example.projection.repository;

import com.example.projection.entity.Employee;
import com.example.projection.dto.EmployeeNameSalaryProjection;
import com.example.projection.dto.EmployeeInfoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<EmployeeNameSalaryProjection> findBy();

    @Query("SELECT new com.example.projection.dto.EmployeeInfoDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeInfoDTO> fetchEmployeeInfo();
}
