package com.example.department.dao;

import com.example.department.model.Department;
import java.util.List;

public class DepartmentDao {
    public static List<Department> DEPARTMENT_LIST;

    public DepartmentDao(List<Department> departments) {
        DEPARTMENT_LIST = departments;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}