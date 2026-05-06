package com.notification_system.kafka;

import com.notification_system.model.UserEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka Producer responsible for publishing user events.
 *
 * This class sends events to Kafka topic "user-events".
 * These events will later be consumed by the notification processor.
 */
@Service
public class EventProducer {
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    /**
     * Sends a user event to Kafka.
     *
     * @param event UserEvent object containing activity details
     */

    public void sendEvent(UserEvent event){
        // Send event to Kafka topic
        kafkaTemplate.send("user-events", event);

        // Log for debugging (will help during testing)
        System.out.println("Event sent to Kafka: " + event);
    }
}
