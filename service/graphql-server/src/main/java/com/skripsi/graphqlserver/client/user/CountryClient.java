package com.skripsi.graphqlserver.client.user;

import com.skripsi.graphqlserver.client.BaseClient;
import com.skripsi.graphqlserver.model.response.Response;
import com.skripsi.graphqlserver.model.user.Country;
import com.skripsi.graphqlserver.property.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class CountryClient extends BaseClient {

  @Autowired
  private ServiceProperties serviceProperties;

  @Override
  protected String getServiceProperties() {
    return serviceProperties.getUser();
  }

  public CountryClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Country>> getCountries() {
    return restTemplate.exchange(serviceProperties.getUser() + "country",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<List<Country>>>() {
        }).getBody();
  }

  public Response<Country> getCountry(BigInteger id) {
    return restTemplate.exchange(serviceProperties.getUser() + "country/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<Country>>() {
        }).getBody();
  }

}
