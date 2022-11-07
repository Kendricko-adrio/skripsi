package com.skripsi.monolith.controller.notification;

import com.skripsi.monolith.model.notification.Notification;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.notification.NotificationService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class NotificationController {

  private NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @QueryMapping
  public List<Notification> getNotifications(BigInteger id) {
    return notificationService.getNotifications(id);
  }

  @SchemaMapping List<Notification> notifications(User user) {
    return notificationService.getNotifications(user.getId());
  }
}
