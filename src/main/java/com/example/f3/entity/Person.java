package com.example.f3.entity;

import lombok.Data;

@Data
public class Person {
    //名字
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer gender;
    //头像
    private String image;
    //联系方式
    private String contact;
}
