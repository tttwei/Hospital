package com.example.f3.service;

import com.example.f3.contract.HospitalCases;

public interface CommonService {
    HospitalCases init() throws Exception;

    String getAddress();
}
