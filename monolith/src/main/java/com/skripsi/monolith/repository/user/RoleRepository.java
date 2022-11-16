package com.skripsi.monolith.repository.user;

import com.skripsi.monolith.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Role, BigInteger> {
}
