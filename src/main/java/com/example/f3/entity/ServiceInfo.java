package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceInfo extends Service implements Serializable {
//    private Service s;
    //次数
    private Integer number;
}
