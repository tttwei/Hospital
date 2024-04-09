package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Patient;

public interface PatientService {
    void addPatient(Patient patient) throws Exception;
    void updatePatient(Patient patient) throws Exception;
    HospitalCases.Struct2 queryPatient(String identity) throws Exception;

//    void delPatient(String identity) throws Exception;
//    HospitalCases.Struct0 query() throws Exception;
}
