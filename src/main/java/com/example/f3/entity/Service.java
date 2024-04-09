package com.example.f3.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Service {
    private Integer id;
    private String name;
    //单价
    private BigDecimal money;
    //服务介绍
    private String serviceDescription;
}
