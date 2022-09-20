package com.skripsi.monolith.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
}
