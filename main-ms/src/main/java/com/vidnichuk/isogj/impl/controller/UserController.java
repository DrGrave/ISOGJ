package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.TempUserDto;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registerUser(@Valid @RequestBody TempUserDto tempUserDto) {
        userLightWeightService.registerUser(tempUserDto);
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

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/register")
    public void approveRegister(@RequestParam("link") String link){
        userLightWeightService.approveRegistration(link);
    }
}
