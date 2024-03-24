package com.kt.edu.thirdproject.employee.feign;

import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
//    @Bean
//    @ConditionalOnMissingBean
//    public Retryer feignRetryer() {
//        return Retryer.NEVER_RETRY;
//    }

}