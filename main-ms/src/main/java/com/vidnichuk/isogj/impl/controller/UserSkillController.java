package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.model.SkillDto;
import com.vidnichuk.isogj.api.dto.model.UserSkillDto;

import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/skill")
public class UserSkillController {

    @Autowired
    private SkillLightWeightService skillLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userskills")
    public List<UserSkillDto> findUserSkillsById(@RequestParam("id") String id){
        return skillLightWeightService.findAllSkillsById(id);
    }

    @GetMapping("/authorize/userskills")
    public List<UserSkillDto> authorizedFindUserSkillsById(@RequestParam("id") String id){
        return skillLightWeightService.findAuthorizedUserSkillsById(id);
    }

    @PostMapping("/authorize/add")
    public List<UserSkillDto> authorizedAddedUserSkills(@Valid @RequestBody SkillDto skill, @RequestParam("id") String id){
        return skillLightWeightService.addAndGetSkillsToUser(skill, id);
    }

    @PostMapping("/authorize/delete")
    public List<UserSkillDto> authorizedDeleteUserSkill(@Valid @RequestBody UserSkillDto userSkillDto, @RequestParam("id") String id){
        return skillLightWeightService.deleteSkills(userSkillDto, id);
    }
}
