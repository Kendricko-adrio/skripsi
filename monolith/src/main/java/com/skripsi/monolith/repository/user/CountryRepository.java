package com.skripsi.monolith.repository.user;

import com.skripsi.monolith.model.user.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CountryRepository extends JpaRepository<Country, BigInteger> {

}
