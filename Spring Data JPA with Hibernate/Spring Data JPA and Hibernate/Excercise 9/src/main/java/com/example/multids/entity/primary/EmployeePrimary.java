package com.example.multids.entity.primary;

import jakarta.persistence.*;

@Entity
public class EmployeePrimary {
    @Id
    private int id;
    private String name;
    private double salary;

    // Getters and setters
}
