package com.example.f3.controller;

import com.example.f3.DTO.CasesDTO;
import com.example.f3.VO.CasesVO;
import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;
import com.example.f3.entity.R;
import com.example.f3.service.CasesService;
import com.example.f3.service.Impl.CasesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CasesController{
    @Autowired
    private CasesService casesService;
    @PostMapping("/addCases")
    public R<String> add(@RequestBody CasesDTO casesDTO) throws Exception {
        casesService.addCases(casesDTO);
        return R.success();
    }
    @GetMapping("/{address}")
    public R<List<CasesVO>> query(@PathVariable String address) throws Exception {
        List<CasesVO> list = casesService.query(address);
        return R.success(list);
    }
}
