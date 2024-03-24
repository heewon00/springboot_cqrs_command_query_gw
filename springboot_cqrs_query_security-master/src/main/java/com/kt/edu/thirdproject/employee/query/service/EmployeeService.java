package com.kt.edu.thirdproject.employee.query.service;

import com.kt.edu.thirdproject.employee.feign.EduFeignClient;
import com.kt.edu.thirdproject.employee.query.domain.EmployeeEntity;
import com.kt.edu.thirdproject.employee.query.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EduFeignClient eduFeignClient;

    @Cacheable("employees")
    public List<EmployeeEntity> getEmployeeList() {
        log.info("Request to get all Employees");
        log.info("🔥eduFeignClient",eduFeignClient.getUsers());
        List<EmployeeEntity> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    // 플러시를 생략해서 dirty checking등을 하지 않으므로 약간의 성능 향상
    @Cacheable("employee")
    @Transactional(readOnly = true)
    public EmployeeEntity getEmployee(Long id) {
        log.info("Request to get Employee : {}", id);
        return employeeRepository.findById(id).get();
    }

}
