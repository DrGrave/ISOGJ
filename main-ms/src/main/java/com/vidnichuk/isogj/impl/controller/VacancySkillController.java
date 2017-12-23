package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.VacancySkillDto;
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
public class VacancySkillController {
    @Autowired
    private SkillLightWeightService skillLightWeightService;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/vacancyskills")
    public List<VacancySkillDto> findAllSkillsToVacancy(@RequestParam("id") Long id){
        return skillLightWeightService.findAllVacancySkillsById(id);
    }
}
