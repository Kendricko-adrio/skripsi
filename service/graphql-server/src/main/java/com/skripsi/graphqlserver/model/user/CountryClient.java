package com.skripsi.graphqlserver.model.user;

import com.skripsi.graphqlserver.controller.BaseClient;
import com.skripsi.graphqlserver.model.response.Response;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class CountryClient extends BaseClient {

  public CountryClient(RestTemplateBuilder builder) {
    super(builder);
  }

  public Response<List<Country>> getCountries() {
    return restTemplate.exchange(USER_URL + "country",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<List<Country>>>() {
        }).getBody();
  }

  public Response<Country> getCountry(BigInteger id) {
    return restTemplate.exchange(USER_URL + "country/" + id,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<Response<Country>>() {
        }).getBody();
  }

}
