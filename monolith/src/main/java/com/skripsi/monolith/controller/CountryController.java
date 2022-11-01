package com.skripsi.monolith.controller;

import com.skripsi.monolith.model.Country;
import com.skripsi.monolith.model.User;
import com.skripsi.monolith.service.CountryService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {

  private final CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @QueryMapping
  public List<Country> getCountries(){
    return countryService.getCountries();
  }

  @SchemaMapping
  public Country country(User user) {
    return countryService.getCountry(user.getCountryId());
  }

}
