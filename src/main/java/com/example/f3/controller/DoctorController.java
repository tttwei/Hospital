package com.example.f3.controller;

import com.example.f3.DTO.PageDTO;
import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Doctor;
import com.example.f3.entity.PageResult;
import com.example.f3.entity.R;
import com.example.f3.service.DoctorIndexService;
import com.example.f3.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorIndexService doctorIndexService;

    @PostMapping("/add")
    public R add(@RequestBody Doctor doctor) throws Exception {
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
    @GetMapping("/list")
    public R<List<Doctor>> list(PageDTO pageDTO){
        List<Doctor> list = doctorService.list(pageDTO);
        return R.success(list);
    }
//    @GetMapping("/test")
//    public R<PageResult> list2(PageDTO pageDTO){
//        List<HospitalCases.Struct1> list = doctorService.list(doctorPageDTO);
//        PageResult list = doctorIndexService.list(pageDTO);
//        return R.success(list);
//    }

    @DeleteMapping({"/{address}","/"})
    public R del(@PathVariable(required = false) String address) throws Exception {
        log.info(address);
        doctorService.delDoctor(address);
        return R.success();
    }


}
