package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import com.example.f3.contract.Patient;
import com.example.f3.entity.PatientInfo;

public interface PatientService {
    String addPatient(String address, PatientInfo doctorInfo) throws Exception;
    String updatePatient(String address,PatientInfo doctorInfo) throws Exception;
    Patient.Struct0 query(String addr) throws Exception;
//    HospitalCases.Struct1 query() throws Exception;
}
