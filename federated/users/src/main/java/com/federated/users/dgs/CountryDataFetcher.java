package com.federated.users.dgs;

import com.federated.users.model.user.Country;
import com.federated.users.model.user.User;
import com.federated.users.service.CountryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@DgsComponent
public class CountryDataFetcher {

    @Autowired
    private CountryService countryService;

    @DgsEntityFetcher(name = "Country")
    public Country getCountry(Map<String, Object> values) {
        String id = (String) values.get("id");
        return countryService.getCountry(new BigInteger(id));
    }

    @DgsQuery
    public List<Country> getCountries(){
        return countryService.getCountries();
    }
}
