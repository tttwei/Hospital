package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.properties.ConfigProperties;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import utils.ContractUtil;

@Component
public class CommonServiceImpl {

    @Autowired
    private BcosSDK bcosSDK;



    public  <T> T init(Class<T> c,String contractAddress,String pemPath)  throws Exception {
        T contract = ContractUtil.contractLoad(bcosSDK,contractAddress,pemPath,c);
        return contract;
    }


}
