package ru.startup.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.startup.dto.auth.AuthenticationRequestDTO;
import ru.startup.dto.auth.RegistrationUserDTO;
import ru.startup.dto.auth.UserDTO;
import ru.startup.service.auth.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/auth")
    public ResponseEntity<Map<String, String>> authorization(
            @RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        return new ResponseEntity<>(userService.authorization(authenticationRequestDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<UserDTO> registration(@RequestBody RegistrationUserDTO registrationUserDTO) {
        return new ResponseEntity<>(userService.registration(registrationUserDTO), HttpStatus.CREATED);
    }
}