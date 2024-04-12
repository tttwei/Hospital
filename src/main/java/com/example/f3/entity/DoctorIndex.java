package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorIndex {
    private String address;
    private String name;
    private LocalDateTime createTime;
    //0正常，1管理员，2离职
    private int status;
}
