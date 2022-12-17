package com.skripsi.userskripsi.controller;

import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.model.Country;
import com.skripsi.userskripsi.model.User;
import com.skripsi.userskripsi.model.response.Response;
import com.skripsi.userskripsi.service.CountryService;
import com.skripsi.userskripsi.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

  @Autowired
  private CountryService countryService;

  @GetMapping
  public Response<List<Country>> getCountries() {
    return ResponseHandler.ok(countryService.getCountries());
  }

  @GetMapping("/{id}")
  public Response<Country> country(@PathVariable BigInteger id) {
    return ResponseHandler.ok(countryService.getCountry(id));
  }

}
