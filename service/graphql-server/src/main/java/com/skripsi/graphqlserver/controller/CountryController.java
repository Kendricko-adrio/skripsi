package com.skripsi.graphqlserver.controller;

import com.skripsi.graphqlserver.model.user.Country;
import com.skripsi.graphqlserver.client.user.CountryClient;
import com.skripsi.graphqlserver.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {

  @Autowired
  private CountryClient countryClient;

  @QueryMapping
  public List<Country> getCountries() {
    return countryClient.getCountries().getData();
  }

  @Deprecated
  @SchemaMapping
  public Country country(User user) {
    return countryClient.getCountry(user.getCountry().getId()).getData();
  }

}
