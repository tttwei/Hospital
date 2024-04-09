package com.example.f3.service.Impl;

import com.example.f3.entity.Department;
import com.example.f3.entity.Pills;
import com.example.f3.mapper.PillsMapper;
import com.example.f3.service.PillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PillsServiceImpl implements PillsService {
    @Autowired
    private PillsMapper pillsMapper;

    @Override
    public Pills queryById(Integer id) {
        Pills pills = pillsMapper.queryById(id);
        return pills;
    }

    @Override
    public void add(Pills pills) {
        pillsMapper.add(pills);
    }

    @Override
    public void updateById(Pills pills) {
        pillsMapper.updateById(pills);
    }

    @Override
    public void delById(Integer id) {
        pillsMapper.delById(id);
    }

    @Override
    public List<Pills> list() {
        return pillsMapper.list();
    }
}
