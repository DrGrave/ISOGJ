package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;


import java.util.ArrayList;
import java.util.List;


public class UserMapperImpl implements UserMapper{

    /**
     *
     * @param user
     * map user object
     * @return
     * user DTO
     */
    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserLastName(user.getUserPatronymic());
        userDTO.setUserSurname(user.getUserSurname());
        return userDTO;
    }

    /**
     *
     * @param userDTO
     * map user DTO
     * @return
     * user object
     */
    @Override
    public User userDTOtoUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        } else {
        User user = new User();
            user.setUserName(userDTO.getUserName());
            user.setUserSurname(userDTO.getUserSurname());
            user.setUserPatronymic(userDTO.getUserLastName());
            return user;
        }

    }

    /**
     *
     * @param userDTOList
     * map user DTO list
     * @return
     * user objects list
     */
    @Override
    public List<User> convertToListOfUserFromListOfUserDTO(List<UserDTO> userDTOList) {
        if (userDTOList == null){
            return null;
        }else{
            List<User> users = new ArrayList<>();
            for (UserDTO userDTO : userDTOList){
                users.add(userDTOtoUser(userDTO));
            }
            return users;
        }
    }

    /**
     *
     * @param userList
     * map user objects list
     * @return
     * user DTO list
     */
    @Override
    public List<UserDTO> convertFromListOfUserDTOtoListOfUser(List<User> userList) {
        if (userList == null){
            return null;
        }else {
         List<UserDTO> userDTOList = new ArrayList<>();
         for (User user : userList){
             userDTOList.add(userToUserDTO(user));
         }
         return userDTOList;
        }
    }
}
