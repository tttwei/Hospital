package com.example.f3.service;

import com.example.f3.DTO.CasesDTO;
import com.example.f3.VO.CasesVO;
import com.example.f3.entity.Cases;

import java.util.List;

public interface CasesService {
    void addCases(CasesDTO casesDTO) throws Exception;
    List<CasesVO> query(String address) throws Exception;
}
