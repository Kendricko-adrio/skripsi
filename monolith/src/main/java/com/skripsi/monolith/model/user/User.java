package com.skripsi.monolith.model.user;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private BigInteger id;
    private String username;
    private String password;
    private String email;

}
