package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Doctor;
import com.example.f3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private CommonServiceImpl commonService;

    @Override
    public void addDoctor(Doctor doctor) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        if (isNull(doctor.getAddress())){
            hospitalCases.addDoctor(doctor.getName(),BigInteger.valueOf(doctor.getAge()),BigInteger.valueOf(doctor.getGender()),
                    doctor.getImage(),doctor.getContact(),doctor.getHospital(),BigInteger.valueOf(doctor.getDepartment()));
        }else {
            hospitalCases.addDoctor(doctor.getAddress(),doctor.getName(),BigInteger.valueOf(doctor.getAge()),
                    BigInteger.valueOf(doctor.getGender()), doctor.getImage(),doctor.getContact(),doctor.getHospital(),BigInteger.valueOf(doctor.getDepartment()));
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        if (isNull(doctor.getAddress())){
            hospitalCases.updateDoctor(doctor.getName(),BigInteger.valueOf(doctor.getAge()),BigInteger.valueOf(doctor.getGender()),
                    doctor.getImage(),doctor.getContact(),doctor.getHospital(),BigInteger.valueOf(doctor.getDepartment()));
        }else {
            hospitalCases.updateDoctor(doctor.getAddress(),doctor.getName(),BigInteger.valueOf(doctor.getAge()),
                    BigInteger.valueOf(doctor.getGender()), doctor.getImage(),doctor.getContact(),doctor.getHospital(),BigInteger.valueOf(doctor.getDepartment()));
        }
    }
    @Override
    public HospitalCases.Struct1 queryDoctor(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.Struct1 doctor;
        if (isNull(address)) {
            doctor = hospitalCases.queryMySelf();
        }else {
            doctor = hospitalCases.queryDoctor(address);
        }
        return doctor;
    }
    @Override
    public void delDoctor(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        if (isNull(address)){
            hospitalCases.delDoctor();
        }else {
            hospitalCases.delDoctor(address);
        }
    }

    public boolean isNull(String str){
        return str==null || str.isEmpty() ? true : false;
    }




//    public DoctorInfo query(String addr) throws ContractException {
//        HospitalCases hospitalCases = commonService.init();
//        DoctorInfo doctorInfo = hospitalCases.queryDoctor(addr);
//        return doctorInfo;
//    }





}
