package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Service implements Serializable {
    private Integer id;
    private String name;
    //单价
    private BigDecimal money;
    //服务介绍
    private String serviceDescription;
}
