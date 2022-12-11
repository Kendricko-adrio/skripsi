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

    //  public Notification saveJobApplicationNotification(User targetUser, NotificationStatus status) {
//    return repository.save(Notification.builder()
//        .content(status.name())
//        .read(false)
//            .userId(targetUser.getId())
//        .build());
//  }
    public Notification saveJobApplicationNotification(BigInteger id, NotificationStatus status) {
        return repository.save(Notification.builder()
                .content(status.name())
                .read(false)
                .userId(id)
                .build());
    }
}
