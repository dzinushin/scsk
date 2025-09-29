package com.dz.laba.scsk

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class Controller(val streamBridge: StreamBridge) {

    companion object {
        const val topic1 = "producer1-out-0"
        const val topic2 = "producer2-out-0"
    }
    @GetMapping("/bang")
    fun babax() {
        // publish 100 messages to topic1 and topic2
        for(i in 0..99) {
            val message1 = MyMessage(id = UUID.randomUUID().toString(), message = "Hello, babax! $i")
            val message2 = MyMessage(id = UUID.randomUUID().toString(), message = "Privet, babax! $i")
            streamBridge.send(topic1, message1)
            streamBridge.send(topic2, message2)
        }
    }
}