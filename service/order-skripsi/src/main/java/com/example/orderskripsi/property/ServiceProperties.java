package com.example.orderskripsi.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("service")
public class ServiceProperties {

  private String user = "http://localhost:8081/api/";
  private String course = "http://localhost:8082/api/";
//  private String order = "http://localhost:8083/api/";
  private String notification = "http://localhost:8084/api/";
  private String notificationDocker = "http://notification-service:8084/api/";


}
