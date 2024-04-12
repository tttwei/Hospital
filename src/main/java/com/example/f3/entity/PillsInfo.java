package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PillsInfo extends Pills implements Serializable {
    //药
//    private Pills pills;
    //数量
    private Integer number;
    //使用说明
    private String use;
}
