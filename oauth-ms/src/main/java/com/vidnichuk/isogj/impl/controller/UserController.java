package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.service.UserLightWeightService;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserLightWeightService userLightWeightService;


    @PreAuthorize("#oauth2.hasScope('server')")
    @PostMapping("/create")
    public Long createUser(@Valid @RequestBody UserDto userDto) {
        return userLightWeightService.createUser(userDto);
    }


    @GetMapping("/current")
    public OAuth2Authentication current(OAuth2Authentication principal) {
        return principal;
    }
}
