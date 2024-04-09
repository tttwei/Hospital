package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Doctor;
import com.example.f3.entity.R;
import com.example.f3.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public R add(@RequestBody Doctor doctor) throws Exception {
//        log.info("{}",doctorInfo);
        doctorService.addDoctor(doctor);
        return R.success();
    }
    @PutMapping( "/update")
    public R update(@RequestBody Doctor doctor) throws Exception {
        doctorService.updateDoctor(doctor);
        return R.success();
    }
    @GetMapping
    public R<HospitalCases.Struct1> query(String address) throws Exception {
        HospitalCases.Struct1 doctor = doctorService.queryDoctor(address);
        return R.success(doctor);
    }
    @DeleteMapping("/{address}")
    public R del(@PathVariable(required = false) String address) throws Exception {
        doctorService.delDoctor(address);
        return R.success();
    }



}
