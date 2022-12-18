package com.skripsi.graphqlserver.client.user;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.model.user.Role;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class RoleClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getUser();
  }

  public RoleClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Role>> getRoles() {
    return restTemplate.exchange(serviceProperties.getUser() + "role",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<List<Role>>>() {
        }).getBody();
  }

  public Response<Role> getRole(BigInteger id) {
    return restTemplate.exchange(serviceProperties.getUser() + "role/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<Role>>() {
        }).getBody();
  }

}
