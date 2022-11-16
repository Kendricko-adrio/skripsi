package com.skripsi.monolith.service.country;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.monolith.model.country.Country;
import com.skripsi.monolith.repository.country.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class CountryService {

  private final CountryRepository countryRepository;

  @Autowired
  private ObjectMapper objectMapper;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public List<Country> getCountries(){
    return countryRepository.findAll();
  }

  public Country getCountry(BigInteger id) {
    return countryRepository.findById(id).get();
  }

}
