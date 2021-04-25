package com.example.demo.interfaces

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/hello")
    fun getTest(): String {
        return "hello"
    }
}