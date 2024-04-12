package com.example.f3.controller;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.Pills;
import com.example.f3.entity.R;
import com.example.f3.mapper.PillsMapper;
import com.example.f3.service.PillsService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pills")
public class PillsController {
    @Autowired
    private PillsService pillsService;
    @GetMapping("/list")
    public R<PageResult> list(PageDTO pageDTO){
        PageResult list = pillsService.list(pageDTO);
        return R.success(list);
    }
    @GetMapping()
    public R<Pills> query(Integer id){
        Pills pills = pillsService.queryById(id);
        return R.success(pills);
    }
    @PutMapping("/update")
    public R update(Pills pills){
        pillsService.updateById(pills);
        return R.success();
    }
    @PostMapping("/add")
    public R add(Pills pills){
        pillsService.add(pills);
        return R.success();
    }
    @DeleteMapping("/del")
    public R del(Integer id){
        pillsService.delById(id);
        return R.success();
    }
}
