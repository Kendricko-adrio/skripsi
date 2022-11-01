package com.skripsi.monolith.repository;

import com.skripsi.monolith.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CountryRepository extends JpaRepository<Country, BigInteger> {

}
