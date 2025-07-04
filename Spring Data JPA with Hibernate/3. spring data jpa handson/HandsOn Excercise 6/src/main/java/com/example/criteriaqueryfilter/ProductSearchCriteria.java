package com.example.criteriaqueryfilter;

import lombok.Data;

@Data
public class ProductSearchCriteria {
    private Integer customerReview;
    private Integer hardDiskSize;
    private Integer ramSize;
    private Double cpuSpeed;
    private String operatingSystem;
    private Double weight;
    private String cpu;
}
