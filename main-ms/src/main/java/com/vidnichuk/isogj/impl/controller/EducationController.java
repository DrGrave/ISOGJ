package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.EducationDto;

import com.vidnichuk.isogj.api.dto.model.EducationSkillsDto;
import com.vidnichuk.isogj.api.dto.model.N_A_EducationDto;
import com.vidnichuk.isogj.api.dto.model.TypeOfEducationDto;
import com.vidnichuk.isogj.api.service.education.EducationLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping(path = "/education")
public class EducationController {

    @Autowired
    private EducationLightWeightService educationLightWeightService;

    @GetMapping("/")
    public List<EducationDto> findEducationByUserId(@RequestParam("id") String id){
        return educationLightWeightService.getEducationById(id);
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userlist")
    public List<N_A_EducationDto> findLastEducationByUserId(@RequestParam("id") String id){
        return educationLightWeightService.getLastEducationByUserId(id);
    }

    @GetMapping("/types")
    public List<TypeOfEducationDto> getAllTypesOfEducation(){
        return educationLightWeightService.getAllTypesOfEducation();
    }

    @PostMapping("/change")
    public List<EducationDto> changeEducation(@Valid @RequestBody EducationDto educationDto, @RequestParam("id") String id){
        return educationLightWeightService.changeEducation(educationDto, id);
    }

    @PostMapping("/add")
    public List<EducationSkillsDto> addEducation(@Valid @RequestBody EducationDto educationDto, Principal principal){
        return educationLightWeightService.addEducation(educationDto, principal.getName());
    }

    @GetMapping("/delete")
    public List<EducationSkillsDto> deleteEducation(Principal principal, @RequestParam("educateId") Long id){
        return educationLightWeightService.deleteEducation(principal.getName(), id);
    }

}
