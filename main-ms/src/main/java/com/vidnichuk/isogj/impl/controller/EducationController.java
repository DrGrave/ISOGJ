package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Education;
import com.vidnichuk.isogj.api.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    /**
     * request
     * /Education/
     * @return
     * all education
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<Education>> getAllEducation(){
        List<Education> educationList = educationService.getAllEducation();
        if (educationList != null){
            return new ResponseEntity<List<Education>>(educationList, HttpStatus.OK);
        }return new ResponseEntity<List<Education>>(HttpStatus.NOT_FOUND);
    }

}
