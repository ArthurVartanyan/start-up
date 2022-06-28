package ru.startup.security;

import ru.startup.model.auth.User;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getUserName(),
                user.getPassword(),
                user.getRole(),
                user.isDeleted()
        );
    }
}