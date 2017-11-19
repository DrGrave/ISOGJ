package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Faculty;
import com.vidnichuk.isogj.api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    /**
     * request
     * /Faculty/
     * @return
     * all faculty
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        List<Faculty> facultyList = facultyService.getAllFaculty();
        if (facultyList != null){
            return new ResponseEntity<List<Faculty>>(facultyList, HttpStatus.OK);
        }return new ResponseEntity<List<Faculty>>(HttpStatus.NOT_FOUND);
    }
}
