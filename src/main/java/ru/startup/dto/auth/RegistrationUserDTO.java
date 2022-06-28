package ru.startup.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationUserDTO {

    private String firstName;

    private String lastName;

    private String patronymic;

    private String userName;

    private String password;

    private String checkPassword;
}