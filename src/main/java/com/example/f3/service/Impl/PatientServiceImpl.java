package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Patient;
import com.example.f3.service.PatientService;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class PatientServiceImpl implements PatientService {
    @Autowired
    private CommonServiceImpl commonService;

    @Override
    public void addPatient(Patient patient) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.addPatient(patient.getIdentity(),patient.getName(),BigInteger.valueOf(patient.getAge()),
                BigInteger.valueOf(patient.getGender()), patient.getImage(),patient.getContact(),
                BigInteger.valueOf(patient.getStatus()),patient.getDate());

    }

    public void updatePatient(Patient patient) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.updatePatient(patient.getIdentity(),patient.getName(),BigInteger.valueOf(patient.getAge()),
                BigInteger.valueOf(patient.getGender()), patient.getImage(),patient.getContact(),
                BigInteger.valueOf(patient.getStatus()),patient.getDate());

    }

    public HospitalCases.Struct2 queryPatient(String addr) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.Struct2 patient = hospitalCases.queryPatient(addr);
        return patient;
    }

//    @Override
//    public void delPatient(String identity) throws Exception {
//        HospitalCases hospitalCases = commonService.init();
//        hospitalCases.del
//
//    }

    public boolean isNull(String str){
        return str==null || str.isEmpty() ? true : false;
    }


}
