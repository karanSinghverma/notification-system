package com.notification_system.service;

import com.notification_system.model.UserPreference;
import com.notification_system.repository.UserPreferenceRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import java.util.Optional;

/**
 * Handles logic related to user preferences.
 */
@Service
public class UserPreferenceService {
    private final UserPreferenceRepository repository;



    public UserPreferenceService(UserPreferenceRepository repository) {
        this.repository = repository;
    }

    /**
     * Check if notification should be sent
     */


    @Cacheable(value = "userpreferences", key = "#userId")


    public boolean isNotificationAllowed(String userId, String eventType) {

        System.out.println("Checking preference from DB");
        Optional<UserPreference> optional = repository.findById(userId);


        // If no preference set → allow by default
        if (optional.isEmpty()) {
            return true;
        }

        UserPreference pref = optional.get();

        if (!pref.isNotificationsEnabled()) {
            return false;
        }

        return switch (eventType) {
            case "LIKE" -> pref.isLikeEnabled();
            case "COMMENT" -> pref.isCommentEnabled();
            default -> true;
        };
    }
}
