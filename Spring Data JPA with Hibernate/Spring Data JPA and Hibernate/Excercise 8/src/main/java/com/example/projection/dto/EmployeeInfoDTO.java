package com.example.projection.dto;

public class EmployeeInfoDTO {
    private String name;
    private String deptName;

    public EmployeeInfoDTO(String name, String deptName) {
        this.name = name;
        this.deptName = deptName;
    }

    public String getName() { return name; }
    public String getDeptName() { return deptName; }
}
