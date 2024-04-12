package com.example.f3.service.Impl;

import com.example.f3.DTO.PageDTO;
import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Doctor;
import com.example.f3.entity.DoctorIndex;
import com.example.f3.entity.PageResult;
import com.example.f3.service.CommonService;
import com.example.f3.service.DoctorIndexService;
import com.example.f3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private DoctorIndexService doctorIndexService;

    @Override
    @Transactional
    public void addDoctor(Doctor doctor) throws Exception {
        HospitalCases hospitalCases = commonService.init();

        if (isNull(doctor.getAddress())){
            String address = commonService.getAddress();
            DoctorIndex d = new DoctorIndex(address, doctor.getName(), LocalDateTime.now(), 0);
            //数据库备份，存储地址值，名字状态
            //发生错误回滚，保持数据一致
            doctorIndexService.add(d);
            hospitalCases.addDoctor(doctor.getName(),BigInteger.valueOf(doctor.getAge()),BigInteger.valueOf(doctor.getGender()),
                    doctor.getImage(),doctor.getContact(),doctor.getHospital(),BigInteger.valueOf(doctor.getDepartment()));
        }else {
            DoctorIndex d = new DoctorIndex(doctor.getAddress(), doctor.getName(), LocalDateTime.now(), 0);
            doctorIndexService.add(d);
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
    @Transactional
    public void delDoctor(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        if (isNull(address)){
            doctorIndexService.del(commonService.getAddress());
//            hospitalCases.delDoctor();
        }else {
            doctorIndexService.del(address);
//            hospitalCases.delDoctor(address);
        }
    }

    @Override
    public List<Doctor> list(PageDTO pageDTO) {
        PageResult list = doctorIndexService.list(pageDTO);
        List<DoctorIndex> records = list.getRecords();
        List<Doctor> doctorList = records.stream().map(item -> {
            try {
                HospitalCases.Struct1 doctor = queryDoctor(item.getAddress());
                Doctor doctor1 = new Doctor();
                doctor1.setAddress(doctor.userAddress);
                doctor1.setName(doctor.name);
                doctor1.setAge(doctor.age.intValue());
                doctor1.setGender(doctor.gender.intValue());
                doctor1.setContact(doctor.contact);
                doctor1.setImage(doctor.image);
                doctor1.setHospital(doctor.hospital);
                doctor1.setDepartment(doctor.department.intValue());

                return doctor1;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return doctorList;
    }

    public boolean isNull(String str){
        return str==null || str.isEmpty() ? true : false;
    }



}
