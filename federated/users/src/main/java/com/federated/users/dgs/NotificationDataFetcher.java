package com.federated.users.dgs;

import com.federated.users.model.notif.Notification;
import com.federated.users.model.user.User;
import com.federated.users.service.NotificationService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@DgsComponent
public class NotificationDataFetcher {

  @Autowired
  private NotificationService notificationService;

  public NotificationDataFetcher(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

//  @QueryMapping
  @DgsQuery
  public List<Notification> getNotifications(@InputArgument String id) {
    return notificationService.getNotifications(new BigInteger(id));
  }

  @DgsData(parentType = "User", field = "notifications")
  List<Notification> notifications(DgsDataFetchingEnvironment dfe) {
    User user = dfe.getSource();
    return notificationService.getNotifications(user.getId());
  }
}
