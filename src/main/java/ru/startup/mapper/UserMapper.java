package ru.startup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.startup.dto.auth.RegistrationUserDTO;
import ru.startup.dto.auth.UserDTO;
import ru.startup.model.auth.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User registrationUserDTOtoUser(RegistrationUserDTO registrationUserDTO);

    UserDTO userToUserDTO(User user);
}
