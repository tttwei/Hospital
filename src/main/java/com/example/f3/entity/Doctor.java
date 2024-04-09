package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class Doctor extends Person implements Serializable {
    //工号,用户地址值
    private String address;
    //单位
    private String hospital;
    //科室，部门
    private Integer department;
}
