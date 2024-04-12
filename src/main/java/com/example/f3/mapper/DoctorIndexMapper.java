package com.example.f3.mapper;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.DoctorIndex;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DoctorIndexMapper {

    @Insert("insert into doctor_index values (#{address},#{name},#{createTime},#{status})")
    void add(DoctorIndex doctorIndex);


    @Update("update doctor_index set status = 2 where doctor_address = #{address}")
    void del(String address);

    @Select("select * from doctor_index where status != 2")
    Page<DoctorIndex> list(PageDTO pageDTO);
}
