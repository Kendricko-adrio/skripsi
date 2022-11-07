package com.skripsi.monolith.repository.role;

import com.skripsi.monolith.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface RoleRepository extends JpaRepository<Role, BigInteger> {
}
