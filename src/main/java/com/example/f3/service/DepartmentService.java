package com.example.f3.service;

import com.example.f3.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department queryById(Integer id);
    void add(Department department);
    void updateById(Department department);
    void delById(Integer id);

    List<Department> list();
}
