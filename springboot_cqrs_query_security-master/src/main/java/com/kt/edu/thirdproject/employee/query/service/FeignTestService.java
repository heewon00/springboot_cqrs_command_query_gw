package com.kt.edu.thirdproject.employee.query.service;

import com.kt.edu.thirdproject.employee.feign.EduFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignTestService {
    @Autowired
    EduFeignClient eduFeignClient;

    public String getUsers() {
        return eduFeignClient.getUsers(); //feign client에서 method를 호출 한다.
    }
}