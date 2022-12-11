package com.example.orderskripsi.external;

import com.example.orderskripsi.dto.NotificationRequest;
import com.example.orderskripsi.dto.Response;
import com.example.orderskripsi.model.constants.NotificationStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.List;

@Service
public class NotificationService {

  @Value("${order.external.notification.url}")
  private String notificationUrl;
  public void saveJobApplicationNotification(BigInteger userId, NotificationStatus status) {

    RestTemplate restTemplate = new RestTemplate();
//    Response response = restTemplate.postForObject("http://localhost:8080/api/notification", null, Response.class);
    HttpEntity httpEntity = new HttpEntity(new NotificationRequest(userId, status.toString()));
    Response response = restTemplate.exchange(notificationUrl, HttpMethod.POST, httpEntity, Response.class).getBody();

//    return repository.save(Notification.builder()
//        .content(status.name())
//        .read(false)
//        .user(targetUser)
//        .build());
  }
}
