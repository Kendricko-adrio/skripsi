package com.federated.users.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.federated.users.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity {

  private BigInteger id;
  private String username;
  private String email;
  private String password;
  private String name;
  private Country country;
  private Role role;
}
