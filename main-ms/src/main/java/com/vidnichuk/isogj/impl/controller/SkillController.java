package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.Skill;
import com.vidnichuk.isogj.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    /**
     * request
     * /Skill/
     * @return
     * all skills
     */
    @GetMapping("/")
    public ResponseEntity<List<Skill>> getAllSkills(){
        List<Skill> skillList = skillService.getAllSkill();
        if (skillList != null){
            return new ResponseEntity<List<Skill>>(skillList, HttpStatus.OK);
        } return new ResponseEntity<List<Skill>>(HttpStatus.NOT_FOUND);
    }
}
