package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Patient;
import com.example.f3.entity.R;
import com.example.f3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping({ "/add"})
    public R add( @RequestBody Patient patient) throws Exception {
        patientService.addPatient(patient);
        return R.success();
    }
    @PutMapping("/update")
    public R update(@RequestBody Patient patient) throws Exception {
        patientService.updatePatient(patient);
        return R.success();
    }

    @GetMapping
    public R<HospitalCases.Struct2> query(String address) throws Exception {
        HospitalCases.Struct2 patient = patientService.queryPatient(address);
        return R.success(patient);
    }
}
