package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.UserDTO;
import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.mappers.UserMapper;
import com.vidnichuk.isogj.api.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/all")
    public List<UserDTO> getListOfUser(){
        List<UserDTO> users = userService.getAllUsers();
        if (users != null){
            return users;
        }return null;
    }
}
