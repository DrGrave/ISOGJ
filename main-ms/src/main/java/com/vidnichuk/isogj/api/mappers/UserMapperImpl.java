package com.vidnichuk.isogj.api.mappers;

import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;


import java.util.ArrayList;
import java.util.List;


public class UserMapperImpl implements UserMapper{

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
