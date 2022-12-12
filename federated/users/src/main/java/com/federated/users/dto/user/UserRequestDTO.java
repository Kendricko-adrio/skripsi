package com.federated.users.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class UserRequestDTO {
    private String id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String countryId;
    private String roleId;
}
