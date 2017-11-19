package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.entity.*;
import com.vidnichuk.isogj.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Type")
public class TypesController {
    @Autowired
    private TypeOfAcceptedService typeOfAcceptedService;
    @Autowired
    private TypeOfEducationService typeOfEducationService;
    @Autowired
    private TypeOfSkillService typeOfSkillService;
    @Autowired
    private TypeOfTaskService typeOfTaskService;
    @Autowired
    private TypeOfVacancyService typeOfVacancyService;

    /**
     * request
     * /Type/Accepted/
     * @return
     * all types of accepted
     */
    @GetMapping("/Accepted/")
    public ResponseEntity<List<TypeOfAccepted>> getAllTypesOfAccepted(){
        List<TypeOfAccepted> typeOfAcceptedList = typeOfAcceptedService.getAllTypeOfAccepted();
        if (typeOfAcceptedList != null){
            return new ResponseEntity<List<TypeOfAccepted>>(typeOfAcceptedList, HttpStatus.OK);
        }return new ResponseEntity<List<TypeOfAccepted>>(HttpStatus.NOT_FOUND);
    }

    /**
     * request
     * /Type/Education/
     * @return
     * all types of educations
     */
    @GetMapping("/Education/")
    public ResponseEntity<List<TypeOfEducation>> getAllTypesOfEducation(){
        List<TypeOfEducation> typeOfEducationList = typeOfEducationService.getAllTypeOfEducation();
        if (typeOfEducationList != null){
            return new ResponseEntity<List<TypeOfEducation>>(typeOfEducationList, HttpStatus.OK);
        } return new ResponseEntity<List<TypeOfEducation>>(HttpStatus.NOT_FOUND);
    }

    /**
     * request
     * /Type/Skill/
     * @return
     * all types of skill
     */
    @GetMapping("/Skill/")
    public ResponseEntity<List<TypeOfSkill>> getAllTypesOfSkill(){
        List<TypeOfSkill> typeOfSkillList = typeOfSkillService.getAllTypeOfSlills();
        if (typeOfSkillList != null){
            return new ResponseEntity<List<TypeOfSkill>>(typeOfSkillList, HttpStatus.OK);
        } return new ResponseEntity<List<TypeOfSkill>>(HttpStatus.NOT_FOUND);
    }

    /**
     * request
     * /Type/Task/
     * @return
     * all types of task
     */
    @GetMapping("/Task/")
    public ResponseEntity<List<TypeOfTask>> getAllTypesOfTask(){
        List<TypeOfTask> typeOfTaskList = typeOfTaskService.getAllTypeOfTask();
        if (typeOfTaskList != null){
            return new ResponseEntity<List<TypeOfTask>>(typeOfTaskList, HttpStatus.OK);
        }return new ResponseEntity<List<TypeOfTask>>(HttpStatus.NOT_FOUND);
    }

    /**
     * request
     * /Type/Vacancy/
     * @return
     * all types of vacancy
     */
    @GetMapping("/Vacancy/")
    public ResponseEntity<List<TypeOfVacancy>> getAllTypesOfVacancy(){
        List<TypeOfVacancy> typeOfVacancyList = typeOfVacancyService.getAllTypeOfVacancy();
        if (typeOfVacancyList != null){
            return new ResponseEntity<List<TypeOfVacancy>>(typeOfVacancyList, HttpStatus.OK);
        } return new ResponseEntity<List<TypeOfVacancy>>(HttpStatus.NOT_FOUND);
    }
}
