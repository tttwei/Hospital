package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class Patient extends Person implements Serializable {
    //身份证号
    private String identity;
    //正常0，住院1
    private Integer status;
    //出生日期
    private String date;
}
