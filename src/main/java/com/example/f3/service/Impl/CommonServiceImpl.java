package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.ClientAndKeyPair;
import com.example.f3.properties.ConfigProperties;
import com.example.f3.service.CommonService;
import org.fisco.bcos.sdk.BcosSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import utils.ContractUtil;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private BcosSDK bcosSDK;
    @Autowired
    private ConfigProperties configProperties;

    /**
     * TODO 将来浏览器读取文件作为参数
     *
     * @return
     */
    @Override
    public HospitalCases init() throws Exception {
        String contractAddress = configProperties.getContractAddress();
        String pemPath = configProperties.getPemAccountFilePath();
        HospitalCases hospitalCases = ContractUtil.contractLoad(bcosSDK,contractAddress,pemPath,HospitalCases.class);
        return hospitalCases;
    }

    /**
     * TODO 将来浏览器读取文件作为参数
     * @return
     */
    @Override
    public String getAddress(){
        ClientAndKeyPair clientAndKeyPair = ContractUtil.clientInit(bcosSDK, configProperties.getPemAccountFilePath());
        return clientAndKeyPair.getCryptoKeyPair().getAddress();
    }


}
