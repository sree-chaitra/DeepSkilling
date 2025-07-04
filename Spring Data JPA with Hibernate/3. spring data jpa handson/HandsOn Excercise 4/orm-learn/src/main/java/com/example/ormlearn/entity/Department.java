package com.example.ormlearn.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    // Getters and setters
}
