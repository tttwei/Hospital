package com.example.f3.mapper;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Service;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {

    Service queryById(Integer id);

    void add(Service service);

    void updateById(Service service);

    void delById(Integer id);

    Page<Service> list(PageDTO pageDTO);
}
