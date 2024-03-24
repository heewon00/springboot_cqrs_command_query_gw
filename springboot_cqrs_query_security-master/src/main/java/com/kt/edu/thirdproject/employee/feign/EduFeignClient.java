package com.kt.edu.thirdproject.employee.feign;

import com.kt.edu.thirdproject.employee.query.domain.EmployeeEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="edu", url="${api.edu.url}")
//@FeignClient(name="edu", url="https://jsonplaceholder.typicode.com",configuration = FeignConfig.class)
public interface EduFeignClient {
    //알아서 restAPI찾아서 값을 던져줌
    //https://jsonplaceholder.typicode.com/users
    @GetMapping(path = "/users", produces = "application/json")
    public String getUsers();

    //command 쪽에 있는 서비스 호출
    @PostMapping(path = "/api/v1/employees", consumes = "application/json")
    public ResponseEntity<EmployeeEntity> EmployeeCreate(@RequestBody EmployeeEntity employeeEntity);


}