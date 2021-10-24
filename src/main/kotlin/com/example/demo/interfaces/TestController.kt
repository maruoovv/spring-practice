package com.example.demo.interfaces

import com.example.demo.domain.TestService
import mu.KotlinLogging
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/test")
class TestController(
        private val testService: TestService
) {

    private val logger = KotlinLogging.logger {  }

    @GetMapping
    fun getTest(): String {
        val random = UUID.randomUUID().toString()
        MDC.put(random, random)
        logger.info { "hello" }

        val result = testService.httpTest()
//        MDC.clear()

        return result
    }
}