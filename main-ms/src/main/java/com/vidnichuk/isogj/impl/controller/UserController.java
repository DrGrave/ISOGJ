package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserLightWeightService userLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONIMOUS')")
    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody TempUserDTO tempUserDTO) {
        userLightWeightService.registerUser(tempUserDTO);
    }


}
