package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Gender;
import com.vidnichuk.isogj.api.entity.TypeOfUser;
import com.vidnichuk.isogj.api.service.TypeOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/TypeOfUser")
public class TypeOfUserController {
    @Autowired
    private TypeOfUserService typeOfUserService;

    /**
     * request:
     * /TypeOfUser/
     *
     * @return
     * list of all types of user
     */
    @GetMapping("/")
    public ResponseEntity<List<TypeOfUser>> getListTypesOfUser(){
        List<TypeOfUser> typeOfUsers = typeOfUserService.getAllTypeOfUser();
        if (typeOfUsers != null){
            return new ResponseEntity<List<TypeOfUser>>(typeOfUsers, HttpStatus.OK);
        }return new ResponseEntity<List<TypeOfUser>>(HttpStatus.NOT_FOUND);
    }
}
