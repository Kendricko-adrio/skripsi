package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.client.notification.NotificationClient;
import com.skripsi.graphqlserver.model.notification.Notification;
import com.skripsi.graphqlserver.model.request.notification.ReadNotificationsRequest;
import com.skripsi.graphqlserver.model.user.User;
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
  private NotificationClient notificationClient;

  @QueryMapping
  public List<Notification> getNotifications(@Argument BigInteger id) {
    return notificationClient.getNotifications(id).getData();
  }

  @MutationMapping
  public Boolean readNotifications(@Argument List<BigInteger> ids) {
    return notificationClient.readNotifications(ReadNotificationsRequest.builder().ids(ids).build())
        .getData();
  }

  @SchemaMapping List<Notification> notifications(User user) {
    return notificationClient.getNotifications(user.getId()).getData();
  }

}
