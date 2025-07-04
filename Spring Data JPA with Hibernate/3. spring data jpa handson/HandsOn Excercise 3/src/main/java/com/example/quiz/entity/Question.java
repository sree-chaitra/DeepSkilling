package com.example.quiz.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    private int id;
    private String text;

    @OneToMany(mappedBy = "question")
    private List<Option> options;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}