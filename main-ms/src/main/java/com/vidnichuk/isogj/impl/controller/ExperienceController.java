package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Experience;
import com.vidnichuk.isogj.api.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    /**
     * request
     * /Experience/
     * @return
     * all experience
     */
    @GetMapping(name = "/")
    public ResponseEntity<List<Experience>> getAllExperience(){
        List<Experience> experienceList = experienceService.getAllExperience();
        if (experienceList != null){
            return new ResponseEntity<List<Experience>>(experienceList, HttpStatus.OK);
        }return new ResponseEntity<List<Experience>>(HttpStatus.NOT_FOUND);
    }
}
