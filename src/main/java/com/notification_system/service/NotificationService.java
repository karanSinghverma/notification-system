package com.notification_system.service;

import com.notification_system.model.Notification;
import com.notification_system.model.UserEvent;
import com.notification_system.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Converts events into notifications and stores them.
 */
@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final UserPreferenceService preferenceService;

    public NotificationService(NotificationRepository repository, UserPreferenceService preferenceService) {
        this.repository = repository;
        this.preferenceService = preferenceService;
    }
    /**
     * Process incoming event and save notification
     */
    public void processEvent(UserEvent event){
        Notification notification = new Notification();

        notification.setUserId(event.getToUser());
        notification.setMessage(event.getType() + " from " + event.getFromUser());
        notification.setStatus("UNREAD");
        notification.setCreatedAt(LocalDateTime.now());

        if (!preferenceService.isNotificationAllowed(
                event.getToUser(),
                event.getType())) {
            System.out.println("Notification blocked by user preference");
            return;
        }

        repository.save(notification);

        System.out.println("Notification saved in DB");
    }
}
