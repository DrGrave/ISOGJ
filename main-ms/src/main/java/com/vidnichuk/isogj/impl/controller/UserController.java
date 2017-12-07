package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.TempUserDTO;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import com.vidnichuk.isogj.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserLightWeightService userLightWeightService;




    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody TempUserDTO tempUserDTO) {
        userLightWeightService.registerUser(tempUserDTO);
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checklogin")
    public boolean checkLogin(@RequestParam("username") String username){
       return userLightWeightService.checkUsername(username);
    }


    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checkemail")
    public boolean checkEmail(@RequestParam("email") String email){
       return userLightWeightService.checkEmail(email);
    }
}
