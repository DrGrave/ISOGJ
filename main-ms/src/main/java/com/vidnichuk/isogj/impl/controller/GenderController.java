package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.entity.Gender;
import com.vidnichuk.isogj.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Gender")
public class GenderController {

    @Autowired
    private GenderService genderService;

    /**
     * request:
     * /Gender/
     * @return
     * list of all genders
     */
    @GetMapping("/")
    public ResponseEntity<List<Gender>> getListOfGenders(){
        List<Gender> genderList = genderService.getListOfGenders();
        if (genderList != null){
            return new ResponseEntity<List<Gender>>(genderList, HttpStatus.OK);
        }return new ResponseEntity<List<Gender>>(HttpStatus.NOT_FOUND);
    }

}
