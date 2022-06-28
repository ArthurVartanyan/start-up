package ru.startup.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDTO {

    private String userName;

    private String password;
}