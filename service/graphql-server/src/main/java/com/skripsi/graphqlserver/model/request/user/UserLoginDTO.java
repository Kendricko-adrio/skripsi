package com.skripsi.graphqlserver.model.request.user;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String username;
    private String password;
}
