package com.example.f3.service;

import com.example.f3.entity.Department;
import com.example.f3.entity.Pills;

import java.util.List;

public interface PillsService {
    Pills queryById(Integer id);
    void add(Pills pills);
    void updateById(Pills pills);
    void delById(Integer id);
    List<Pills> list();
}
