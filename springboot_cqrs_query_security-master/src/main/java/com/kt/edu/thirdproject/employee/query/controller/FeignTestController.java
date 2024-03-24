package com.kt.edu.thirdproject.employee.query.controller;

import com.kt.edu.thirdproject.employee.query.service.FeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignTestController {

    @Autowired
    private FeignTestService feignTestService;

    @GetMapping("/feign/test")
    public String getUsers() {
        return feignTestService.getUsers();
    }
}