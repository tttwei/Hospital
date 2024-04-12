package com.example.f3.service.Impl;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.DoctorIndex;
import com.example.f3.entity.PageResult;
import com.example.f3.mapper.DoctorIndexMapper;
import com.example.f3.service.DoctorIndexService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorIndexServiceImpl implements DoctorIndexService {
    @Autowired
    private DoctorIndexMapper doctorIndexMapper;
    @Override
    public void add(DoctorIndex doctorIndex) {
        doctorIndexMapper.add(doctorIndex);
    }

    /**
     * 逻辑删除
     * @param address
     */
    @Override
    public void del(String address) {
        doctorIndexMapper.del(address);
    }

    @Override
    public PageResult list(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPageSize());
        Page<DoctorIndex> page = doctorIndexMapper.list(pageDTO);

        long total = page.getTotal();
        List<DoctorIndex> list = page.getResult();

        return new PageResult(total,list);
    }
}
