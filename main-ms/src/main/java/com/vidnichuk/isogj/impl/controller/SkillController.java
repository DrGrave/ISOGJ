package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/skill")
public class SkillController {

    @Autowired
    private SkillLightWeightService skillLightWeightService;

    @GetMapping("/add")
    public List<Skill> getUserWithMoreInformation(@RequestParam("name") String name){
        return skillLightWeightService.findAddSkill(name);
    }
}
