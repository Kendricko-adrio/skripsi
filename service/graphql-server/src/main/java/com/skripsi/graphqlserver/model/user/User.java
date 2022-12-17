package com.skripsi.graphqlserver.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skripsi.graphqlserver.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
  private BigInteger id;

  private String username;

  private String email;

  private String password;

  private String name;

  private Country country;

  private Role role;

  //  private List<Notification> notifications;

}
