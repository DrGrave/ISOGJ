package com.vidnichuk.isogj.mapperTest;

import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.mappers.UserMapper;
import com.vidnichuk.isogj.api.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * test to User DTO mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserMapperDtoTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    UserService userService;

    /**
     * try to map from entity to DTO
     */
    @Test
    public void fromUserToUserDto(){
        User user = userService.findById(userService.getAllUsers().get(0).getUserId());
        UserDTO userDTO = userMapper.userToUserDTO(user);
        System.out.print(userDTO.getUserId());
    }

    /**
     * try to map from DTO to entity
     */
    @Test
    public void fromUserDtoToUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserSurname("Vidnichuk");
        userDTO.setUserName("Vadim");
        userDTO.setUserLastName("Mikalaevich");
        User user = userMapper.userDTOtoUser(userDTO);
        System.out.print(user);
    }

}
