// SPDX-License-Identifier: MIT
pragma solidity ^0.4.25;
pragma experimental ABIEncoderV2;

import "./Base.sol";
contract Patient is Base {
    

    struct PatientInfo{
        //名字
        string name;
        //年龄
        uint8 age;
        //性别
        uint8 gender;
        //头像
        string image;
        //联系方式
        string contact;
        //身份证号
        string identity;//主键
        //正常0，住院1
        uint8 status;
        //出生日期
        string date;
    }

    mapping (string => PatientInfo) public patientMap;
    
    

    // 注册
    function addPatient(string memory name,uint8 sex,uint8 age ,string memory dataBirth) public {
        string memory str = patientMap[msg.sender].name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        PatientInfo memory p = PatientInfo(name,sex,age,2,dataBirth);
        patientMap[msg.sender]=p;
    }
    
    function addPatient(address addr,string memory name,uint8 sex,uint8 age ,string memory dataBirth) public onlyAdmin{
        string memory str = patientMap[addr].name;
        require(keccak256(abi.encodePacked(str)) == keccak256(""),"user has exist");
        PatientInfo memory p = PatientInfo(name,sex,age,2,dataBirth);
        patientMap[addr]=p;
    }

    // 修改
    function updatePatient(string memory name,uint8 sex,uint8 age ,string memory dataBirth) public onlyAdmin{
        string memory str = patientMap[msg.sender].name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user has exist");
        PatientInfo memory p = PatientInfo(name,sex,age,2,dataBirth);
        patientMap[msg.sender]=p;
    }

    function updatePatient(address addr,string memory name,uint8 sex,uint8 age ,string memory dataBirth) public onlyAdmin{
        string memory str = patientMap[addr].name;
        require(keccak256(abi.encodePacked(str)) != keccak256(""),"user has exist");
        PatientInfo memory p = PatientInfo(name,sex,age,2,dataBirth);
        patientMap[addr]=p;
    }

    // 查询
    function queryPatient(address addr) public view returns (PatientInfo memory){
        return patientMap[addr];
    }

    function queryPatient() public view returns (PatientInfo memory){
        return patientMap[msg.sender];
    }

    

}