package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.EducationDto;

import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/education")
public class EducationController {

    @Autowired
    private EducationLightWeightService educationLightWeightService;

    @GetMapping("/")
    public List<EducationDto> findEducationByUserId(@RequestParam("id") long id){
        return educationLightWeightService.getEducationById(id);
    }
}
