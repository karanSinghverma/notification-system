package com.notification_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user activity event in the system.
 *
 * This event will be produced by services (e.g., like, comment, follow)
 * and sent to Kafka for asynchronous processing.
 *
 * Example:
 * {
 *   "type": "LIKE",
 *   "fromUser": "userA",
 *   "toUser": "userB"
 * }
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {

    // Type of event (LIKE, COMMENT, FOLLOW, etc.)
    private String type;

    // User who triggered the event
    private String fromUser;

    // User who should receive the notification
    private String toUser;
}
