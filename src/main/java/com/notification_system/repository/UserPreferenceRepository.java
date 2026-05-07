package com.notification_system.repository;

import com.notification_system.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Handles DB operations for user preferences.
 */

public interface UserPreferenceRepository extends JpaRepository<UserPreference, String> {
}
