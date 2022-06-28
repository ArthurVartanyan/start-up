package ru.startup.service.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.startup.dto.auth.AuthenticationRequestDTO;
import ru.startup.dto.auth.RegistrationUserDTO;
import ru.startup.dto.auth.UserDTO;
import ru.startup.exception.BadRequestException;
import ru.startup.exception.EntityNotFoundException;
import ru.startup.mapper.UserMapper;
import ru.startup.model.auth.Role;
import ru.startup.model.auth.User;
import ru.startup.repository.UserRepository;
import ru.startup.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public Map<String, String> authorization(AuthenticationRequestDTO requestDto) {
        try {
            String login = requestDto.getUserName();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login, "{noop}" + requestDto.getPassword()));

            User user = findByLogin(login);

            if (user == null) {
                throw new AuthenticationServiceException("NULL!");
            }

            String token = jwtTokenProvider.createToken(login, user.getRole());

            Map<String, String> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return response;

        } catch (AuthenticationServiceException e) {
            log.error("Error: ", e);
            throw new AuthenticationServiceException("Invalid login");
        }
    }

    public UserDTO registration(RegistrationUserDTO registrationUserDTO) {

        User user = userMapper.registrationUserDTOtoUser(registrationUserDTO);

        if (userRepository.findByUserName(registrationUserDTO.getUserName()).isPresent()) {
            throw new BadRequestException("Внимание! Пользователь с таким логином уже сущетсвует!");
        }

        if (registrationUserDTO.getPassword().equals(registrationUserDTO.getCheckPassword())) {
            user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        } else {
            throw new BadRequestException("Внимание! Пароли отличаются!");
        }
        user.setRole(Role.ADMINISTRATOR);
        user.setDeleted(false);

        userRepository.save(user);

        return userMapper.userToUserDTO(user);
    }


    public User findByLogin(String login) {
        return userRepository.findByUserName(login)
                .orElseThrow(() -> new EntityNotFoundException("Внимание! Невозможно найти login: " + login));
    }
}