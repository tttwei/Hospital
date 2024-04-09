package com.example.f3.service.Impl;

import com.example.f3.DTO.CasesDTO;
import com.example.f3.VO.CasesVO;
import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;
import com.example.f3.entity.Department;
import com.example.f3.entity.PillsInfo;
import com.example.f3.entity.ServiceInfo;
import com.example.f3.service.CasesService;
import com.example.f3.service.DepartmentService;
import com.example.f3.service.DoctorService;
import com.example.f3.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.abi.datatypes.DynamicArray;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CasesServiceImpl implements CasesService {
    @Autowired
    private CommonServiceImpl commonService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;



    @Override
    public void addCases(CasesDTO casesDTO) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.Struct1 d = hospitalCases.queryMySelf();
//      id处理 TODO
        long timestamp = System.currentTimeMillis();
        String id = timestamp + "";

//      时间处理
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String time = LocalDateTime.now().format(formatter);
        // System.out.println("当前日期时间（自定义格式）：" + formattedDateTime);
//        list处理 价格计算
        BigDecimal pillsPrice = new BigDecimal("0");
        BigDecimal servicePrice = new BigDecimal("0");
        for (PillsInfo p : casesDTO.getPillsList()){
            BigDecimal m = new BigDecimal(p.getNumber()).multiply(p.getMoney());
            pillsPrice = pillsPrice.add(m);
        }
        for (ServiceInfo s : casesDTO.getServiceList()){
            BigDecimal m = new BigDecimal(s.getNumber()).multiply(s.getMoney());
            servicePrice = servicePrice.add(m);
        }
        BigDecimal price = pillsPrice.add(servicePrice);
        String totalPrice = price.toString();
//        部门处理 通过id查部门
        Department department = departmentService.queryById(d.department.intValue());

        hospitalCases.addCases(id,casesDTO.getPId(),d.hospital,department.getName(),
                time,casesDTO.getDescription(),casesDTO.getPillsList().toString(),
                casesDTO.getServiceList().toString(),totalPrice);

    }

    public List<CasesVO> query(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        DynamicArray<HospitalCases.Struct0> list = hospitalCases.queryCases(address);
        List<HospitalCases.Struct0> value = list.getValue();

        if (value.size()==0) return null;

        String patientId = value.get(0).patientId;
        String doctorId = value.get(0).doctorId;
        HospitalCases.Struct2 patient = patientService.queryPatient(patientId);
        HospitalCases.Struct1 doctor = doctorService.queryDoctor(doctorId);

        List<CasesVO> casesVOList = value.stream().map(item -> {
            CasesVO casesVO = new CasesVO();
            BeanUtils.copyProperties(item, casesVO);
            casesVO.setDname(doctor.name);
            casesVO.setPname(patient.name);
            casesVO.setPage(patient.age);
            casesVO.setPgender(patient.gender);
            casesVO.setPdate(patient.date);
            return casesVO;
        }).collect(Collectors.toList());

        return casesVOList;
    }
}
