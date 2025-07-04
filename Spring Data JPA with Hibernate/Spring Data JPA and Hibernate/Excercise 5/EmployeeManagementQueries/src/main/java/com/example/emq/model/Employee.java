package com.example.emq.model;

import jakarta.persistence.*;

@NamedQueries({
    @NamedQuery(name = "Employee.findByRole",
                query = "SELECT e FROM Employee e WHERE e.role = :role"),
    @NamedQuery(name = "Employee.findByDepartmentName",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName")
})
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
