package com.example.f3.service;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Pills;
import com.example.f3.entity.Service;

import java.util.List;

public interface ServiceService {
    Service queryById(Integer id);

    void add(Service service);
    void updateById(Service service);
    void delById(Integer id);
    PageResult list(PageDTO pageDTO);
}
