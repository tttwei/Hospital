package com.example.f3.service.Impl;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Pills;
import com.example.f3.mapper.ServiceMapper;
import com.example.f3.service.ServiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceMapper serviceMapper;
    @Override
    public com.example.f3.entity.Service queryById(Integer id) {
        com.example.f3.entity.Service service = serviceMapper.queryById(id);
        return service;
    }

    @Override
    public void add(com.example.f3.entity.Service service) {
        serviceMapper.add(service);
    }

    @Override
    public void updateById(com.example.f3.entity.Service service) {
        serviceMapper.updateById(service);
    }

    @Override
    public void delById(Integer id) {
        serviceMapper.delById(id);
    }

    @Override
    public PageResult list(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());
        Page<com.example.f3.entity.Service> page = serviceMapper.list(pageDTO);

        long total = page.getTotal();
        List<com.example.f3.entity.Service> list = page.getResult();

        return new PageResult(total,list);
    }


}
