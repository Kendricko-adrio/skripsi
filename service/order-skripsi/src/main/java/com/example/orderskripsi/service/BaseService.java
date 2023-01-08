package com.example.orderskripsi.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public abstract class BaseService {

  protected RestTemplate restTemplate;

  protected abstract String getServiceProperties();

  public BaseService(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }

  public <T> T get(ParameterizedTypeReference<T> responseType) {
    return get("", responseType);
  }

  public <T> T get(String url, ParameterizedTypeReference<T> responseType) {
    return restTemplate.exchange(getServiceProperties() + url, HttpMethod.GET
        , null, responseType).getBody();
  }

  public <T, S> T post(S request, ParameterizedTypeReference<T> responseType) {
    return post("", request, responseType);
  }

  public <T, S> T post(String url, S request, ParameterizedTypeReference<T> responseType) {
    HttpEntity<S> entity = new HttpEntity<>(request);
    return restTemplate.exchange(getServiceProperties() + url, HttpMethod.POST
        , entity, responseType).getBody();
  }

  public <T, S> T put(String url, S request, ParameterizedTypeReference<T> responseType) {
    HttpEntity<S> entity = new HttpEntity<>(request);
    return restTemplate.exchange(getServiceProperties() + url, HttpMethod.PUT
        , entity, responseType).getBody();
  }

  public <T, S> T delete(String url, ParameterizedTypeReference<T> responseType) {
    return restTemplate.exchange(getServiceProperties() + url, HttpMethod.DELETE
        , null, responseType).getBody();
  }

  public <T, S> T delete(String url, S request, ParameterizedTypeReference<T> responseType) {
    HttpEntity<S> entity = new HttpEntity<>(request);
    return restTemplate.exchange(getServiceProperties() + url, HttpMethod.DELETE,
        entity, responseType).getBody();
  }

}
