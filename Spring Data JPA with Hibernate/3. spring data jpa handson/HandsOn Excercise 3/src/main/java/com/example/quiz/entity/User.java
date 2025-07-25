package com.example.quiz.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Attempt> attempts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }
}