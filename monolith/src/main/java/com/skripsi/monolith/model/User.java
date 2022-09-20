package com.skripsi.monolith.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private BigInteger id;
    private String username;
    private String password;
    private String email;

}
