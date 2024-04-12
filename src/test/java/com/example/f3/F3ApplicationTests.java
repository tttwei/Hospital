package com.example.f3;

import com.example.f3.DTO.PageDTO;
import com.example.f3.entity.DoctorIndex;
import com.example.f3.entity.PageResult;
import com.example.f3.service.DoctorIndexService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class F3ApplicationTests {
    @Autowired
    private DoctorIndexService doctorIndexService;
    @Test
    @Transactional
    void contextLoads() {
//        PageDTO pageDTO = new PageDTO(1, 10);
//        PageResult list = doctorIndexService.list(pageDTO);
////        System.out.println(list);
//    log.info(String.valueOf(list));
        LocalDateTime now = LocalDateTime.now();
        DoctorIndex index = new DoctorIndex("0x7878", "阿伟", now, 0);
        doctorIndexService.add(index);
        int i = 1 / 0;


    }

}
