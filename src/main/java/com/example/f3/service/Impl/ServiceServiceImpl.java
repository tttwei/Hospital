package com.example.f3.service.Impl;

import com.example.f3.mapper.ServiceMapper;
import com.example.f3.service.ServiceService;
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
    public List<com.example.f3.entity.Service> list() {
        return serviceMapper.list();
    }
}
