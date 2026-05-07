package com.notification_system.controller;

import com.notification_system.kafka.EventProducer;
import com.notification_system.model.UserEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final EventProducer producer;

    public TestController(EventProducer producer){
        this.producer = producer;
    }

    /**
     * API to send test event
     *
     * Example:
     * POST /test/send
     * {
     *   "type": "LIKE",
     *   "fromUser": "userA",
     *   "toUser": "userB"
     * }
     */

    @PostMapping("/send")
    public String sendEvent(@RequestBody UserEvent event){
        producer.sendEvent(event);
        return "Event sent to Kafka \n Notification save in DB";
    }
}
