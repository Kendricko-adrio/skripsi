package com.example.orderskripsi.external;

import com.example.orderskripsi.dto.NotificationRequest;
import com.example.orderskripsi.dto.Response;
import com.example.orderskripsi.model.constants.NotificationStatus;
import com.example.orderskripsi.property.ServiceProperties;
import com.example.orderskripsi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class NotificationService extends BaseService {

  @Autowired
  private ServiceProperties serviceProperties;

  public NotificationService(RestTemplateBuilder builder) {
    super(builder);
  }

  @Override
  public String getServiceProperties() {
    return serviceProperties.getNotification();
  }

  public void saveJobApplicationNotification(BigInteger userId, NotificationStatus status) {
    NotificationRequest request =
        NotificationRequest.builder().userId(userId).status(status.name()).build();
    post("notification", request, new ParameterizedTypeReference<Response>() {
    });
  }

}
