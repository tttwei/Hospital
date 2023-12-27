package com.example.f3.service.Impl;

import com.example.f3.contract.Doctor;
import com.example.f3.contract.Patient;
import com.example.f3.contract.Patient;
import com.example.f3.entity.PatientInfo;
import com.example.f3.properties.ConfigProperties;
import com.example.f3.service.PatientService;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceImpl implements PatientService {
    @Autowired
    private CommonServiceImpl commonService;
    public String addPatient(String address,PatientInfo doctorInfo) throws Exception {
        Patient patient = commonService.init(Patient.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = patient.addPatient(doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }else {
            transactionReceipt = patient.addPatient(address,doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }

        return transactionReceipt.getStatus();
    }
    public String updatePatient(String address,PatientInfo doctorInfo) throws Exception {
        Patient patient = commonService.init(Patient.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = patient.updatePatient(doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }else {
            transactionReceipt = patient.updatePatient(address,doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }
        return transactionReceipt.getStatus();
    }

    public Patient.Struct0 query(String addr) throws Exception {
        Patient patient = commonService.init(Patient.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        Patient.Struct0 doctorInfo = patient.queryPatient(addr);
        return doctorInfo;
    }

}
