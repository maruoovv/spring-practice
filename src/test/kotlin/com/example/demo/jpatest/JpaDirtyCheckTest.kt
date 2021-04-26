package com.example.demo.jpatest

import com.example.demo.domain.OrderRepository
import com.example.demo.domain.Orders
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class JpaDirtyCheckTest {

    @Autowired
    private lateinit var orderRepository: OrderRepository


    @Test
    @Transactional
    @Rollback(false)
    fun saveTest() {
        val order = Orders(name = "test", count = 3)
        val saved = orderRepository.save(order)

        println(saved)
        saved.name = "updated"

//        orderRepository.saveAndFlush(saved)
    }

    @Test
    @Transactional(readOnly = true)
    @Rollback(false)
    fun dirtyCheckTest() {
        val order1 = orderRepository.getOne(1L)
        val order2 = orderRepository.getOne(2L)

        println(order1)
        println(order2)
    }
}