package com.example.f3.VO;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CasesVO {
//    private String casesId;

    private String doctorId;

    private String dname;

    private String patientId;

    private String pname;

    private BigInteger page;

    private BigInteger pgender;

    private String pdate;

    private String hospital;

    private String department;

    private String time;

    private String description;

    private String pillsList;

    private String serviceList;

    private String acount;
}
