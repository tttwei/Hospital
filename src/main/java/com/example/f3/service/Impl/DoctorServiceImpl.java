package com.example.f3.service.Impl;

import com.example.f3.contract.Doctor;
import com.example.f3.entity.DoctorInfo;
import com.example.f3.properties.ConfigProperties;
import com.example.f3.service.DoctorService;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private CommonServiceImpl commonService;
    @Override
    // TODO 判断状态处理
    public String addDoctor(String address, DoctorInfo doctorInfo) throws Exception {
        Doctor doctor = commonService.init(Doctor.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = doctor.addDoctor(doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }else {
            transactionReceipt = doctor.addDoctor(address,doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }
        String status = transactionReceipt.getStatus();

        return status;
    }
    public String updateDoctor(String address, DoctorInfo doctorInfo) throws Exception {
        Doctor doctor = commonService.init(Doctor.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = doctor.updateDoctor(doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }else {
            transactionReceipt = doctor.updateDoctor(address,doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }
        return transactionReceipt.getStatus();
    }
    public Doctor.Struct0 query(String address) throws Exception {
        Doctor doctor = commonService.init(Doctor.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        Doctor.Struct0 doctorInfo;
        if (address == null||address.equals("")) {
            doctorInfo = doctor.queryDoctor();
        }else {
            doctorInfo = doctor.queryDoctor(address);
        }
        return doctorInfo;
    }

    public void del(String addr) throws Exception {
        Doctor doctor = commonService.init(Doctor.class, ConfigProperties.doctorContract,ConfigProperties.pemAccountFilePath);
        doctor.delDoctor(addr);
    }


//    public DoctorInfo query(String addr) throws ContractException {
//        Doctor doctor = commonService.init();
//        DoctorInfo doctorInfo = doctor.queryDoctor(addr);
//        return doctorInfo;
//    }





}
