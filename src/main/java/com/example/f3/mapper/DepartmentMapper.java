package com.example.f3.mapper;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.Department;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

//    @Select("select * from depenment where id = #{id}")
    Department queryById(Integer id);

    @Update("update department set name=#{name} where id = #{id};")
    void updateById(Department department);

    @Insert("insert into department (name) values (#{name})")
    void add(Department department);

    @Delete("delete from department where id = #{id}")
    void delById(Integer id);

    Page<Department> list(PageDTO pageDTO);
}
