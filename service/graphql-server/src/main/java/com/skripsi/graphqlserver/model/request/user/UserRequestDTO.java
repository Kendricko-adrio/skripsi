package com.skripsi.graphqlserver.model.request.user;

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
    private BigInteger countryId;
    private BigInteger roleId;
}
