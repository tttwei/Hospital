package com.example.f3.controller;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Service;
import com.example.f3.entity.R;
import com.example.f3.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @GetMapping("/list")
    public R<PageResult> list(PageDTO pageDTO){
        PageResult list = serviceService.list(pageDTO);
        return R.success(list);
    }
    @GetMapping()
    public R<Service> query(Integer id){
        Service service = serviceService.queryById(id);
        return R.success(service);
    }
    @PutMapping("/update")
    public R update(Service service){
        serviceService.updateById(service);
        return R.success();
    }
    @PostMapping("/add")
    public R add(Service service){
        serviceService.add(service);
        return R.success();
    }
    @DeleteMapping("/del")
    public R del(Integer id){
        serviceService.delById(id);
        return R.success();
    }
}
