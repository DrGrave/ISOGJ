package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.model.City;
import com.vidnichuk.isogj.api.model.UserCompany;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserLightWeightService userLightWeightService;


    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @PostMapping("/register")
    public boolean registerUser(@Valid @RequestBody TempUserDto tempUserDto) {
        return userLightWeightService.registerUser(tempUserDto);
    }
    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @PostMapping("/count")
    public long countOfPublicUser(){
        return userLightWeightService.getCountOfPublicUser();
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checklogin")
    public boolean checkLogin(@RequestParam("username") String username) {
        return userLightWeightService.checkUsername(username);
    }


    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checkemail")
    public boolean checkEmail(@RequestParam("email") String email) {
        return userLightWeightService.checkEmail(email);
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @PostMapping("/confirm")
    public StatusDto approveRegister(@RequestParam("link") String link) {
        userLightWeightService.approveRegistration(link);
        return new StatusDto("ok");
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/all")
    public List<UserDto> getAllUser(@RequestParam("page") int page, @RequestParam("size") int size){
        return userLightWeightService.getAllUsers(page, size);
    }

    @GetMapping("/moreuserinfo")
    public UserDto getUserWithMoreInformation(@RequestParam("id") Long id){
        return userLightWeightService.getUserWithMoreInformation(id);
    }

    @GetMapping("/me")
    public MeUserDto getUserByUsername(@RequestParam("username") String username){
        return userLightWeightService.getUserByUsername(username);
    }

    @PostMapping("/changegender")
    public GenderDto setNewGender(@Valid @RequestBody GenderDto gender, @RequestParam("id") long id){
        return userLightWeightService.changeGender(gender, id);
    }

    @PostMapping("/city")
    public CityDto applyCity(@Valid @RequestBody CityDto cityDto, @RequestParam("id") long id){
        return userLightWeightService.changeCity(cityDto, id);
    }




}
