package com.skripsi.graphqlserver.client.user;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.request.user.UserLoginDTO;
import com.skripsi.graphqlserver.model.request.user.UserRequestDTO;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.model.user.User;
import com.skripsi.graphqlserver.property.ServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private ServiceProperties serviceProperties;

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getUser();
  }

  public UserClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<User>> getUsers() {
    return get("user", new ParameterizedTypeReference<Response<List<User>>>() {
    });
  }

  public Response<User> getUser(BigInteger id) {
    return get("user/" + id, new ParameterizedTypeReference<Response<User>>() {
    });
  }

  public Response<User> getUserByUsername(String username) {
    return get("user/username/" + username, new ParameterizedTypeReference<Response<User>>() {
    });
  }

  public Response<Boolean> checkUserLogin(UserLoginDTO user) {
    return post("user/login", user, new ParameterizedTypeReference<Response<Boolean>>() {
    });
  }

  public Response<User> insertUser(UserRequestDTO request) {
    return post("user", request, new ParameterizedTypeReference<Response<User>>() {
    });
  }

  public Response<User> updateUser(UserRequestDTO request) {
    return put("user", request, new ParameterizedTypeReference<Response<User>>() {
    });
  }

}
