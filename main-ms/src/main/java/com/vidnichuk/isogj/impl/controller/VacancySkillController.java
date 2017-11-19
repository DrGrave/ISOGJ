package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.VacancySkill;
import com.vidnichuk.isogj.api.service.VacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/VacancySkill")
public class VacancySkillController {
    @Autowired
    private VacancySkillService vacancySkillService;

    /**
     * request
     * /VacancySkill/
     * @return
     * all vacancy skills
     */
    @GetMapping("/")
    public ResponseEntity<List<VacancySkill>> getAllVacancySkill(){
        List<VacancySkill> vacancySkillList = vacancySkillService.getAllVacancySkill();
        if (vacancySkillList != null){
            return new ResponseEntity<List<VacancySkill>>(vacancySkillList, HttpStatus.OK);
        } return new ResponseEntity<List<VacancySkill>>(HttpStatus.NOT_FOUND);
    }
}
