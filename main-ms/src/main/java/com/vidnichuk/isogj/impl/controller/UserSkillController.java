package com.vidnichuk.isogj.impl.controller;


import com.vidnichuk.isogj.api.dto.model.UserSkillDto;
import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/skill")
public class UserSkillController {

    @Autowired
    private SkillLightWeightService skillLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/userskills")
    public List<UserSkillDto> findUserSkillsById(@RequestParam("id") long id){
        return skillLightWeightService.findAllSkillsById(id);
    }
}
