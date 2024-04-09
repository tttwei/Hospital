package com.example.f3.controller;

import com.example.f3.mapper.PillsMapper;
import com.example.f3.service.PillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pills")
public class PillsController {
    @Autowired
    private PillsService pillsService;

}
