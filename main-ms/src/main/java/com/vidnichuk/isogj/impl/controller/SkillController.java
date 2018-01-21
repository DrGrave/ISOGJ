package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.model.Skill;
import com.vidnichuk.isogj.api.model.type.TypeOfSkill;
import com.vidnichuk.isogj.api.service.skill.SkillLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/authorize/typesofskills")
    public List<TypeOfSkill> getTypesOfSkill(){
        return skillLightWeightService.getAllTypesOfSkill();
    }

    @PostMapping("/authorize/addnew")
    public void addNewSkill(@Valid @RequestBody Skill skill){
        skillLightWeightService.addNewSkill(skill);
    }
}
