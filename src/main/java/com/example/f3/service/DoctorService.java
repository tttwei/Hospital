package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Doctor;

public interface DoctorService {
    void addDoctor(Doctor doctor) throws Exception;

    void updateDoctor(Doctor doctor) throws Exception;
    HospitalCases.Struct1 queryDoctor(String address) throws Exception;
    void delDoctor(String addr) throws Exception;
}
