package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.University;
import com.vidnichuk.isogj.api.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/University")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    /**
     * request
     * /University/
     * @return
     * all university
     */
    @GetMapping("/")
    public ResponseEntity<List<University>> getAllUniversity(){
        List<University> universityList = universityService.getAllUniversity();
        if (universityList != null){
            return new ResponseEntity<List<University>>(universityList, HttpStatus.OK);
        } return new ResponseEntity<List<University>>(HttpStatus.NOT_FOUND);
    }
}
