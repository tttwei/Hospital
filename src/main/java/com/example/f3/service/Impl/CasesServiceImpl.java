package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;
import com.example.f3.service.CasesService;
import com.example.f3.service.Impl.CommonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.abi.datatypes.DynamicArray;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class CasesServiceImpl implements CasesService {
    @Autowired
    private CommonServiceImpl commonService;

    /**
     * 添加病例
     * @param cases
     * @throws ContractException
     */
    public String addCases(Cases cases) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        // 创建一个LocalDateTime对象，表示当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 创建一个DateTimeFormatter对象，指定日期时间的格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 使用DateTimeFormatter对象将LocalDateTime格式化为指定格式的字符串
        String formattedDateTime = currentDateTime.format(formatter);
        TransactionReceipt transactionReceipt = hospitalCases.addCases(cases.get_patient(), cases.get_appointmentType(),
                formattedDateTime, cases.get_description(), cases.get_prescription(), "250");

//        log.info("case的数据,{},{},{},{},{},{}",cases.get_patient(),cases.get_appointmentType(),
//                cases.get_appointmentTime(),cases.get_description(),cases.get_prescription(),cases.get_money());
        return transactionReceipt.getStatus();
    }

    public List<HospitalCases.Struct2> query(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        DynamicArray<HospitalCases.Struct2> list = hospitalCases.queryCases(address);
        List<HospitalCases.Struct2> value = list.getValue();
        return value;
    }
}
