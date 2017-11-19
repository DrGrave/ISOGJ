package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.School;
import com.vidnichuk.isogj.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/School")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /**
     * request
     * /School/
     * @return
     * all schools
     */
    @GetMapping("/")
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> schoolList = schoolService.getAllSchools();
        if (schoolList != null){
            return new ResponseEntity<List<School>>(schoolList, HttpStatus.OK);
        } return new ResponseEntity<List<School>>(HttpStatus.NOT_FOUND);
    }
}
