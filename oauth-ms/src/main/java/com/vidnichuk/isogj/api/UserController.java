package com.vidnichuk.isogj.api;

import com.vidnichuk.isogj.model.User;
import com.vidnichuk.isogj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
