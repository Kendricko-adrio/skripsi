package com.skripsi.userskripsi.controller;
import com.skripsi.userskripsi.constant.ResponseMessage;
import com.skripsi.userskripsi.dto.BaseResponse;
import com.skripsi.userskripsi.model.Country;
import com.skripsi.userskripsi.model.User;
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

//  @QueryMapping

  @GetMapping
  public ResponseEntity<BaseResponse> getCountries(){
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, countryService.getCountries());
  }

//  @SchemaMapping
  @GetMapping("/{id}")
  public ResponseEntity<BaseResponse> country(@PathVariable BigInteger id) {
    return ResponseHandler.generateResponse(ResponseMessage.SUCCESS, countryService.getCountry(id));
  }

}
