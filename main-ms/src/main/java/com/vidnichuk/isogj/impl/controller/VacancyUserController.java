package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.VacancyUser;
import com.vidnichuk.isogj.api.service.VacancyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/VacancyUser")
public class VacancyUserController {
    @Autowired
    private VacancyUserService vacancyUserService;

    /**
     * request
     * /VacancyUser/
     * @return
     * all vacancy users
     */
    @GetMapping("/")
    public ResponseEntity<List<VacancyUser>> getAllVacancyUser(){
        List<VacancyUser> vacancyUserList = vacancyUserService.getAllVacancyUser();
        if (vacancyUserList != null){
            return new ResponseEntity<List<VacancyUser>>(vacancyUserList, HttpStatus.OK);
        } return new ResponseEntity<List<VacancyUser>>(HttpStatus.NOT_FOUND);
    }
}
