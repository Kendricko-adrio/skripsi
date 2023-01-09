package com.example.notificationskripsi.service;

import com.example.notificationskripsi.model.Notification;
import com.example.notificationskripsi.model.constants.NotificationStatus;
import com.example.notificationskripsi.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class NotificationService {

    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> getNotifications(BigInteger userId) {
        return repository.findAllByUserId(userId);
    }

    public Boolean readNotifications(List<BigInteger> ids) {
        for (BigInteger id : ids) {
            Notification notification = repository.findById(id).orElse(null);
            if (notification != null) {
                notification.setRead(true);
                repository.save(notification);
            }
        }
        return true;
    }

    public Notification saveJobApplicationNotification(BigInteger id, NotificationStatus status) {
        return repository.save(Notification.builder()
                .content(status.name())
                .read(false)
                .userId(id)
                .build());
    }
}
