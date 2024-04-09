package com.example.f3.mapper;

import com.example.f3.entity.Pills;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PillsMapper {
    Pills queryById(Integer id);
    @Insert("insert into pills (name,money,factory) values (#{name},#{money},#{factory})")
    void add(Pills pills);

    void updateById(Pills pills);

    void delById(Integer id);

    List<Pills> list();
}
