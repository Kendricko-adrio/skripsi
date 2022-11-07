package com.skripsi.monolith.service.notification;

import com.skripsi.monolith.model.notification.Notification;
import com.skripsi.monolith.repository.notification.NotificationRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class NotificationService {

  private NotificationRepository repository;

  public NotificationService(NotificationRepository repository) {
    this.repository = repository;
  }

  public List<Notification> getNotifications(BigInteger id) {
    return repository.findAllByUser_Id(id);
  }
}
