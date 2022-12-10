package com.skripsi.userskripsi.repository;

import com.skripsi.userskripsi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Role, BigInteger> {
}
