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

    UserDTO userToUserDTO(User user);

    /**
     *
     * @param userDTO
     * map user DTO
     * @return
     * user object
     */
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
