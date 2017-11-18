package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.entity.User;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/User")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ResponseEntity<List<User>> getListOfUser(){
        List<User> users = userService.getAllUsers();
        if (users != null){
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
    }
}
