package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.EducationDto;

import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userlist")
    public List<N_A_EducationDto> findLastEducationByUserId(@RequestParam("id") long id){
        return educationLightWeightService.getLastEducationByUserId(id);
    }

    @GetMapping("/types")
    public List<TypeOfEducationDto> getAllTypesOfEducation(){
        return educationLightWeightService.getAllTypesOfEducation();
    }

    @PostMapping("/change")
    public void changeEducation(@Valid @RequestBody EducationDto educationDto, @RequestParam("id") Long id){
        educationLightWeightService.changeEducation(educationDto, id);
    }

    @PostMapping("/add")
    public void addEducation(@Valid @RequestBody EducationDto educationDto, @RequestParam("id") Long id){
        educationLightWeightService.addEducation(educationDto, id);
    }

}
