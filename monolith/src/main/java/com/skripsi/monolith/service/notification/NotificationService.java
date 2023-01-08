package com.skripsi.monolith.service.notification;

import com.skripsi.monolith.model.constants.NotificationStatus;
import com.skripsi.monolith.model.notification.Notification;
import com.skripsi.monolith.model.order.JobApplication;
import com.skripsi.monolith.model.user.User;
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

  public List<Notification> getNotifications(BigInteger userId) {
    return repository.findAllByUser_Id(userId);
  }

  public Notification saveJobApplicationNotification(User targetUser, NotificationStatus status) {
    return repository.save(Notification.builder()
        .content(status.name())
        .read(false)
        .user(targetUser)
        .build());
  }

    public Boolean readNotifications(List<BigInteger> ids) {
      for(BigInteger id : ids){
        Notification notification = repository.findById(id).orElse(null);

        if(notification != null){
          notification.setRead(true);
          repository.save(notification);
        }
      }
      return true;
    }
}
