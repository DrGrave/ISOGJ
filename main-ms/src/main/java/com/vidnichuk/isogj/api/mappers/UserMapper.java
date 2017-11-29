package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * mapper to user object
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     *
     * @param user
     * map user object
     * @return
     * user DTO
     */
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "userName", source = "user.userName"),
            @Mapping(target = "userSurname", source = "user.userSurname"),
            @Mapping(target = "userLastName", source = "user.userPatronymic"),
    })
    UserDTO userToUserDTO(User user);

    /**
     *
     * @param userDTO
     * map user DTO
     * @return
     * user object
     */
    @Mappings({
            @Mapping(target = "userId", source = "userDTO.userId"),
            @Mapping(target = "userName", source = "userDTO.userName"),
            @Mapping(target = "userSurname", source = "userDTO.userSurname"),
            @Mapping(target = "userPatronymic", source = "userDTO.userLastName"),
    })
    User userDTOtoUser(UserDTO userDTO);

    /**
     *
     * @param userDTOList
     * map user DTO list
     * @return
     * user object
     */
    List<User> convertToListOfUserFromListOfUserDTO(List<UserDTO> userDTOList);

    /**
     *
     * @param userList
     * map user objects list
     * @return
     * user DTO list
     */
    List<UserDTO> convertFromListOfUserDTOtoListOfUser(List<User> userList);

}
