package com.skripsi.graphqlserver;

import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {
    ServiceProperties.class
})
public class GraphqlServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlServerApplication.class, args);
  }

}
