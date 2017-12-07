package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.model.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * mapper to user object
 */

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    /**
     *
     * @param user
     * map user object
     * @return
     * user DTO
     */

    UserDto userToUserDTO(User user);

    /**
     *
     * @param userDto
     * map user DTO
     * @return
     * user object
     */
    User userDTOtoUser(UserDto userDto);

    /**
     *
     * @param userDtoList
     * map user DTO list
     * @return
     * user object
     */
    List<User> convertToListOfUserFromListOfUserDTO(List<UserDto> userDtoList);

    /**
     *
     * @param userList
     * map user objects list
     * @return
     * user DTO list
     */
    List<UserDto> convertFromListOfUserDTOtoListOfUser(List<User> userList);

}
