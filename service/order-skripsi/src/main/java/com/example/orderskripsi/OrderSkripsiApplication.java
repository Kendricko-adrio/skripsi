package com.example.orderskripsi;

import com.example.orderskripsi.property.ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
    ServiceProperties.class
})
public class OrderSkripsiApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrderSkripsiApplication.class, args);
  }

}
