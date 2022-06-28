package ru.startup.dto.auth;

import lombok.Getter;
import lombok.Setter;
import ru.startup.model.auth.Role;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String userName;

    private String mail;

    private Role role;
}