package com.skripsi.monolith.repository.user;

import com.skripsi.monolith.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    public Optional<User> findFirstByUsername(String username);

}
