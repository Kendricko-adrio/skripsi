package com.federated.users.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federated.users.model.Response;
import com.federated.users.model.user.Country;
import com.federated.users.model.user.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CountryService extends ExternalBaseService{

    @Value("${external.country.url}")
    private String baseUrl;

    private ObjectMapper mapper = new ObjectMapper();

    public List<Country> getCountries(){
        Response response = hitExternalService(baseUrl, HttpMethod.GET, null,null, Response.class);
        System.out.println(response.getData());
        List<Country> countries = mapper.convertValue(response.getData(), mapper.getTypeFactory().constructCollectionType(List.class, Country.class));
        return countries;
    }

    public Country getCountry(BigInteger id){
        Response response = hitExternalService(baseUrl + "/" + id, HttpMethod.GET, null,null, Response.class);
        Country country = mapper.convertValue(response.getData(), Country.class);
        return country;
    }
}
