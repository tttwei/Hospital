package com.example.f3.mapper;

import com.example.f3.entity.Service;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {

    Service queryById(Integer id);

    void add(Service service);

    void updateById(Service service);

    void delById(Integer id);

    List<Service> list();
}
