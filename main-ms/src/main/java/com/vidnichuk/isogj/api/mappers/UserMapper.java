package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "userName", source = "user.userName"),
            @Mapping(target = "userSurname", source = "user.userSurname"),
            @Mapping(target = "userLastName", source = "user.userPatronymic"),
    })
    UserDTO userToUserDTO(User user);

    @Mappings({
            @Mapping(target = "userId", source = "userDTO.userId"),
            @Mapping(target = "userName", source = "userDTO.userName"),
            @Mapping(target = "userSurname", source = "userDTO.userSurname"),
            @Mapping(target = "userPatronymic", source = "userDTO.userLastName"),
    })
    User userDTOtoUser(UserDTO userDTO);

    List<User> convertToListOfUserFromListOfUserDTO(List<UserDTO> userDTOList);

    List<UserDTO> convertFromListOfUserDTOtoListOfUser(List<User> userList);

}
