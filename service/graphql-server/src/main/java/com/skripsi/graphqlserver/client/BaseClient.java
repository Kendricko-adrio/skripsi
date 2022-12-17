package com.skripsi.graphqlserver.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BaseClient {

  protected RestTemplate restTemplate;

  protected final String USER_URL = "http://localhost:8081/api/";

  public BaseClient(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }

}
