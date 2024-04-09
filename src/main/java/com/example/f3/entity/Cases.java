package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cases {
    String CasesId;
    //面诊医生
    String doctorId;
    String dname;
    //病人
    String patientId;
    String pname;
    String age;
    //面诊医院
    String hospital;

    //问诊类型,眼科
    String department;
    //问诊时间
    String time;
    //病情描述
    String description;
    //使用的药
    List<PillsInfo> pillsList;
    //服务
    List<ServiceInfo> serviceList;
    //金额
    BigDecimal acount;
}
