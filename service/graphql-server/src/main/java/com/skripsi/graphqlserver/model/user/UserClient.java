package com.skripsi.graphqlserver.model.user;

import com.skripsi.graphqlserver.controller.BaseClient;
import com.skripsi.graphqlserver.model.request.Request;
import com.skripsi.graphqlserver.model.request.user.UserLoginDTO;
import com.skripsi.graphqlserver.model.request.user.UserRequestDTO;
import com.skripsi.graphqlserver.model.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Component
public class UserClient extends BaseClient {

  public UserClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<User>> getUsers() {
    return restTemplate.exchange(USER_URL + "user",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<List<User>>>() {
        }).getBody();
  }

  public Response<User> getUser(BigInteger id) {
    return restTemplate.exchange(USER_URL + "user/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<User>>() {
        }).getBody();
  }

  public Response<User> getUserByUsername(String username) {
    return restTemplate.exchange(USER_URL + "user/username/" + username,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<User>>() {
        }).getBody();
  }

  public Response<Boolean> checkUserLogin(UserLoginDTO user) {
    return restTemplate.exchange(USER_URL + "user/login",
        HttpMethod.POST,
        new HttpEntity<>(user),
        new ParameterizedTypeReference<Response<Boolean>>() {
        }).getBody();
  }

  public Response<User> insertUser(UserRequestDTO request) {
    HttpEntity<UserRequestDTO> entity = new HttpEntity<>(request);
    return restTemplate.exchange(USER_URL + "user",
        HttpMethod.POST,
        entity,
        new ParameterizedTypeReference<Response<User>>() {
        }).getBody();
  }

  public Response<User> updateUser(UserRequestDTO request) {
    HttpEntity<UserRequestDTO> entity = new HttpEntity<>(request);
    return restTemplate.exchange(USER_URL + "user",
        HttpMethod.PUT,
        entity,
        new ParameterizedTypeReference<Response<User>>() {
        }).getBody();
  }

}
