package com.example.criteriaqueryfilter;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer customerReview;
    private Integer hardDiskSize;
    private Integer ramSize;
    private Double cpuSpeed;
    private String operatingSystem;
    private Double weight;
    private String cpu;
}
