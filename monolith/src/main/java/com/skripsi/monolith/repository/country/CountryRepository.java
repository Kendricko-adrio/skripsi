package com.skripsi.monolith.repository.country;

import com.skripsi.monolith.model.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CountryRepository extends JpaRepository<Country, BigInteger> {

}
