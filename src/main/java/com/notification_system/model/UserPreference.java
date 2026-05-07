package com.notification_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Stores user notification preferences.
 * This controls whether user wants specific notifications.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPreference {
    @Id
    private String userId;

    // Enable/Disable all notifications
    private boolean notificationsEnabled;

    // Enable/Disable LIKE notifications
    private boolean likeEnabled;

    // Enable/Disable COMMENT notifications
    private boolean commentEnabled;
}
