package com.skripsi.userskripsi.model.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {

  private BigInteger id;

  private String username;

  private String name;

  private String email;

  private BigInteger countryId;

  private BigInteger roleId;

}
