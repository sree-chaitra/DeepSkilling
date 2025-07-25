package com.example.multids.entity.secondary;

import jakarta.persistence.*;

@Entity
public class EmployeeSecondary {
    @Id
    private int id;
    private String name;
    private double salary;

    // Getters and setters
}
