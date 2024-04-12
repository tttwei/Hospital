package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends Person implements Serializable {
    //工号,用户地址值
    private String address;
    //单位
    private String hospital;
    //科室，部门
    private Integer department;
}
