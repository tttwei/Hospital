package com.example.f3.DTO;

import com.example.f3.entity.PillsInfo;
import com.example.f3.entity.ServiceInfo;
import lombok.Data;

import java.util.List;
@Data
public class CasesDTO {
    //医生地址值
//    private String dAddr;
    //病人地址值
    private String pId;
    //病情描述
    private String description;
    //使用的药
    private List<PillsInfo> pillsList;
    //服务
    private List<ServiceInfo> serviceList;
}
