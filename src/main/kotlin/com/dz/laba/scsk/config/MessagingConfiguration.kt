package com.dz.laba.scsk.config

import com.dz.laba.scsk.MyMessage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class MessagingConfiguration {

    @Bean
    fun consumer1() = Consumer<MyMessage> { message ->
        val threadName = Thread.currentThread().name
        val threadId = Thread.currentThread().id
        println(">>>>>>> Consumer1 [$threadId][$threadName]: Received message: ${message}")
    }

    @Bean
    fun consumer2() = Consumer<MyMessage> { message ->
        val threadName = Thread.currentThread().name
        val threadId = Thread.currentThread().id
        println("******** Consumer2 [$threadId][$threadName]: Received message: ${message}")
    }
}