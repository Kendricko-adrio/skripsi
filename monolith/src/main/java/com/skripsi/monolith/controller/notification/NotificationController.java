package com.skripsi.monolith.controller.notification;

import com.skripsi.monolith.model.notification.Notification;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class NotificationController {

  @Autowired
  private NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @QueryMapping
  public List<Notification> getNotifications(@Argument BigInteger id) {
    return notificationService.getNotifications(id);
  }

  @MutationMapping
  public Boolean readNotifications(@Argument List<BigInteger> ids){
    return notificationService.readNotifications(ids);
  }

  @SchemaMapping List<Notification> notifications(User user) {
    return notificationService.getNotifications(user.getId());
  }
}
