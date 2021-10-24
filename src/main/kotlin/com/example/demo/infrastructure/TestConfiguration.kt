package com.example.demo.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class TestConfiguration {

    @Bean
    fun restTemplate() : RestTemplate {
        return RestTemplate()
    }
}