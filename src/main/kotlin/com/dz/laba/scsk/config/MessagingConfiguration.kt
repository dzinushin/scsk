package com.dz.laba.scsk.config

import com.dz.laba.scsk.MyMessage
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import java.util.function.Consumer

@Configuration
class MessagingConfiguration {

    companion object {
        const val partitionCount = 3
    }

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

    @Bean
    fun topic1(): NewTopic {
        return createTopic("topic1")
    }

    @Bean
    fun topic2(): NewTopic {
        return createTopic("topic2")
    }

    private fun createTopic(name: String): NewTopic =
        TopicBuilder
            .name(name)
            .partitions(partitionCount)
//            .replicas(replicationFactor)
//            .config(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, minInsyncReplicas)
            .build()
}