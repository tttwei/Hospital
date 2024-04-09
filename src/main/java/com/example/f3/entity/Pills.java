package com.example.f3.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Pills {
    private Integer id;
    private String name;
    //单价
    private BigDecimal money;
    //厂家
    private String factory;
}
