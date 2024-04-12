package com.example.f3.controller;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Department;
import com.example.f3.entity.R;
import com.example.f3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/list")
    public R<PageResult> list(PageDTO pageDTO){
        PageResult list = departmentService.list(pageDTO);
        return R.success(list);
    }
    @GetMapping()
    public R<Department> query(Integer id){
        Department department = departmentService.queryById(id);
        return R.success(department);
    }
    @PutMapping("/update")
    public R update(Department department){
        departmentService.updateById(department);
        return R.success();
    }
    @PostMapping("/add")
    public R add(Department department){
        departmentService.add(department);
        return R.success();
    }
    @DeleteMapping("/del")
    public R del(Integer id){
        departmentService.delById(id);
        return R.success();
    }
}
