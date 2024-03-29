package com.skripsi.userskripsi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skripsi.userskripsi.model.Country;
import com.skripsi.userskripsi.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class CountryService {

  private final CountryRepository countryRepository;


  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  public List<Country> getCountries(){
    return countryRepository.findAll();
  }

  public Country getCountry(BigInteger id) {
    return countryRepository.findById(id).orElse(null);
  }

}
