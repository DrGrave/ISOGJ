package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


//    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("/current")
    public OAuth2Authentication current(OAuth2Authentication principal) {
        return principal;
    }
}
