package com.example.f3.service;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Pills;

public interface PillsService {
    Pills queryById(Integer id);
    void add(Pills pills);
    void updateById(Pills pills);
    void delById(Integer id);
    PageResult list(PageDTO pageDTO);

}
