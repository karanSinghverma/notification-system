package com.notification_system.kafka;

import com.notification_system.model.UserEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka Consumer responsible for listening to events.
 *
 * This class consumes messages from "user-events" topic
 * and processes them for notification generation.
 */

@Service
public class EventConsumer {
    /**
     * Listens to Kafka topic and receives user events.
     *
     * NOTE:
     * This will not run in office environment (Kafka not available),
     * but code is ready for production/home testing.
     */

    @KafkaListener(topics = "user-events", groupId = "notification-group")
    public void consume(UserEvent event){

        // Log received event
        System.out.println("Received event from Kafka: " + event);

        // TODO: In next step, we will process and store notification
    }
}
