package com.example.demo.domain

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class TestService(
        private val restTemplate: RestTemplate
) {
    private val logger = KotlinLogging.logger {  }

    fun httpTest(): String {
        val result = restTemplate.getForObject("http://httpbin.org/get", String::class.java)
        logger.info { "httpbin.org/get result : $result"}
        return result!!
    }
}