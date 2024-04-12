package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
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
