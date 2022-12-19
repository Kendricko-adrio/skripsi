package com.skripsi.graphqlserver.model.request.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class UserRequestDTO {
    private BigInteger id;
    private String username;
    private String name;
    private String password;
    private String email;

    @JsonProperty("country_id")
    private BigInteger countryId;

    @JsonProperty("role_id")
    private BigInteger roleId;
}
