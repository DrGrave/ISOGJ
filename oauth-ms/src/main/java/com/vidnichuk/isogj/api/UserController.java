package com.vidnichuk.isogj.api;

import com.vidnichuk.isogj.model.User;
import com.vidnichuk.isogj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


//    @PreAuthorize("#oauth2.hasScope('api')")
    @GetMapping("/current")
    public User current(Principal principal) {
        return userService.loadUserByUsername(principal.getName());
    }
}
