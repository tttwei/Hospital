package com.example.f3.service;


import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.DoctorIndex;
import com.example.f3.entity.PageResult;

public interface DoctorIndexService {
    //增
    void add(DoctorIndex doctorIndex);
    //删
    void del(String address);

    PageResult list(PageDTO pageDTO);
}
