package com.skripsi.graphqlserver.client.notification;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.notification.Notification;
import com.skripsi.graphqlserver.model.request.notification.NotificationRequest;
import com.skripsi.graphqlserver.model.request.notification.ReadNotificationsRequest;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class NotificationClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  public NotificationClient(RestTemplateBuilder builder) {
    super(builder);
  }

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getNotification();
  }

  public Response<List<Notification>> getNotifications(BigInteger id) {
    return get("notification/" + id,
        new ParameterizedTypeReference<Response<List<Notification>>>() {
        });
  }

  public Response<Boolean> readNotifications(ReadNotificationsRequest request) {
    return post("notification/read", request, new ParameterizedTypeReference<Response<Boolean>>() {
    });
  }

  public Response<Notification> saveJobApplicationNotification(NotificationRequest request) {
    return post(request, new ParameterizedTypeReference<Response<Notification>>() {
    });
  }

}
