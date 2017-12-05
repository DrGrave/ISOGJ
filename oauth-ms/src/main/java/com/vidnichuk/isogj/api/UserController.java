package com.vidnichuk.isogj.api;

import com.vidnichuk.isogj.model.User;
import com.vidnichuk.isogj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
