package com.skripsi.monolith.controller.user;
import com.skripsi.monolith.model.user.Country;
import com.skripsi.monolith.model.user.User;
import com.skripsi.monolith.service.user.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {

  @Autowired
  private CountryService countryService;

  @QueryMapping
  public List<Country> getCountries(){
    return countryService.getCountries();
  }

  @SchemaMapping
  public Country country(User user) {
    return countryService.getCountry(user.getCountry().getId());
  }

}
