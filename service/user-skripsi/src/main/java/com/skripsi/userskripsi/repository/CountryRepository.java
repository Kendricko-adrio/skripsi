package com.skripsi.userskripsi.repository;

import com.skripsi.userskripsi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CountryRepository extends JpaRepository<Country, BigInteger> {

}
