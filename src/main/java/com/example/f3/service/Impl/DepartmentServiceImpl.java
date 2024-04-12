package com.example.f3.service.Impl;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.Department;
import com.example.f3.entity.PageResult;
import com.example.f3.mapper.DepartmentMapper;
import com.example.f3.service.DepartmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public Department queryById(Integer id) {
        Department department = departmentMapper.queryById(id);
        return department;
    }

    @Override
    public void add(Department department) {
        departmentMapper.add(department);
    }

    @Override
    public void updateById(Department department) {
        departmentMapper.updateById(department);
    }

    @Override
    public void delById(Integer id) {
        departmentMapper.delById(id);
    }

    @Override
    public PageResult list(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());
        Page<Department> page = departmentMapper.list(pageDTO);

        long total = page.getTotal();
        List<Department> list = page.getResult();

        return new PageResult(total,list);
    }
}
